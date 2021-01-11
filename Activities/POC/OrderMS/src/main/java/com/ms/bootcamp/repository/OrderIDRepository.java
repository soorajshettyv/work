package com.ms.bootcamp.repository;

import com.ms.bootcamp.entity.OrderEntity;
import com.ms.bootcamp.entity.OrderID;
import com.ms.bootcamp.entity.PrimaryKey;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderIDRepository extends JpaRepository<OrderID,Integer> {

//  @Query("select * from Cart where userId=:userId")
//  public Iterable<CartEntity> findByUserId(@Param("userId") String userId);

	OrderID findByOrderId(Long id);

	List<OrderID> findByUserId(int uid);

	//Optional<OrderID> findByOrderID(Long oid);
  
 // Optional<OrderEntity> findById(PrimaryKey primaryKey);
}
