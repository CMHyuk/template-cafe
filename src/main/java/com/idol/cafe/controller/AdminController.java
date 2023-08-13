package com.idol.cafe.controller;

import com.idol.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final CafeService cafeService;

    @GetMapping("/admin/cafes")
    public String getCafes(@PageableDefault(sort = "id", direction = DESC) Pageable pageable, Model model) {
        model.addAttribute("cafes", cafeService.getCafes(pageable));
        return "/admin/cafes";
    }
}
