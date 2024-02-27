package com.example.springbootquiz.sale;

import com.example.springbootquiz.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
