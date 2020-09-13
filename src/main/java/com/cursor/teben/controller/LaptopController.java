package com.cursor.teben.controller;

import com.cursor.teben.entity.Laptop;
import com.cursor.teben.service.LaptopService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/laptops")
@RestController
@RequiredArgsConstructor
public class LaptopController {

    private final LaptopService laptopService;

    @GetMapping
    public List<Laptop> getAllLaptops() {
        log.info("\t\t\tAll laptops");
        return laptopService.findAllLaptops();
    }

    @GetMapping("/used")
    public List<Laptop> getUsedLaptops() {
        log.info("\t\t\tUsed laptops");
        return laptopService.findAllLaptopsByUsedIs(true);
    }

    @GetMapping("/ram")
    public List<Laptop> getLaptopsByRam() {
        log.info("\t\t\tLaptops with RAM more than 16");
        return laptopService.findAllLaptopsByRamAfter(16);
    }

    @GetMapping("/ordered")
    public List<Laptop> getAllLaptopsOrderedByProducerDesc() {
        log.info("\t\t\tLaptops ordered by producer in descending");
        return laptopService.findAllLaptopsOrderByProducerDesc();
    }
}
