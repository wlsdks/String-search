package com.string.search.service;

import com.string.search.document.ExampleDocument;
import com.string.search.repository.ElasticsearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
@RequiredArgsConstructor
@Service
public class ReactiveSearchService {

    private final ElasticsearchRepository elasticsearchRepository;

    public Mono<ExampleDocument> saveDocument(ExampleDocument document) {
        return elasticsearchRepository.save(document);
    }

    public Flux<ExampleDocument> searchDocuments(String content) {
        return elasticsearchRepository.findByContentContaining(content);
    }

}
