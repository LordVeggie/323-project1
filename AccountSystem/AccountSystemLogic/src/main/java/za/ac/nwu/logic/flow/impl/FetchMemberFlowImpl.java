package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.logic.flow.FetchMemberFlow;
import za.ac.nwu.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchMemberFlowImpl implements FetchMemberFlow 
{
    private final MemberTranslator memberTranslator;

    @Autowired
    public FetchMemberFlowImpl (MemberTranslator memberTranslator)
    {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public List<MemberDto> getAllMembers()
    {
        return memberTranslator.getAllMembers();
    }

    @Override
    public MemberDto getMemberByeEmail(String email)
    {
        return memberTranslator.getMemberDtoByeEmail(email);
    }

}
