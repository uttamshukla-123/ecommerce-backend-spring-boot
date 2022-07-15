package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
