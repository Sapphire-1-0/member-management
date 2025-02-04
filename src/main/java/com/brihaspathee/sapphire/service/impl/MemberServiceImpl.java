package com.brihaspathee.sapphire.service.impl;

import com.brihaspathee.sapphire.domain.document.Address;
import com.brihaspathee.sapphire.domain.document.Member;
import com.brihaspathee.sapphire.domain.repository.MemberRepository;
import com.brihaspathee.sapphire.helper.impl.MemberAddressHelperImpl;
import com.brihaspathee.sapphire.model.MemberDto;
import com.brihaspathee.sapphire.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 01, February 2025
 * Time: 6:56 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    /**
     * Repository for performing CRUD operations and database interaction
     * related to Member entities in the system.
     */
    private final MemberRepository memberRepository;

    /**
     * A helper component that provides functionality to handle address-related
     * operations for members. It is used to convert and manipulate address data
     * from DTOs to domain entities or vice versa.
     */
    private final MemberAddressHelperImpl memberAddressHelper;

    /**
     * Saves a list of member details into the system.
     *
     * @param memberDtos the list of {@link MemberDto} objects containing member details to be saved
     * @return the list of saved {@link MemberDto} objects after persistence
     */
    @Override
    public List<MemberDto> saveMemberDtos(List<MemberDto> memberDtos) {
        List<Member> members = saveMembers(memberDtos);
        List<MemberDto> savedMembers =
                members.stream().map(member -> MemberDto.builder()
                                .memberId(member.getMemberId())
                                .memberCode(member.getMemberCode())
                                .firstName(member.getFirstName())
                                .lastName(member.getLastName())
                                .middleName(member.getMiddleName())
                                .dateOfBirth(member.getDateOfBirth())
                                .build())
                        .toList();
        return savedMembers;
    }

    /**
     * Persists a list of members based on the provided member DTOs.
     *
     * @param memberDtos the list of {@link MemberDto} objects containing the details of members to be saved
     * @return the list of saved {@link Member} entities after persistence
     */
    @Override
    public List<Member> saveMembers(List<MemberDto> memberDtos) {
        List<Member> members = memberDtos.stream().map(memberDto -> {
            Member member = Member.builder()
                    .memberCode(memberDto.getMemberCode())
                    .firstName(memberDto.getFirstName())
                    .lastName(memberDto.getLastName())
                    .middleName(memberDto.getMiddleName())
                    .dateOfBirth(memberDto.getDateOfBirth())
                    .build();
            List<Address> addresses = memberAddressHelper.getAddress(memberDto.getAddressDtos());
            if(addresses != null) member.setAddresses(addresses);
            return member;
        }).toList();
        members = memberRepository.saveAll(members);
        return members;
    }
}
