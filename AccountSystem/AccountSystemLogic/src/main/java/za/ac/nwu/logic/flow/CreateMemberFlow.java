package za.ac.nwu.logic.flow;


import za.ac.nwu.domain.dto.MemberDto;

import java.util.List;

public interface CreateMemberFlow
{
    MemberDto create(MemberDto memberDto);
}
