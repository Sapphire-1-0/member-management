package com.brihaspathee.sapphire.mapper.impl;

import com.brihaspathee.sapphire.domain.document.EnrollmentSpan;
import com.brihaspathee.sapphire.mapper.interfaces.EnrollmentSpanMapper;
import com.brihaspathee.sapphire.mapper.interfaces.PremiumSpanMapper;
import com.brihaspathee.sapphire.model.EnrollmentSpanDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 6:58 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EnrollmentSpanMapperImpl implements EnrollmentSpanMapper {

    private final PremiumSpanMapper premiumSpanMapper;

    @Override
    public EnrollmentSpanDto toDto(EnrollmentSpan enrollmentSpan) {
        if (enrollmentSpan == null) return null;
        EnrollmentSpanDto enrollmentSpanDto = EnrollmentSpanDto.builder()
                .enrollmentSpanId(enrollmentSpan.getEnrollmentSpanId())
                .enrollmentSpanCode(enrollmentSpan.getEnrollmentSpanCode())
                .spanStatus(enrollmentSpan.getSpanStatus())
                .businessUnit(enrollmentSpan.getBusinessUnit())
                .exchangeSubscriberId(enrollmentSpan.getExchangeSubscriberId())
                .startDate(enrollmentSpan.getStartDate())
                .endDate(enrollmentSpan.getEndDate())
                .planId(enrollmentSpan.getPlanId())
                .groupPolicyId(enrollmentSpan.getGroupPolicyId())
                .effectuationDate(enrollmentSpan.getEffectuationDate())
                .paidThruDate(enrollmentSpan.getPaidThruDate())
                .build();
        if(enrollmentSpan.getPremiumSpans() != null &&
                !enrollmentSpan.getPremiumSpans().isEmpty()) {
            enrollmentSpanDto.setPremiumSpans(
                    premiumSpanMapper.toDtos(enrollmentSpan.getPremiumSpans())
            );
        }
        return enrollmentSpanDto;
    }

    @Override
    public EnrollmentSpan toDocument(EnrollmentSpanDto enrollmentSpanDto) {
        if (enrollmentSpanDto == null) return null;
        EnrollmentSpan enrollmentSpan = EnrollmentSpan.builder()
                .enrollmentSpanId(enrollmentSpanDto.getEnrollmentSpanId())
                .enrollmentSpanCode(enrollmentSpanDto.getEnrollmentSpanCode())
                .spanStatus(enrollmentSpanDto.getSpanStatus())
                .businessUnit(enrollmentSpanDto.getBusinessUnit())
                .exchangeSubscriberId(enrollmentSpanDto.getExchangeSubscriberId())
                .startDate(enrollmentSpanDto.getStartDate())
                .endDate(enrollmentSpanDto.getEndDate())
                .planId(enrollmentSpanDto.getPlanId())
                .groupPolicyId(enrollmentSpanDto.getGroupPolicyId())
                .effectuationDate(enrollmentSpanDto.getEffectuationDate())
                .paidThruDate(enrollmentSpanDto.getPaidThruDate())
                .build();
        if(enrollmentSpanDto.getPremiumSpans() != null &&
                !enrollmentSpanDto.getPremiumSpans().isEmpty()) {
            enrollmentSpan.setPremiumSpans(
                    premiumSpanMapper.toDocuments(enrollmentSpanDto.getPremiumSpans())
            );
        }
        return enrollmentSpan;
    }

    @Override
    public List<EnrollmentSpanDto> toDtos(List<EnrollmentSpan> enrollmentSpans) {
        return enrollmentSpans.stream().map(this::toDto).toList();
    }

    @Override
    public List<EnrollmentSpan> toDocuments(List<EnrollmentSpanDto> enrollmentSpanDtos) {
        return enrollmentSpanDtos.stream().map(this::toDocument).toList();
    }
}
