package com.cursor.teben.repository;

import com.cursor.teben.entity.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends MongoRepository<Laptop, String> {
    List<Laptop> findByOrderByProducerDesc();
    List<Laptop> findByRamAfter(Integer ram);
    List<Laptop> findByUsedIs(Boolean used);
}
