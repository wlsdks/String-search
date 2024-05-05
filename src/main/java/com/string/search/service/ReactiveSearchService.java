package com.string.search.service;

import com.string.search.document.ExampleDocument;
import com.string.search.repository.ElasticsearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ReactiveSearchService는 엘라스틱서치 도큐먼트를 저장하고 검색하는 비즈니스 로직을 담당합니다.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ReactiveSearchService {

    private final ElasticsearchRepository elasticsearchRepository;

    public Mono<ExampleDocument> saveDocument(ExampleDocument document) {
        return elasticsearchRepository.save(document)
                .onErrorResume(e -> {
                    log.error("saveDocumentError: {}",e.getMessage());
                    return Mono.empty(); //에러가 발생하면 빈 Mono를 반환합니다. (일반적인 mvc와 다른 예외처리 방식)
                });
    }

    public Flux<ExampleDocument> searchDocuments(String content) {
        return elasticsearchRepository.findByContentContaining(content)
                .onErrorResume(e -> {
                    log.error("searchDocumentsError: {}", e.getMessage());
                    return Flux.empty();
                });
    }

}
