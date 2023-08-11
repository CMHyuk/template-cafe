package com.idol.cafe.dto.response.businesslicense;

import lombok.Getter;

import java.util.List;

@Getter
public class BusinessLicenseStatus {

    private int match_cnt;
    private int request_cnt;
    private String status_code;
    private List<Data> data;

    @Getter
    public static class Data {
        private String b_no;
        private String b_stt;
        private String b_stt_cd;
        private String tax_type;
        private String tax_type_cd;
        private String end_dt;
        private String utcc_yn;
        private String tax_type_change_dt;
        private String invoice_apply_dt;
        private String rbf_tax_type;
        private String rbf_tax_type_cd;
    }

}
