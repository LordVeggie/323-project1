package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;

import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.logic.flow.CreateMemberFlow;
import za.ac.nwu.translator.AccountTypeTranslator;
import za.ac.nwu.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createMemberFlowName")
public class CreateMemberFlowImpl implements CreateMemberFlow
{
    private final MemberTranslator memberTranslator;

    public CreateMemberFlowImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto create (MemberDto memberDto){
        if(null == memberDto.getCreationDate()){
            memberDto.setCreationDate(LocalDate.now());
        }
        return memberTranslator.create(memberDto);
    }

}
