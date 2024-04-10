package ru.project;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.project.dto.AgreementDTO;
import ru.project.dto.CorporateSettlementInstance;
import ru.project.dto.ProductRegisterDTO;
import ru.project.exceptions.BadFieldValueException;
import ru.project.mapper.InstanceMapper;
import ru.project.model.Account;
import ru.project.model.TppProduct;
import ru.project.model.TppRefProductClass;
import ru.project.model.TppRefProductRegisterType;
import ru.project.repo.TppProductRepo;
import ru.project.repo.TppRefProductClassRepo;
import ru.project.service.AgreementService;
import ru.project.service.ProductService;
import ru.project.service.RegisterService;

import java.util.*;

import static java.util.Optional.ofNullable;
import static org.mockito.Mockito.*;

public class TestProductService {
    static ProductService productService;
    static CorporateSettlementInstance csi;

    static CorporateSettlementInstance getCSI(){
        CorporateSettlementInstance csi = new CorporateSettlementInstance();
        csi.setProductCode("productCode");
        csi.setMdmCode("mdmCode");;
        csi.setContractNumber("contractNumber");
        csi.setBranchCode("branchCode");
        csi.setPriority("priority");
        csi.setInstanceArrangement(new ArrayList<AgreementDTO>());
        csi.getInstanceArrangement().add(AgreementDTO.builder().number("agreementNumber1").build());
        csi.getInstanceArrangement().add(AgreementDTO.builder().number("agreementNumber2").build());
        return csi;
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println(">>>>>>>>>>>>> BeforeAll");

    }

    @BeforeEach
     void beforeEach(){
        TppProductRepo  productRepo = mock(TppProductRepo.class);
        TppRefProductClassRepo productClassRepo = mock(TppRefProductClassRepo.class);
        AgreementService agreementService = mock(AgreementService.class);
        RegisterService registerService =  mock(RegisterService.class);;
        InstanceMapper instanceMapper =  mock(InstanceMapper.class);;

        productService = new ProductService(productRepo, productClassRepo, agreementService, registerService, instanceMapper);

        csi = getCSI();
    }

    @Test
    void testProductExists() {
        // 1. Ловим ошибку что Экземпляр Продукта уже существует
        Mockito.when(productService.getProductRepo().findByNumber("contractNumber")).thenReturn(Arrays.asList(TppProduct.builder().id(1L).build()));
        Assertions.assertThrows(BadFieldValueException.class, () -> productService.processCreateRequest(csi));
    }
    @Test
    void testAgreementExists() {
        // 1. Ловим ошибку что Экземпляр Продукта уже существует
        doThrow(new BadFieldValueException("...")).when(productService.getAgreementService()).checkAgreementNotExistsOrThrow("agreementNumber");
        Assertions.assertThrows(BadFieldValueException.class, () -> productService.processCreateRequest(csi));
    }
    @Test
    void testRegisterTypeNotExists(){
        doThrow(new BadFieldValueException("...")).when(productService.getRegisterService()).getRegisterTypeListOrThrow("productCode", "Клиентский");
        Assertions.assertThrows(BadFieldValueException.class, () -> productService.processCreateRequest(csi));
    }
    @Test
    void testCreateRegister(){
        List<TppRefProductRegisterType> registerTypeList = new ArrayList<>();
        registerTypeList.add(TppRefProductRegisterType.builder().value("registerType1").build());
        registerTypeList.add(TppRefProductRegisterType.builder().value("registerType2").build());

        ProductRegisterDTO registerDTO1 = ProductRegisterDTO.builder().build();
        ProductRegisterDTO registerDTO2 = ProductRegisterDTO.builder().build();
        TppProduct productEntity = TppProduct.builder().id(1L).build();
        TppRefProductClass productClassEntity = TppRefProductClass.builder().internalId(2L).build();

        when(productService.getRegisterService().getRegisterTypeListOrThrow("productCode", "Клиентский")).thenReturn(registerTypeList);
        when(productService.getInstanceMapper().registerMap(csi)).thenReturn(registerDTO1).thenReturn(registerDTO2);
        when(productService.getInstanceMapper().map(csi)).thenReturn(productEntity);
        when(productService.getProductClassRepo().findByValue("productCode")).thenReturn(ofNullable(productClassEntity));
        doAnswer(invocation->{AgreementDTO x= invocation.getArgument(0);
                               x.setProductId(csi.getInstanceId());
                                return null;}
                ).when( productService.getAgreementService()).create(any(AgreementDTO.class));
        productService.processCreateRequest(csi);

        Assertions.assertEquals("registerType1", registerDTO1.getType());
        Assertions.assertEquals("registerType2", registerDTO2.getType());
        csi.getInstanceArrangement().forEach(agreementDTO -> Assertions.assertEquals(csi.getInstanceId(), agreementDTO.getProductId()));

    }

    @Test
    void testOptionsl(){
        Optional<Account> opt = ofNullable(null);

        if (opt.filter(acc -> !acc.getBusy()).isPresent())
            System.out.println("can use");
        else System.out.println("cant use");

    }

}
