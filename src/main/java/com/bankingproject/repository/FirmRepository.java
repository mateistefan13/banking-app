package com.bankingproject.repository;

import com.bankingproject.entity.Firm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FirmRepository extends JpaRepository<Firm, Long> {
}
