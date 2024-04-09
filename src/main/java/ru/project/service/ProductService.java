package ru.project.service;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.dto.ProductRegisterDTO;
import ru.project.mapper.InstanceMapper;
import ru.project.model.*;
import ru.project.exceptions.BadFieldValueException;
import ru.project.exceptions.NoDataFoundException;
import ru.project.dto.CorporateSettlementInstance;
import ru.project.dto.ProductResponse;
import ru.project.repo.*;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Getter
@Setter(onMethod = @__(@Autowired))

public class ProductService {
    private TppProductRepo productRepo;
    private TppRefProductClassRepo productClassRepo;
    private AgreementService agreementService;
    private RegisterService registerService;
    private InstanceMapper instanceMapper;


    private void checkProductNotExistsOrThrow(String contructNumber){
        List<TppProduct> productList = productRepo.findByNumber(contructNumber);
        if (productList.size() > 0){
            throw new BadFieldValueException("Параметр ContractNumber № договора \""
                    + contructNumber
                    + "' уже существует для ЭП с ИД '"
                    + productList.get(0).getId()+"'"
            );
        }
    }

    private TppProduct getProductEntity(CorporateSettlementInstance csi){
        TppRefProductClass productClass = productClassRepo.findByValue(csi.getProductCode());
        TppProduct productEntity = instanceMapper.map(csi);
        productEntity.setProductCodeId(productClass.getInternalId());

        productRepo.save(productEntity);

        return productEntity;

    }

    private void create(CorporateSettlementInstance csi){
        checkProductNotExistsOrThrow(csi.getContractNumber());
        csi.getInstanceArrangement().forEach(agreement -> agreementService.checkAgreementNotExistsOrThrow(agreement.getNumber()));
        List<TppRefProductRegisterType> registerTypeList = registerService.getRegisterTypeListOrThrow(csi.getProductCode(), "Клиентский");

        csi.setInstanceId(getProductEntity(csi).getId());

        registerTypeList.forEach(registerType ->
                                { ProductRegisterDTO registerDTO = instanceMapper.registerMap(csi);
                                  registerDTO.setType(registerType.getValue());
                                  registerService.create(registerDTO);
                                });
        csi.getInstanceArrangement().forEach(agreement ->
                                            { agreement.setProductId(csi.getInstanceId());
                                              agreementService.create(agreement);
                                            });
    }

    private void checkProductExistOrThrow(Long id){

        try {
            TppProduct product = productRepo.findById(id).get();
        }catch(NoSuchElementException e){
            throw new NoDataFoundException("Экземпляр продукта с параметром instanceId '"+id+"' не найден.");
        }

    }

    private void update(CorporateSettlementInstance csi){
        checkProductExistOrThrow(csi.getInstanceId());
        csi.getInstanceArrangement().forEach(agreement->agreementService.checkAgreementNotExistsOrThrow(agreement.getNumber()));
        csi.getInstanceArrangement().forEach(agreement ->
                                            { agreement.setProductId(csi.getInstanceId());
                                                agreementService.create(agreement);
                                            });

    }

    @Transactional(rollbackFor = {Exception.class, NoDataFoundException.class})
    public ProductResponse processCreateRequest(CorporateSettlementInstance csi){
        System.out.println(csi);
        if (csi.getInstanceId() == null){
            create(csi);
        } else{
            update(csi);
        }
        ProductResponse response = new ProductResponse();
        response.setInstanceId(csi.getInstanceId().toString());
        response.setRegisterId( registerService.getProductRegisterIds(csi) );
        response.setSupplementaryAgreementId(agreementService.getProductAgreementIds(csi));
        return response;
    }
}
