package com.idol.cafe.domain.entity;

import com.idol.cafe.domain.BaseEntity;
import com.idol.cafe.domain.RoleType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Enumerated(STRING)
    private RoleType roleType;

    private String nickname;
    private String email;

    @Builder
    public User(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public void updateRoleType(String roleType) {
        this.roleType = RoleType.fromString(roleType);
    }

}
