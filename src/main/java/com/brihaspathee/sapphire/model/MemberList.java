package com.brihaspathee.sapphire.model;

import com.brihaspathee.sapphire.domain.elastic.documents.Member;
import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 31, December 2024
 * Time: 11:05 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberList {

    /**
     * List of members
     */
    private List<Member> members;
}
