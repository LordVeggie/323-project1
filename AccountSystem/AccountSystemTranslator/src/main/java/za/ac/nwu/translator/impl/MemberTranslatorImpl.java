package za.ac.nwu.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.repo.persistence.MemberRepository;
import za.ac.nwu.translator.MemberTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator
{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> getAllMembers()
    {
        List<MemberDto>memberDtos = new ArrayList<>();
        try
        {
            for(Member member : memberRepository.findAll())
            {
                memberDtos.add(new MemberDto(member));
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to read form the DB", e);
        }

        return memberDtos;
    }

    @Override
    public MemberDto create(MemberDto memberDto)
    {
        try
        {
            Member member = memberRepository.save(memberDto.getMember());
            return new MemberDto(member);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public  MemberDto getMemberByEmail(String email)
    {
        try
        {
            Member member = memberRepository.getMemberByEmail(email);
            return new MemberDto(member);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public MemberDto getMemberDtoByeEmail(String email)
    {
        try
        {
            return memberRepository.getMemberDtoByeEmail(email);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
