package com.ms.bootcamp.repository;

import com.ms.bootcamp.entity.OrderEntity;
import com.ms.bootcamp.entity.PrimaryKey;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,PrimaryKey> {

//  @Query("select * from Cart where userId=:userId")
//  public Iterable<CartEntity> findByUserId(@Param("userId") String userId);

  List<OrderEntity> findByuserId(Integer userId);
  
  Optional<OrderEntity> findById(PrimaryKey primaryKey);
  
  //List<OrderEntity> findByIdorderID(Long orderId);

List<OrderEntity> findByOrderId(Long orderId);
}
