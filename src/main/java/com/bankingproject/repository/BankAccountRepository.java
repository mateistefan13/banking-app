package com.bankingproject.repository;

import com.bankingproject.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {


}
