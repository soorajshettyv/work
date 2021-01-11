package com.ms.bootcamp.repository;

import com.ms.bootcamp.entity.CartEntity;
import com.ms.bootcamp.entity.PrimaryKey;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,PrimaryKey> {

//  @Query("select * from Cart where userId=:userId")
//  public Iterable<CartEntity> findByUserId(@Param("userId") String userId);

  List<CartEntity> findByuserId(Integer userId);
  
  Optional<CartEntity> findById(PrimaryKey primaryKey);

void deleteByUserId(Integer userId);


}
