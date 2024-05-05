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

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ExampleDocument> createDocument(@RequestBody ExampleDocument document) {
        return reactiveSearchService.saveDocument(document);
    }

    @GetMapping("/search")
    public Flux<ExampleDocument> searchDocuments(@RequestParam String content) {
        return reactiveSearchService.searchDocuments(content);
    }

}
