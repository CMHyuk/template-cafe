package com.idol.cafe.controller;

import com.idol.cafe.dto.request.CafeSearchRequest;
import com.idol.cafe.dto.response.CafeResponse;
import com.idol.cafe.dto.response.CafeSearchResponse;
import com.idol.cafe.service.SearchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/cafes")
    public List<CafeSearchResponse> searchCafe(@RequestBody @Valid CafeSearchRequest request) {
        return searchService.searchCafe(request);
    }

    @GetMapping("/cafe/{cafeId}/details")
    public CafeResponse getCafeDetails(@PathVariable Long cafeId) {
        return searchService.getCafeDetails(cafeId);
    }

}
