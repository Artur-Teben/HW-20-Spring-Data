package com.cursor.teben.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String model;
    String producer;
    String processor;
    Integer ram;
    Boolean used;
    String bodyType;
    BigDecimal price;
    Integer year;

    public Laptop(String model, String producer, String processor,
                  Integer ram, Boolean used, String bodyType,
                  BigDecimal price, Integer year) {
        this.model = model;
        this.producer = producer;
        this.processor = processor;
        this.ram = ram;
        this.used = used;
        this.bodyType = bodyType;
        this.price = price;
        this.year = year;
    }
}
