package com.brihaspathee.sapphire.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 31, December 2024
 * Time: 10:30 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSearchParamDto {

    private static final DateTimeFormatter ES_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * List of fields and its values based on which the search should be performed
     */
    private Map<String, String> searchMap;

    /**
     * The field on which the sorting needs to be performed
     */
    private String sortField;

    /**
     * The sorting order of the records
     */
    private String sortOrder;

    /**
     * The "from" date for date of birth
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfBirthFrom;

    /**
     * The "to" date for date of birth
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfBirthTo;

    /**
     * Indicates if the fields have to be an exact match
     */
    private boolean exactMatch;

    /**
     * Convert the date into a string format
     * @return - date in a string format
     */
    public String getFormattedDateOfBirthFrom(){
        return dateOfBirthFrom != null? dateOfBirthFrom.format(ES_DATE_FORMATTER) : null;
    }

    /**
     * Convert the date into a string format
     * @return - date in a string format
     */
    public String getFormattedDateOfBirthTo(){
        return dateOfBirthTo != null? dateOfBirthTo.format(ES_DATE_FORMATTER) : null;
    }

}
