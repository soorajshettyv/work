package com.ms.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ms.bootcamp.entity.ProductDetails;

import java.lang.String;
import java.util.Optional;


@Repository
public interface ProductRepo extends JpaRepository<ProductDetails, Integer>{

	Optional<ProductDetails> findByProductname(String productname);
}