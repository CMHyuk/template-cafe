package com.idol.cafe.repository;

import com.idol.cafe.domain.entity.Cafe;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe, Long>, CafeRepositoryCustom {
    List<Cafe> findAll();
}
