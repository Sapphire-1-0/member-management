package com.brihaspathee.sapphire.mapper.interfaces;

import com.brihaspathee.sapphire.domain.document.PremiumSpan;
import com.brihaspathee.sapphire.model.PremiumSpanDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 6:04 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface PremiumSpanMapper {

    /**
     * Converts a PremiumSpan entity to its corresponding PremiumSpanDto representation.
     *
     * @param premiumSpan the PremiumSpan entity to be converted
     * @return a PremiumSpanDto object that represents the data from the given PremiumSpan entity
     */
    PremiumSpanDto toDto(PremiumSpan premiumSpan);

    /**
     * Converts a PremiumSpanDto object to a PremiumSpan entity.
     *
     * @param premiumSpanDto the PremiumSpanDto object to be converted
     * @return a PremiumSpan entity representing the data from the provided PremiumSpanDto
     */
    PremiumSpan toDocument(PremiumSpanDto premiumSpanDto);

    /**
     * Converts a list of PremiumSpan entities to their corresponding PremiumSpanDto objects.
     *
     * @param premiumSpans the list of PremiumSpan entities to be converted
     * @return a list of PremiumSpanDto objects that represent the data from the provided PremiumSpan entities
     */
    List<PremiumSpanDto> toDtos(List<PremiumSpan> premiumSpans);

    /**
     * Converts a list of PremiumSpanDto objects to a list of PremiumSpan entities.
     *
     * @param premiumSpanDtos the list of PremiumSpanDto objects to be converted
     * @return a list of PremiumSpan entities corresponding to the provided PremiumSpanDto objects
     */
    List<PremiumSpan> toDocuments(List<PremiumSpanDto> premiumSpanDtos);
}
