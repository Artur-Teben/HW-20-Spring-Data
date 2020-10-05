package com.cursor.teben.service;

import com.cursor.teben.entity.Laptop;
import com.cursor.teben.entity.LaptopBuilder;
import com.cursor.teben.repository.LaptopRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private LaptopBuilder laptopBuilder;


    public void insertLaptops() {
        save(laptopBuilder.buildModel("A715-41G-R7MZ").buildProducer("Acer")
                .buildProcessor("AMD Ryzen 3 3300U").buildRam(8).buildUsed(false).buildBodyType("carbon")
                .buildPrice(BigDecimal.valueOf(20_999)).buildYear(2018).build());
        save(laptopBuilder.buildModel("8RW14EA").buildProducer("HP")
                .buildProcessor("AMD Ryzen 5 3550H").buildRam(8).buildUsed(true).buildBodyType("plastic")
                .buildPrice(BigDecimal.valueOf(14_499)).buildYear(2017).build());
        save(laptopBuilder.buildModel("7DT87EA").buildProducer("HP")
                .buildProcessor("Intel Core i5-9300H").buildRam(16).buildUsed(false).buildBodyType("aluminum")
                .buildPrice(BigDecimal.valueOf(18_499)).buildYear(2019).build());
        save(laptopBuilder.buildModel("90NR0381-M01640").buildProducer("Asus")
                .buildProcessor("Intel Core i7-10750H").buildRam(24).buildUsed(false).buildBodyType("steel")
                .buildPrice(BigDecimal.valueOf(31_999)).buildYear(2020).build());
        save(laptopBuilder.buildModel("NX.HVGEU.006").buildProducer("Acer")
                .buildProcessor("Intel Core i5-10210U").buildRam(8).buildUsed(true).buildBodyType("iron")
                .buildPrice(BigDecimal.valueOf(17_999)).buildYear(2017).build());
        save(laptopBuilder.buildModel("I3582C54H5NIL-BK").buildProducer("Dell")
                .buildProcessor("Intel Celeron N4000").buildRam(4).buildUsed(true).buildBodyType("plastic")
                .buildPrice(BigDecimal.valueOf(6_999)).buildYear(2016).build());
        save(laptopBuilder.buildModel("90NB0PD6-M02540").buildProducer("Asus")
                .buildProcessor("AMD Ryzen 7 3700U").buildRam(16).buildUsed(false).buildBodyType("carbon")
                .buildPrice(BigDecimal.valueOf(23_999)).buildYear(2018).build());
        save(laptopBuilder.buildModel("MXK32UA/A").buildProducer("Apple")
                .buildProcessor(" Intel Core i5-8257U").buildRam(8).buildUsed(true).buildBodyType("aluminum")
                .buildPrice(BigDecimal.valueOf(43_499)).buildYear(2018).build());
        save(laptopBuilder.buildModel("MXK72UA/A").buildProducer("Apple")
                .buildProcessor("Intel Core i5-8257U").buildRam(24).buildUsed(false).buildBodyType("steel")
                .buildPrice(BigDecimal.valueOf(49_999)).buildYear(2019).build());
        save(laptopBuilder.buildModel("81MX0035RA").buildProducer("Lenovo")
                .buildProcessor("Intel Pentium Silver N5000").buildRam(8).buildUsed(false).buildBodyType("copper")
                .buildPrice(BigDecimal.valueOf(11_299)).buildYear(2018).build());
    }

    public void save(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    public List<Laptop> findAllLaptops() {
        return laptopRepository.findAll();
    }

    public void printAllLaptops(List<Laptop> laptops) {
        laptops.forEach(System.out::println);
    }

    public List<Laptop> findAllLaptopsOrderByProducerDesc() {
        return laptopRepository.findByOrderByProducerDesc();
    }

    public List<Laptop> findAllLaptopsByRamAfter(Integer ram) {
        return laptopRepository.findByRamAfter(ram);
    }

    public List<Laptop> findAllLaptopsByUsedIs(Boolean used) {
        return laptopRepository.findByUsedIs(used);
    }
}
