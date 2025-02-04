package com.brihaspathee.sapphire.helper.impl;

import com.brihaspathee.sapphire.domain.document.MemberPremium;
import com.brihaspathee.sapphire.domain.document.PremiumSpan;
import com.brihaspathee.sapphire.domain.repository.PremiumSpanRepository;
import com.brihaspathee.sapphire.helper.interfaces.PremiumSpanHelper;
import com.brihaspathee.sapphire.model.MemberPremiumDto;
import com.brihaspathee.sapphire.model.PremiumSpanDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, February 2025
 * Time: 4:21 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.helper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PremiumSpanHelperImpl implements PremiumSpanHelper {

    /**
     * Handles database operations for PremiumSpan entities.
     * This repository acts as an interface for accessing and managing
     * PremiumSpan documents in the MongoDB database.
     * It extends the MongoRepository interface, providing CRUD operations
     * and custom query capabilities for PremiumSpan entities.
     * Utilized within the helper implementation for persisting, retrieving,
     * and manipulating premium span data in the application.
     */
    private final PremiumSpanRepository premiumSpanRepository;

    /**
     * Persists a list of premium span data represented as PremiumSpanDto objects.
     * This method takes a list of PremiumSpanDto objects, processes them as needed,
     * and returns a list of PremiumSpanDto objects after the save operation.
     *
     * @param premiumSpanDtos the list of PremiumSpanDto objects to be saved. Each object
     *                        represents a premium span and contains details such as
     *                        premium span ID, code, start and end dates, premium amounts,
     *                        and member premium details.
     * @return a list of PremiumSpanDto objects after the save operation. This list reflects
     *         the state of each premium span record post-save, typically including any updates
     *         or modifications made during the save process.
     */
    @Override
    public List<PremiumSpanDto> savePremiumSpans(List<PremiumSpanDto> premiumSpanDtos) {
        List<PremiumSpanDto> savedPremiumSpans = new ArrayList<>();
        List<PremiumSpan> premiumSpans = premiumSpanDtos.stream().map(premiumSpanDto ->
            PremiumSpan.builder()
                    .premiumSpanId(premiumSpanDto.getPremiumSpanId())
                    .premiumSpanCode(premiumSpanDto.getPremiumSpanCode())
                    .startDate(premiumSpanDto.getStartDate())
                    .endDate(premiumSpanDto.getEndDate())
                    .premiumAmountTotal(premiumSpanDto.getPremiumAmountTotal())
                    .totalResponsibleAmount(premiumSpanDto.getTotalResponsibleAmount())
                    .aptcAmount(premiumSpanDto.getAptcAmount())
                    .csrAmount(premiumSpanDto.getCsrAmount())
                    .otherPayAmount(premiumSpanDto.getOtherPayAmount())
                    .memberPremiums(premiumSpanDto.getMemberPremiumDtos().stream().map(memberPremiumDto ->
                         MemberPremium.builder()
                                .memberCode(memberPremiumDto.getMemberCode())
                                .premiumAmount(memberPremiumDto.getPremiumAmount())
                                .exchangeMemberId(memberPremiumDto.getExchangeMemberId())
                                .build())
                        .toList())
                    .build()
        ).toList();
        premiumSpans.forEach(premiumSpan -> {
            PremiumSpan savedPremium = premiumSpanRepository.save(premiumSpan);
            PremiumSpanDto premiumSpanDto = PremiumSpanDto.builder()
                    .premiumSpanId(savedPremium.getPremiumSpanId())
                    .premiumSpanCode(savedPremium.getPremiumSpanCode())
                    .startDate(savedPremium.getStartDate())
                    .endDate(savedPremium.getEndDate())
                    .premiumAmountTotal(savedPremium.getPremiumAmountTotal())
                    .totalResponsibleAmount(savedPremium.getTotalResponsibleAmount())
                    .aptcAmount(savedPremium.getAptcAmount())
                    .csrAmount(savedPremium.getCsrAmount())
                    .otherPayAmount(savedPremium.getOtherPayAmount())
                    .memberPremiumDtos(savedPremium.getMemberPremiums()
                            .stream()
                            .map(memberPremium ->
                                    MemberPremiumDto.builder()
                                            .memberCode(memberPremium.getMemberCode())
                                            .premiumAmount(memberPremium.getPremiumAmount())
                                            .exchangeMemberId(memberPremium.getExchangeMemberId())
                                            .build())
                            .toList())
                    .build();
            savedPremiumSpans.add(premiumSpanDto);
        });
        return savedPremiumSpans;
    }
}
