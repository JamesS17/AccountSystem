package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountMemberDto;

import java.util.List;

public interface FetchMemberFlow {
    List<AccountMemberDto> getAllAccountMembers();
}
