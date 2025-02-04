package com.brihaspathee.sapphire.domain.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(collection = "accounts", collation = "accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    /**
     * Unique id of the account
     */
    @Id
    @Field("_id")
    private String accountId;

    /**
     * Represents the account number associated with an account.
     * It is used to uniquely identify the account in addition to the account ID.
     */
    @Field("accountNumber")
    private String accountNumber;

    /**
     * Specifies the line of business associated with the account.
     * This field represents the type or category of business that the account is related to.
     */
    @Field("lineOfBusiness")
    private String lineOfBusiness;

    /**
     * Represents the list of members associated with the account.
     * Each member in the list is linked via a database reference, providing
     * a relationship between the account and its corresponding members.
     */
    @DBRef
    private List<Member> members;

    /**
     * Represents the list of enrollment spans associated with an account.
     * Enrollment spans define a specific period of coverage or enrollment details
     * tied to an account. Each enrollment span in the list contains unique
     * identifiers, coverage periods, associated plans, and related information.
     * This field helps in managing and tracking the enrollment history and
     * details of an account.
     */
    private List<EnrollmentSpan> enrollmentSpans;
}
