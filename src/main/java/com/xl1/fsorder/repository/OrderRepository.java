package com.xl1.fsorder.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.xl1.fsorder.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long>{
 }
