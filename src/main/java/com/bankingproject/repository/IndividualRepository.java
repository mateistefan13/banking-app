package com.bankingproject.repository;

import com.bankingproject.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IndividualRepository extends JpaRepository<Individual, Long> {
}
