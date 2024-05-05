package com.string.search.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(indexName = "documents")
public class ExampleDocument {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "content")
    private String content;

}

