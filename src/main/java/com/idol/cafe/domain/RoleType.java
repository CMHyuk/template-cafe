package com.idol.cafe.domain;

import lombok.Getter;

@Getter
public enum RoleType {

    NORMAL("normal"), CAFE_OWNER("cafeOwner", false), ADMIN("admin");

    private String type;
    private Boolean isRegisteredBusiness;

    RoleType(String type) {
        this.type = type;
    }

    RoleType(String type, boolean isRegisteredBusiness) {
        this.type = type;
        this.isRegisteredBusiness = isRegisteredBusiness;
    }

    public static RoleType fromString(String value) {
        for (RoleType type : RoleType.values()) {
            if (type.getType().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 등급입니다.");
    }

}
