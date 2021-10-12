package za.ac.nwu.ac.translate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.domain.persistence.AccountMember;
import za.ac.nwu.ac.repo.persistence.AccountMemberRepository;
import za.ac.nwu.ac.translate.AccountMemberTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMemberTranslatorImpl implements AccountMemberTranslator {

    private final AccountMemberRepository accountMemberRepository;

    @Autowired
    public AccountMemberTranslatorImpl(AccountMemberRepository accountMemberRepository){
        this.accountMemberRepository = accountMemberRepository;
    }

    @Override
    public List<AccountMemberDto> getAllAccountMembers(){
        List<AccountMemberDto> accountMemberDtos = new ArrayList<>();
        try{
            for (AccountMember accountMember : accountMemberRepository.findAll()){
                accountMemberDtos.add(new AccountMemberDto(accountMember));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the Database!",e);
        }

        return accountMemberDtos;
    }

    @Override
    public AccountMemberDto create(AccountMemberDto accountMemberDto){
        try{
            AccountMember accountMember = accountMemberRepository.save(accountMemberDto.getAccountMember());
            return new AccountMemberDto(accountMember);
        } catch (Exception e){
            throw new RuntimeException("Unable to save to Database!",e);
        }
    }



}
