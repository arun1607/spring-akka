package com.app.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.learning.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
