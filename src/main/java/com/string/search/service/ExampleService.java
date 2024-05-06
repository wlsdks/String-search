package com.string.search.service;

import com.string.search.document.Example;
import com.string.search.repository.ExampleRepository;
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
public class ExampleService {

    private final ExampleRepository exampleRepository;

    public Mono<Example> saveDocument(Example document) {
        return exampleRepository.save(document)
                .onErrorResume(e -> {
                    log.error("saveDocumentError: {}",e.getMessage());
                    return Mono.empty(); //에러가 발생하면 빈 Mono를 반환합니다. (일반적인 mvc와 다른 예외처리 방식)
                });
    }

    public Flux<Example> searchDocuments(String content) {
        return exampleRepository.findByContentContaining(content)
                .onErrorResume(e -> {
                    log.error("searchDocumentsError: {}", e.getMessage());
                    return Flux.empty();
                });
    }

}
