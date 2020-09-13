package com.cursor.teben.executor;

import com.cursor.teben.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Executor {
    @Autowired
    LaptopService laptopService;

    public void runApplication() {
        laptopService.insertLaptops();

        System.out.println("\t\t\tAll laptops");
        laptopService.printAllLaptops(laptopService.findAllLaptops());

        System.out.println("\t\t\tLaptops ordered by producer by descending");
        laptopService.printAllLaptops(laptopService.findAllLaptopsOrderByProducerDesc());

        System.out.println("\t\t\tLaptops with RAM more than 16");
        laptopService.printAllLaptops(laptopService.findAllLaptopsByRamAfter(16));

        System.out.println("\t\t\tUsed laptops");
        laptopService.printAllLaptops(laptopService.findAllLaptopsByUsedIs(true));
    }
}
