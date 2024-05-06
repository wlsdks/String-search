package com.string.search.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Document 어노테이션은 Spring Data Elasticsearch에서 Elasticsearch 인덱스와 직접적으로 매핑되는 최상위 문서에만 사용된다.
 * Member와 Comment 클래스 같은 경우에는 Post 클래스 내부에서 nested document로 사용되기 때문에, 별도의 인덱스로 존재하지 않는다.
 * 그래서 @Document 어노테이션 없이 @Field 어노테이션만을 사용해서 Post 문서 내에 어떻게 내장될지 정의하면 된다.
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(indexName = "sns_posts")
public class Post {

    @Id
    private String id;

    @Field(type = FieldType.Text, fielddata = true)
    private String title;

    @Field(type = FieldType.Text, analyzer = "standard")
    private String content;

    @Field(type = FieldType.Nested)
    private Member member;

    @Field(type = FieldType.Nested)
    private List<Comment> comments;

    @Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ss.SSS'Z'", name = "created_at")
    private Date createdAt;

    @Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ss.SSS'Z'", name = "updated_at")
    private Date updatedAt;

}
