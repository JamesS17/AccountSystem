package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;
import za.ac.nwu.ac.translate.AccountMemberTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountMemberImpl implements FetchMemberFlow {

    private final AccountMemberTranslator accountMemberTranslator;

    @Autowired
    public FetchAccountMemberImpl(AccountMemberTranslator accountMemberTranslator){
        this.accountMemberTranslator = accountMemberTranslator;
    }

    @Override
    public List<AccountMemberDto> getAllAccountMembers()
    {
        return accountMemberTranslator.getAllAccountMembers();
    }

    @Override
    public AccountMemberDto getAccountMemberByID(Long memID){
        return accountMemberTranslator.getAccountMemberByIDQuery(memID);
    }
}
