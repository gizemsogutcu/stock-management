package com.api.repository;

import com.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
    List<Product> findByOrderById();
    Product findById(Integer id);
    Product findByName(String name);
    void deleteById(Integer id);
}
