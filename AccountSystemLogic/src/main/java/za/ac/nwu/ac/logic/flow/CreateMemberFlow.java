package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountMemberDto;

public interface CreateMemberFlow {

    AccountMemberDto create(AccountMemberDto accountMemberDto);
}
