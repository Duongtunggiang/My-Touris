package com.dulich.tourism.repository;

import com.dulich.tourism.models.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    public Account findByEmail(String email);

}
