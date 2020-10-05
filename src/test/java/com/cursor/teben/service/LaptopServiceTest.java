package com.cursor.teben.service;

import com.cursor.teben.entity.Laptop;
import com.cursor.teben.entity.LaptopBuilder;
import com.cursor.teben.repository.LaptopRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LaptopServiceTest {

    @Mock
    private LaptopRepository laptopRepositoryMock;

    @InjectMocks
    private LaptopService laptopService = new LaptopService();

    @InjectMocks
    private LaptopBuilder laptopBuilder = new LaptopBuilder();

    private List<Laptop> laptopList = new ArrayList<>(Arrays.asList(laptopBuilder.buildModel("A715-41G-R7MZ").buildProducer("Acer")
            .buildProcessor("AMD Ryzen 3 3300U").buildRam(8).buildUsed(false).buildBodyType("carbon")
            .buildPrice(BigDecimal.valueOf(20_999)).buildYear(2018).build(),
    laptopBuilder.buildModel("8RW14EA").buildProducer("HP")
                .buildProcessor("AMD Ryzen 5 3550H").buildRam(8).buildUsed(true).buildBodyType("plastic")
                .buildPrice(BigDecimal.valueOf(14_499)).buildYear(2017).build(),
    laptopBuilder.buildModel("7DT87EA").buildProducer("HP")
                .buildProcessor("Intel Core i5-9300H").buildRam(16).buildUsed(false).buildBodyType("aluminum")
                .buildPrice(BigDecimal.valueOf(18_499)).buildYear(2019).build()));

    @Test
    public void shouldSaveLaptop() {
        Laptop laptop = laptopBuilder.buildModel("7DT87EA").buildProducer("HP")
                .buildProcessor("Intel Core i5-9300H").buildRam(16).buildUsed(false).buildBodyType("aluminum")
                .buildPrice(BigDecimal.valueOf(18_499)).buildYear(2019).build();
        laptopService.save(laptop);
        verify(laptopRepositoryMock).save(laptop);
    }

    @Test
    public void shouldFindAllLaptops() {
        doReturn(laptopList).when(laptopRepositoryMock).findAll();
        assertEquals(laptopService.findAllLaptops(), laptopList);
        verify(laptopRepositoryMock, Mockito.times(1)).findAll();
    }

    @Test
    public void shouldFindAllLaptopsOrderByProducerDesc() {
        List<Laptop> laptopsByProducer = laptopRepositoryMock.findByOrderByProducerDesc();
        assertEquals(laptopsByProducer, laptopService.findAllLaptopsOrderByProducerDesc());
    }

    @Test
    public void shouldFindAllLaptopsByRamAfterSixteen() {
        List<Laptop> laptopsByRam = laptopRepositoryMock.findByRamAfter(16);
        assertEquals(laptopsByRam, laptopService.findAllLaptopsByRamAfter(16));
    }

    @Test
    public void shouldFindAllLaptopsByUsedIsTrue() {
        List<Laptop> usedLaptops = laptopRepositoryMock.findByUsedIs(true);
        assertEquals(usedLaptops, laptopService.findAllLaptopsByUsedIs(true));
    }

}