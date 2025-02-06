package com.brihaspathee.sapphire.mapper.interfaces;

import com.brihaspathee.sapphire.domain.document.MemberPremium;
import com.brihaspathee.sapphire.model.MemberPremiumDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 5:54 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface MemberPremiumMapper {

    /**
     * Converts a MemberPremium entity to its corresponding MemberPremiumDto representation.
     *
     * @param memberPremium the MemberPremium entity that needs to be converted
     * @return the MemberPremiumDto object containing the mapped data from the MemberPremium entity
     */
    MemberPremiumDto toDto(MemberPremium memberPremium);

    /**
     * Converts a MemberPremiumDto to its corresponding MemberPremium entity.
     *
     * @param memberPremiumDto the MemberPremiumDto object that needs to be converted
     * @return the MemberPremium entity containing the mapped data from the MemberPremiumDto
     */
    MemberPremium toEntity(MemberPremiumDto memberPremiumDto);

    /**
     * Converts a list of MemberPremium entities to their corresponding MemberPremiumDto representations.
     *
     * @param memberPremiums the list of MemberPremium entities that need to be converted
     * @return a list of MemberPremiumDto objects containing the mapped data from the MemberPremium entities
     */
    List<MemberPremiumDto> toDtos(List<MemberPremium> memberPremiums);

    /**
     * Converts a list of MemberPremiumDto objects to a list of MemberPremium entity objects.
     *
     * @param memberPremiumDtos the list of MemberPremiumDto objects to be converted
     * @return a list of MemberPremium entities containing the mapped data from the MemberPremiumDto objects
     */
    List<MemberPremium> toEntities(List<MemberPremiumDto> memberPremiumDtos);
}
