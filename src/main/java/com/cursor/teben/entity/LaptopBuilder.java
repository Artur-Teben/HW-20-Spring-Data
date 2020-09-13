package com.cursor.teben.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LaptopBuilder {
    String model;
    String producer;
    String processor;
    Integer ram;
    Boolean used;
    String bodyType;
    BigDecimal price;
    Integer year;

    public LaptopBuilder buildModel(String model) {
        this.model = model;
        return this;
    }

    public LaptopBuilder buildProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public LaptopBuilder buildProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public LaptopBuilder buildRam(Integer ram) {
        this.ram = ram;
        return this;
    }

    public LaptopBuilder buildUsed(Boolean used) {
        this.used = used;
        return this;
    }

    public LaptopBuilder buildBodyType(String bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    public LaptopBuilder buildPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LaptopBuilder buildYear(Integer year) {
        this.year = year;
        return this;
    }

    public Laptop build() {
        return new Laptop(model, producer, processor, ram, used, bodyType, price, year);
    }

}
