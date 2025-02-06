package com.brihaspathee.sapphire.mapper.impl;

import com.brihaspathee.sapphire.domain.document.PremiumSpan;
import com.brihaspathee.sapphire.mapper.interfaces.MemberPremiumMapper;
import com.brihaspathee.sapphire.mapper.interfaces.PremiumSpanMapper;
import com.brihaspathee.sapphire.model.PremiumSpanDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 6:07 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PremiumSpanMapperImpl implements PremiumSpanMapper {

    /**
     * Maps and facilitates conversions between MemberPremium entities and their corresponding DTOs.
     * This mapper is utilized as a dependency in PremiumSpanMapperImpl to handle mapping
     * of MemberPremium-related data.
     */
    private final MemberPremiumMapper memberPremiumMapper;

    /**
     * Converts a PremiumSpan entity to its corresponding PremiumSpanDto representation.
     *
     * @param premiumSpan the PremiumSpan entity that needs to be converted
     * @return the PremiumSpanDto object containing the mapped data from the PremiumSpan entity,
     *         or null if the input is null
     */
    @Override
    public PremiumSpanDto toDto(PremiumSpan premiumSpan) {
        if(premiumSpan == null) return null;
        PremiumSpanDto premiumSpanDto = PremiumSpanDto.builder()
                .premiumSpanId(premiumSpan.getPremiumSpanId())
                .premiumSpanCode(premiumSpan.getPremiumSpanCode())
                .startDate(premiumSpan.getStartDate())
                .endDate(premiumSpan.getEndDate())
                .csrVariant(premiumSpan.getCsrVariant())
                .premiumAmountTotal(premiumSpan.getPremiumAmountTotal())
                .aptcAmount(premiumSpan.getAptcAmount())
                .csrAmount(premiumSpan.getCsrAmount())
                .otherPayAmount(premiumSpan.getOtherPayAmount())
                .build();
        if(premiumSpan.getMemberPremiums() != null &&
                !premiumSpan.getMemberPremiums().isEmpty()) {
            premiumSpanDto.setMemberPremiumDtos(
                memberPremiumMapper.toDtos(premiumSpan.getMemberPremiums())
            );
        }
        return premiumSpanDto;
    }

    /**
     * Converts a PremiumSpanDto object to its corresponding PremiumSpan entity representation.
     *
     * @param premiumSpanDto the PremiumSpanDto object to be converted
     * @return the PremiumSpan entity object containing the mapped data from the PremiumSpanDto,
     *         or null if the input is null
     */
    @Override
    public PremiumSpan toDocument(PremiumSpanDto premiumSpanDto) {
        if(premiumSpanDto == null) return null;
        PremiumSpan premiumSpan = PremiumSpan.builder()
                .premiumSpanId(premiumSpanDto.getPremiumSpanId())
                .premiumSpanCode(premiumSpanDto.getPremiumSpanCode())
                .startDate(premiumSpanDto.getStartDate())
                .endDate(premiumSpanDto.getEndDate())
                .csrVariant(premiumSpanDto.getCsrVariant())
                .premiumAmountTotal(premiumSpanDto.getPremiumAmountTotal())
                .aptcAmount(premiumSpanDto.getAptcAmount())
                .csrAmount(premiumSpanDto.getCsrAmount())
                .otherPayAmount(premiumSpanDto.getOtherPayAmount())
                .build();
        if(premiumSpanDto.getMemberPremiumDtos() != null &&
                !premiumSpanDto.getMemberPremiumDtos().isEmpty()) {
            premiumSpan.setMemberPremiums(
                    memberPremiumMapper.toEntities(premiumSpanDto.getMemberPremiumDtos())
            );
        }
        return premiumSpan;
    }

    /**
     * Converts a list of PremiumSpan entities to their corresponding PremiumSpanDto representations.
     *
     * @param premiumSpans the list of PremiumSpan entities that need to be converted
     * @return a list of PremiumSpanDto objects containing the mapped data from the PremiumSpan entities
     */
    @Override
    public List<PremiumSpanDto> toDtos(List<PremiumSpan> premiumSpans) {
        return premiumSpans.stream().map(this::toDto).toList();
    }

    /**
     * Converts a list of PremiumSpanDto objects to a list of PremiumSpan entity objects.
     *
     * @param premiumSpanDtos the list of PremiumSpanDto objects to be converted
     * @return a list of PremiumSpan entities mapped from the provided PremiumSpanDto objects
     */
    @Override
    public List<PremiumSpan> toDocuments(List<PremiumSpanDto> premiumSpanDtos) {
        return premiumSpanDtos.stream().map(this::toDocument).toList();
    }
}
