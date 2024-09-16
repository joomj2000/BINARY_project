package com.hotdesking.study.repository;

import com.hotdesking.study.domain.TableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableRepository extends JpaRepository<TableInfo, Long> {
    Optional<TableInfo> findByTableId(String tableId);
}
