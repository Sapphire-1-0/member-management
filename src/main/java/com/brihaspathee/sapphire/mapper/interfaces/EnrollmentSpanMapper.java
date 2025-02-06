package com.brihaspathee.sapphire.mapper.interfaces;

import com.brihaspathee.sapphire.domain.document.EnrollmentSpan;
import com.brihaspathee.sapphire.model.EnrollmentSpanDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 6:57 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface EnrollmentSpanMapper {

    EnrollmentSpanDto toDto(EnrollmentSpan enrollmentSpan);

    EnrollmentSpan toDocument(EnrollmentSpanDto enrollmentSpanDto);

    List<EnrollmentSpanDto> toDtos(List<EnrollmentSpan> enrollmentSpans);

    List<EnrollmentSpan> toDocuments(List<EnrollmentSpanDto> enrollmentSpanDtos);
}
