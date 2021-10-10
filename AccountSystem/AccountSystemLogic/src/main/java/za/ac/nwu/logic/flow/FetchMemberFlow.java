package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.MemberDto;

import java.util.List;

public interface FetchMemberFlow
{
    List<MemberDto> getAllMembers();

    MemberDto getMemberByeEmail(String email);

}
