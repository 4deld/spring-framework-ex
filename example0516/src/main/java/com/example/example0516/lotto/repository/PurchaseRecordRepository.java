package com.example.example0516.lotto.repository;

import com.example.example0516.lotto.domain.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord,Long> {
}
