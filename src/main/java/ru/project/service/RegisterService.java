package ru.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.dto.*;
import ru.project.mapper.CSAccountMapper;
import ru.project.mapper.ProductRegisterMapper;
import ru.project.model.*;
import ru.project.exceptions.BadFieldValueException;
import ru.project.repo.TppProductRegisterRepo;
import ru.project.repo.TppRefProductRegisterTypeRepo;

import java.util.List;

@Service
public class RegisterService {
    @Autowired
    TppRefProductRegisterTypeRepo registerTypeRepo;
    @Autowired
    TppProductRegisterRepo registerRepo;

    @Autowired
    AccountPoolService accountPoolService;

    @Autowired
    ProductRegisterMapper registerMapper;

    @Autowired
    CSAccountMapper csaAccountMapper;

    public List<Long> getProductRegisterIds(CorporateSettlementInstance csi){
        return registerRepo.getRegisterIdsByProduct(csi.getInstanceId());
    }

    public List<TppRefProductRegisterType> getRegisterTypeListOrThrow(String productCode, String accountType){
        List<TppRefProductRegisterType> list = registerTypeRepo.findByProductClassCodeAndAccountType(productCode, accountType);
        if (list.size() > 0 ) return list;
        throw new BadFieldValueException("КодПродукта '"+productCode+"' не найдено в Каталоге продуктов tpp_ref_product_class");
    }



    public TppProductRegister create(ProductRegisterDTO registerDTO){
        Account account = accountPoolService.getNextAccount(registerDTO.getBranchCode(), registerDTO.getCurrencyCode(), registerDTO.getMdmCode(), registerDTO.getPriorityCode(), registerDTO.getType());
        TppProductRegister registerEntity = registerMapper.toEntity(registerDTO);
        registerEntity.setAccount(account.getId());
        registerEntity.setAccountNumber(account.getAccountNumber());
        registerRepo.save(registerEntity);

        return registerEntity;
    }

    private void registerNotExistsOrThrown(CorporateSettlementAccount csa){
        TppProductRegister register = registerRepo.findFirstByProductIdAndType(csa.getInstanceId(), csa.getAccountType());
        if (register == null) return;
        throw new BadFieldValueException("Параметр registryTypeCode тип регистра '"
                                        + csa.getAccountType()
                                        + "' уже существует для ЭП с ИД  '"
                                        + register.getId() + "'.");
    }

    @Transactional(rollbackFor = {Exception.class})
    public RegisterResponse processRequest(CorporateSettlementAccount csa){
        System.out.println(csa);
        registerNotExistsOrThrown(csa);
        List<TppRefProductRegisterType> registerTypeList = getRegisterTypeListOrThrow(csa.getAccountType(), "Клиентский");
        ProductRegisterDTO registerDTO = csaAccountMapper.toRegisterDTO(csa);
        TppProductRegister registerEntity = create(registerDTO);



        RegisterResponse registerResponse= new RegisterResponse(registerEntity.getAccount().toString());
        return registerResponse;
    }

}
