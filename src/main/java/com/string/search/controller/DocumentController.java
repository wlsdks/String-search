package com.string.search.controller;

import com.string.search.document.ExampleDocument;
import com.string.search.service.ReactiveSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/elastic/document")
@RequiredArgsConstructor
@RestController
public class DocumentController {

    private final ReactiveSearchService reactiveSearchService;

    /**
     * 클라이언트로부터 JSON 형태의 도큐먼트 데이터를 받아 엘라스틱서치의 지정된 인덱스에 저장합니다.
     *
     * @param document
     * @return
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ExampleDocument> createDocument(@RequestBody ExampleDocument document) {
        return reactiveSearchService.saveDocument(document);
    }

    /**
     *
     * 클라이언트로부터 검색어를 받아 해당 검색어를 포함하는 모든 도큐먼트를 엘라스틱서치에서 검색합니다.
     *
     * @param content
     * @return
     */
    @GetMapping("/search")
    public Flux<ExampleDocument> searchDocuments(@RequestParam String content) {
        return reactiveSearchService.searchDocuments(content);
    }

}
