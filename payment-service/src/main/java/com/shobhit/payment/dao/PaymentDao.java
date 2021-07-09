package com.shobhit.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shobhit.payment.entity.PaymentEntity;

@Repository
public interface PaymentDao extends JpaRepository<PaymentEntity, Integer> {
	
}