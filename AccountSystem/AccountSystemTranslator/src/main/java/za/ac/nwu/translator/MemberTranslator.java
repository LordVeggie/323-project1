package za.ac.nwu.translator;

import za.ac.nwu.domain.dto.MemberDto;

import java.util.List;

public interface MemberTranslator
{
    List<MemberDto> getAllMembers();
    MemberDto create(MemberDto Member);
    MemberDto getMemberByEmail(String email);
    MemberDto getMemberDtoByeEmail(String email);

}
