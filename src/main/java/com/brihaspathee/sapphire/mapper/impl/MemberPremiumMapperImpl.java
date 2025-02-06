package com.brihaspathee.sapphire.mapper.impl;

import com.brihaspathee.sapphire.domain.document.MemberPremium;
import com.brihaspathee.sapphire.mapper.interfaces.MemberPremiumMapper;
import com.brihaspathee.sapphire.model.MemberPremiumDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 6:00 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MemberPremiumMapperImpl implements MemberPremiumMapper {

    /**
     * Converts a MemberPremium entity to its corresponding MemberPremiumDto representation.
     *
     * @param memberPremium the MemberPremium entity that needs to be converted
     * @return the MemberPremiumDto object containing the mapped data from the MemberPremium entity,
     *         or null if the input is null
     */
    @Override
    public MemberPremiumDto toDto(MemberPremium memberPremium) {
        if(memberPremium == null) return null;
        MemberPremiumDto memberPremiumDto = MemberPremiumDto.builder()
                .exchangeMemberId(memberPremium.getExchangeMemberId())
                .memberCode(memberPremium.getMemberCode())
                .premiumAmount(memberPremium.getPremiumAmount())
                .build();
        return memberPremiumDto;
    }

    /**
     * Converts a MemberPremiumDto object to its corresponding MemberPremium entity representation.
     *
     * @param memberPremiumDto the MemberPremiumDto object that needs to be converted
     * @return the MemberPremium entity object containing the mapped data from the MemberPremiumDto,
     *         or null if the input is null
     */
    @Override
    public MemberPremium toEntity(MemberPremiumDto memberPremiumDto) {
        if(memberPremiumDto == null) return null;
        MemberPremium memberPremium = MemberPremium.builder()
                .exchangeMemberId(memberPremiumDto.getExchangeMemberId())
                .memberCode(memberPremiumDto.getMemberCode())
                .premiumAmount(memberPremiumDto.getPremiumAmount())
                .build();
        return memberPremium;
    }

    /**
     * Converts a list of MemberPremium entities to their corresponding MemberPremiumDto representations.
     *
     * @param memberPremiums the list of MemberPremium entities that need to be converted
     * @return a list of MemberPremiumDto objects containing the mapped data from the MemberPremium entities
     */
    @Override
    public List<MemberPremiumDto> toDtos(List<MemberPremium> memberPremiums) {
        return memberPremiums.stream().map(this::toDto).toList();
    }

    /**
     * Converts a list of MemberPremiumDto objects to a list of MemberPremium entity objects.
     *
     * @param memberPremiumDtos the list of MemberPremiumDto objects to be converted
     * @return a list of MemberPremium entities containing the mapped data from the MemberPremiumDto objects
     */
    @Override
    public List<MemberPremium> toEntities(List<MemberPremiumDto> memberPremiumDtos) {
        return memberPremiumDtos.stream().map(this::toEntity).toList();
    }
}
