package com.bankapplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapplication.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
