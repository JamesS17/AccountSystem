package za.ac.nwu.ac.translate;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;

import java.util.List;

public interface AccountMemberTranslator {
    List<AccountMemberDto> getAllAccountMembers();
    AccountMemberDto create(AccountMemberDto accountMemberDto);

}
