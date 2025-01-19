package com.brihaspathee.sapphire.domain.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(collation = "accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    /**
     * Unique id of the account
     */
    @Id
    @Field("_id")
    private String accountId;
}
