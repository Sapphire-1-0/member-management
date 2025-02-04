package com.brihaspathee.sapphire.helper.impl;

import com.brihaspathee.sapphire.domain.document.EnrollmentSpan;
import com.brihaspathee.sapphire.domain.document.MemberPremium;
import com.brihaspathee.sapphire.domain.document.PremiumSpan;
import com.brihaspathee.sapphire.domain.repository.EnrollmentSpanRepository;
import com.brihaspathee.sapphire.helper.interfaces.EnrollmentSpanHelper;
import com.brihaspathee.sapphire.helper.interfaces.PremiumSpanHelper;
import com.brihaspathee.sapphire.model.EnrollmentSpanDto;
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
 * Time: 6:38 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.helper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EnrollmentSpanHelperImpl implements EnrollmentSpanHelper {

    /**
     * Handles database operations for EnrollmentSpan entities.
     * This repository acts as an interface for accessing and managing
     * EnrollmentSpan documents in the MongoDB database, leveraging the
     * MongoRepository interface for CRUD operations and custom queries.
     * It is utilized within the helper implementation to persist, retrieve,
     * and manipulate enrollment span data in the application.
     */
    private final EnrollmentSpanRepository enrollmentSpanRepository;

    /**
     * Helper class to manage operations related to premium spans.
     * The PremiumSpanHelper is responsible for providing methods that
     * assist in interacting with and managing premium span data within
     * the application. This interface defines functionalities such as
     * persisting, retrieving, and processing premium span information
     * to ensure smooth business workflows related to premium spans.
     */
    private final PremiumSpanHelper premiumSpanHelper;

    /**
     * Saves a list of enrollment span data transfer objects (EnrollmentSpanDto) to the system.
     * This method is responsible for persisting the provided enrollment spans and returns the
     * saved enrollment span objects.
     *
     * @param enrollmentSpanDtos a list of EnrollmentSpanDto objects containing details such as
     *                           enrollment span ID, code, business unit, start and end dates,
     *                           plan details, group policy details, and payment dates.
     * @return a list of EnrollmentSpanDto objects that were successfully saved, potentially
     *         including updated fields such as generated identifiers or modified data based
     *         on system rules during the save operation.
     */
    @Override
    public List<EnrollmentSpanDto> saveEnrollmentSpans(List<EnrollmentSpanDto> enrollmentSpanDtos) {
        if(enrollmentSpanDtos != null && !enrollmentSpanDtos.isEmpty()) {
            List<EnrollmentSpan> enrollmentSpans = enrollmentSpanDtos.stream()
                    .map(enrollmentSpanDto ->{
                        List<PremiumSpanDto> premiumSpanDtos = premiumSpanHelper.savePremiumSpans(enrollmentSpanDto.getPremiumSpans());
                        EnrollmentSpan enrollmentSpan = EnrollmentSpan.builder()
                                .enrollmentSpanId(enrollmentSpanDto.getEnrollmentSpanId())
                                .enrollmentSpanCode(enrollmentSpanDto.getEnrollmentSpanCode())
                                .businessUnit(enrollmentSpanDto.getBusinessUnit())
                                .spanStatus(enrollmentSpanDto.getSpanStatus())
                                .startDate(enrollmentSpanDto.getStartDate())
                                .endDate(enrollmentSpanDto.getEndDate())
                                .planId(enrollmentSpanDto.getPlanId())
                                .groupPolicyId(enrollmentSpanDto.getGroupPolicyId())
                                .effectuationDate(enrollmentSpanDto.getEffectuationDate())
                                .paidThruDate(enrollmentSpanDto.getPaidThruDate())
                                .premiumSpans(premiumSpanDtos.stream()
                                        .map(premiumSpanDto ->
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
                                                        .build())
                                        .toList())
                                .build();
                        return enrollmentSpan;
                    } )
                    .toList();
            List<EnrollmentSpanDto> savedEnrollmentSpans = new ArrayList<>(enrollmentSpans.stream().map(enrollmentSpan -> {
                EnrollmentSpan savedEnrollmentSpan = enrollmentSpanRepository.save(enrollmentSpan);
                return EnrollmentSpanDto.builder()
                        .enrollmentSpanId(savedEnrollmentSpan.getEnrollmentSpanId())
                        .enrollmentSpanCode(savedEnrollmentSpan.getEnrollmentSpanCode())
                        .businessUnit(savedEnrollmentSpan.getBusinessUnit())
                        .spanStatus(savedEnrollmentSpan.getSpanStatus())
                        .startDate(savedEnrollmentSpan.getStartDate())
                        .endDate(savedEnrollmentSpan.getEndDate())
                        .planId(savedEnrollmentSpan.getPlanId())
                        .groupPolicyId(savedEnrollmentSpan.getGroupPolicyId())
                        .effectuationDate(savedEnrollmentSpan.getEffectuationDate())
                        .paidThruDate(savedEnrollmentSpan.getPaidThruDate())
                        .build();
            }).toList());
            return savedEnrollmentSpans;
        }else{
            return null;
        }
    }
}
