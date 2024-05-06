package com.string.search.document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {

    @Field(type = FieldType.Keyword, name = "member_id")
    private String memberId;

    @Field(type = FieldType.Text, fielddata = true)
    private String username;

    @Field(type = FieldType.Keyword)
    private String nickname;

    @Field(type = FieldType.Keyword)
    private String email;

}