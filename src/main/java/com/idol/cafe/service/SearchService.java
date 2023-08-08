package com.idol.cafe.service;

import com.idol.cafe.dto.request.SearchRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SearchService {

    public void search(SearchRequest request) {

    }
}
