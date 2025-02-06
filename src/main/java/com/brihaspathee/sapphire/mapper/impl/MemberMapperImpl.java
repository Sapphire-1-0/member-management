package com.brihaspathee.sapphire.mapper.impl;

import com.brihaspathee.sapphire.domain.document.Member;
import com.brihaspathee.sapphire.mapper.interfaces.AddressMapper;
import com.brihaspathee.sapphire.mapper.interfaces.MemberMapper;
import com.brihaspathee.sapphire.model.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 6:50 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MemberMapperImpl implements MemberMapper {

    private final AddressMapper addressMapper;

    @Override
    public MemberDto toDto(Member member) {
        if (member == null) return null;
        MemberDto memberDto = MemberDto.builder()
                .memberId(member.getMemberId())
                .memberCode(member.getMemberCode())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .middleName(member.getMiddleName())
                .dateOfBirth(member.getDateOfBirth())
                .gender(member.getGender())
                .build();
        if(member.getAddresses() != null &&
                !member.getAddresses().isEmpty()) {
            memberDto.setAddressDtos(
                    addressMapper.toDtos(member.getAddresses())
            );
        }
        return memberDto;
    }

    @Override
    public Member toDocument(MemberDto memberDto) {
        if (memberDto == null) return null;
        Member member = Member.builder()
                .memberId(memberDto.getMemberId())
                .memberCode(memberDto.getMemberCode())
                .firstName(memberDto.getFirstName())
                .lastName(memberDto.getLastName())
                .middleName(memberDto.getMiddleName())
                .dateOfBirth(memberDto.getDateOfBirth())
                .gender(memberDto.getGender())
                .build();
        if(memberDto.getAddressDtos() != null &&
                !memberDto.getAddressDtos().isEmpty()) {
            member.setAddresses(
                    addressMapper.toDocuments(memberDto.getAddressDtos())
            );
        }
        return member;
    }

    @Override
    public List<MemberDto> toDtos(List<Member> members) {
        return members.stream().map(this::toDto).collect(Collectors.toList());
    }

    /**
     *
     */
    @Override
    public List<Member> toDocuments(List<MemberDto> memberDtos) {
        return memberDtos.stream().map(this::toDocument).toList();
    }
}
