package com.brihaspathee.sapphire.domain.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, January 2025
 * Time: 4:44 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.domain.document
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@Document(collection = "members", collation = "members")
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    /**
     * Represents the unique identifier of a member.
     * This field is used as the primary key to uniquely identify a member in the system.
     */
    @Id
    @Field("_id")
    private String memberId;

    /**
     * Represents a unique code associated with a member.
     * This field is used to uniquely identify and manage members within the system
     * in scenarios where an additional identifier apart from the member ID is necessary.
     */
    @Field("memberCode")
    private String memberCode;

    /**
     * Represents the last name of the member.
     * This field stores the surname or family name of the member,
     * which is used for identification and record-keeping purposes.
     */
    @Field("lastName")
    private String lastName;

    /**
     * Represents the first name of the member.
     * This field stores the first name and is used to identify and address the member.
     */
    @Field("firstName")
    private String firstName;

    /**
     * Represents the middle name of the member.
     * This field stores the member's middle name, which can be helpful
     * in distinguishing between individuals with similar names and ensuring
     * accurate identification of members.
     */
    @Field("middleName")
    private String middleName;

    /**
     * Represents the date of birth of a member.
     * This field stores the date component (year, month, day) when the member was born.
     * It is used in processing and managing member-related information, ensuring the accurate
     * tracking of age, eligibility, and other date-related validations.
     */
    @Field("dateOfBirth")
    private LocalDate dateOfBirth;

    /**
     * Represents the list of addresses associated with a member.
     * Each address in the list contains details such as address type, address lines,
     * city, state, zip code, and validity period. This allows maintaining
     * comprehensive address information for the member, encompassing
     * multiple address instances if necessary.
     */
    private List<Address> addresses;
}
