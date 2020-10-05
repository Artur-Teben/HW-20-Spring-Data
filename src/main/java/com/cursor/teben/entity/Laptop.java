package com.cursor.teben.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Laptop")
public class Laptop {

    @Id
    String id;

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
