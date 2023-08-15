package com.idol.cafe.controller;

import com.idol.cafe.domain.entity.BusinessLicense;
import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.dto.response.AdminBusinessLicenseResponse;
import com.idol.cafe.dto.response.AdminCafeResponse;
import com.idol.cafe.dto.response.CafeResponse;
import com.idol.cafe.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/admin/cafes")
    public String getCafes(@PageableDefault(sort = "id", direction = DESC) Pageable pageable, Model model) {
        Page<Cafe> pages = adminService.getCafes(pageable);
        List<AdminCafeResponse> cafes = pages.stream().map(c -> AdminCafeResponse.builder()
                        .cafeId(c.getId())
                        .cafeName(c.getCafeName())
                        .nickname(c.getUser().getNickname())
                        .localDateTime(c.getCreatedDate())
                        .build())
                .collect(toList());

        model.addAttribute("cafes", cafes);
        model.addAttribute("pages", pages);
        model.addAttribute("maxPage", 10);
        return "/admin/cafes";
    }

    @GetMapping("/admin/businessLicense")
    public String getBusinessLicense(@PageableDefault(sort = "id", direction = DESC) Pageable pageable, Model model) {
        Page<BusinessLicense> pages = adminService.getBusinessLicense(pageable);
        List<AdminBusinessLicenseResponse> businessLicenses = pages.stream().map(b -> AdminBusinessLicenseResponse.builder()
                        .businessLicenseId(b.getId())
                        .registrationNumber(b.getRegistrationNumber())
                        .nickname(b.getUser().getNickname())
                        .localDateTime(b.getCreatedDate())
                        .isRegisteredBusiness(b.getIsRegisteredBusiness())
                        .build())
                .collect(toList());

        model.addAttribute("businessLicenses", businessLicenses);
        model.addAttribute("pages", pages);
        model.addAttribute("maxPage", 10);
        return "/admin/businessLicenses";
    }

    @PostMapping("/admin/businessLicense/{businessLicenseId}/allow")
    public String updateRegisteredBusiness(@PathVariable Long businessLicenseId) {
        adminService.updateRegisteredBusiness(businessLicenseId);
        return "redirect:/admin/businessLicense";
    }

}
