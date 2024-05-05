package com.string.search.repository;

import com.string.search.document.ExampleDocument;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux;

public interface ElasticsearchRepository extends ReactiveElasticsearchRepository<ExampleDocument, String> {
    Flux<ExampleDocument> findByContentContaining(String content);
}
