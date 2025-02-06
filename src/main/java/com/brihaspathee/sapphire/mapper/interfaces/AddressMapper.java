package com.brihaspathee.sapphire.mapper.interfaces;

import com.brihaspathee.sapphire.domain.document.Address;
import com.brihaspathee.sapphire.model.AddressDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 6:24 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface AddressMapper {

    /**
     * Converts an Address entity to its corresponding AddressDto representation.
     *
     * @param address the Address entity to be converted
     * @return the AddressDto object containing the mapped data from the Address entity
     */
    AddressDto toDto(Address address);

    /**
     * Converts an AddressDto object to its corresponding Address entity.
     *
     * @param addressDto the AddressDto object to be converted
     * @return an Address entity representing the data from the provided AddressDto object
     */
    Address toDocument(AddressDto addressDto);

    /**
     * Converts a list of Address entities to a list of corresponding AddressDto objects.
     *
     * @param addresses the list of Address entities to be converted
     * @return a list of AddressDto objects that represent the data from the provided Address entities
     */
    List<AddressDto> toDtos(List<Address> addresses);

    /**
     * Converts a list of AddressDto objects to their corresponding Address entities.
     *
     * @param addressDtos the list of AddressDto objects to be converted
     * @return a list of Address entities corresponding to the provided AddressDto objects
     */
    List<Address> toDocuments(List<AddressDto> addressDtos);
}
