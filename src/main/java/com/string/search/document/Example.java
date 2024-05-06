package com.string.search.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 도큐먼트는 엘라스틱서치에서 정보의 기본 단위입니다.
 * 일반적으로 JSON 형식으로 저장되며, 하나의 도큐먼트는 일반적으로 데이터베이스의 "행(row)"에 해당합니다.
 *
 * 스프링 데이터 엘라스틱서치에서는 인덱스를 코드에서 명시적으로 "생성"하는 것이 아니라,
 * @Document 어노테이션을 통해 도큐먼트가 어떤 인덱스에 속하는지 선언합니다.
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(indexName = "documents") // 해당 도큐먼트가 어떤 인덱스에 속할지 지정할 수 있습니다.
public class Example {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "content")
    private String content;

}

