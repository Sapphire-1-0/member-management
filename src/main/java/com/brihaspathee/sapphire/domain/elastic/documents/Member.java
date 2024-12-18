package com.brihaspathee.sapphire.domain.elastic.documents;

import com.brihaspathee.sapphire.domain.elastic.index.Indexes;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12, December 2024
 * Time: 5:28 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.domain.elastic.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@Document(indexName = Indexes.MEMBER_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Member {

    /**
     * The id of the member
     */
    @Id
    @Field(type = FieldType.Keyword)
    private Long memberId;

    /**
     * First name of the member
     */
    @Field(type = FieldType.Text)
    private String firstName;

    /**
     * To string method
     * @return - string version on the member object
     */
    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
