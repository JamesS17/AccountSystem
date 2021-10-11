package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;

import javax.transaction.Transactional;
import java.time.LocalDate;
import za.ac.nwu.ac.translate.AccountMemberTranslator;

@Transactional
@Component("createMemberFlowName")
public class CreateMemberFlowImpl implements CreateMemberFlow {


    private final AccountMemberTranslator accountMemberTranslator;

    public CreateMemberFlowImpl(AccountMemberTranslator accountMemberTranslator){
        this.accountMemberTranslator = accountMemberTranslator;
    }

    @Override
    public AccountMemberDto create(AccountMemberDto accountMemberDto){
        if(null == accountMemberDto.getMemDate()){
            accountMemberDto.setMemDate(LocalDate.now());
        }
        return accountMemberTranslator.create(accountMemberDto);
    }

}
