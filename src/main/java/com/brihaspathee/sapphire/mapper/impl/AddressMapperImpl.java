package com.brihaspathee.sapphire.mapper.impl;

import com.brihaspathee.sapphire.domain.document.Address;
import com.brihaspathee.sapphire.mapper.interfaces.AddressMapper;
import com.brihaspathee.sapphire.model.AddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 2/5/25
 * Time: 6:27 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AddressMapperImpl implements AddressMapper {

    /**
     * Converts an Address entity to an AddressDto object.
     *
     * @param address the Address entity to be converted to a AddressDto
     * @return an AddressDto object mapped from the provided Address entity, or null if the input is null
     */
    @Override
    public AddressDto toDto(Address address) {
        if (address == null) return null;
        AddressDto addressDto = AddressDto.builder()
                .addressCode(address.getAddressCode())
                .startDate(address.getStartDate())
                .endDate(address.getEndDate())
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .build();
        return addressDto;
    }

    /**
     * Converts an AddressDto object to an Address entity.
     *
     * @param addressDto the AddressDto object to be converted
     * @return an Address entity mapped from the provided AddressDto object, or null if the input is null
     */
    @Override
    public Address toDocument(AddressDto addressDto) {
        if (addressDto == null) return null;
        Address address = Address.builder()
                .addressCode(addressDto.getAddressCode())
                .startDate(addressDto.getStartDate())
                .endDate(addressDto.getEndDate())
                .addressLine1(addressDto.getAddressLine1())
                .addressLine2(addressDto.getAddressLine2())
                .city(addressDto.getCity())
                .state(addressDto.getState())
                .zipCode(addressDto.getZipCode())
                .build();
        return address;
    }

    /**
     * Converts a list of Address entities to a list of AddressDto objects.
     *
     * @param addresses the list of Address entities to be converted
     * @return a list of AddressDto objects mapped from the provided Address entities
     */
    @Override
    public List<AddressDto> toDtos(List<Address> addresses) {
        return addresses.stream().map(this::toDto).toList();
    }

    /**
     * Converts a list of AddressDto objects to a list of Address entities.
     *
     * @param addressDtos the list of AddressDto objects to be converted
     * @return a list of Address entities mapped from the provided AddressDto objects
     */
    @Override
    public List<Address> toDocuments(List<AddressDto> addressDtos) {
        return addressDtos.stream().map(this::toDocument).toList();
    }
}
