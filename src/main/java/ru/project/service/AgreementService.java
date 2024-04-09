package ru.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.mapper.AgreementMapper;
import ru.project.model.Agreement;
import ru.project.exceptions.BadFieldValueException;
import ru.project.dto.AgreementDTO;
import ru.project.dto.CorporateSettlementInstance;
import ru.project.repo.AgreementRepo;

import java.util.List;

@Service
public class AgreementService {

    @Autowired
    AgreementRepo agreementRepo;
    @Autowired
    AgreementMapper agreementMapper;

    public void checkAgreementNotExistsOrThrow(String number){
        List<Agreement> egreementList = agreementRepo.findByNumber(number);
        if (egreementList.size() > 0){
            throw new BadFieldValueException("Параметр № Дополнительного соглашения (сделки) Number '"
                    + number
                    + "' уже существует для ЭП с ИД '"
                    + egreementList.get(0).getId()+"'"
            );
        }
    }

    public List<Long> getProductAgreementIds(CorporateSettlementInstance csi){
        return agreementRepo.getAgreementIdsByProduct(csi.getInstanceId());
    }

    public void create(AgreementDTO arrangement){
        Agreement agreement = agreementMapper.toEntity(arrangement);
        agreementRepo.save(agreement);
    }

}
