package com.app.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.learning.model.Address;

public interface AddreddRepository extends JpaRepository<Address, Long> {

}
