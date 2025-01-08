package com.brihaspathee.sapphire.domain.elastic.documents;

import com.brihaspathee.sapphire.domain.elastic.index.Indexes;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.time.LocalDate;

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
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
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
     * First name of the member
     */
    @Field(type = FieldType.Text)
    private String lastName;

    /**
     * The date of birth of the member
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Field(type = FieldType.Date)
    private LocalDate birthDate;

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
