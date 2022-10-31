package com.example.prueba_.services;

import com.example.prueba_.entities.Commerce;
import com.example.prueba_.repositories.CommerceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CommerceServiceImplTest {

    @Autowired
    private CommerceService service;

    @Autowired
    private CommerceServiceImpl commerceService;
    @MockBean
    private CommerceRepository repository;


    @Test
    void save() {

        Commerce commerce = new Commerce();
        commerce.setBrandId(1);
        commerce.setPrice(1.2);
        commerce.setProductId(2);
        commerce.setPriceList(3);

        when(repository.save(any(Commerce.class))).thenReturn(commerce);

        Commerce transaction_end = service.save(commerce);
        assertEquals(commerce,transaction_end);
    }

    @Test
    void findByStartDateAndProductIdAndBrandId() {

        Commerce commerce = new Commerce();
        commerce.setBrandId(1);
        commerce.setPrice(1.2);
        commerce.setProductId(2);
        commerce.setPriceList(3);

        when(repository.findByStartDateAndProductIdAndBrandId(null,2,1)).thenReturn(commerce);

        Commerce transaction_end = service.findByStartDateAndProductIdAndBrandId(null,2,1);
        assertEquals(commerce,transaction_end);
    }

    @Test
    void findAll() {
        Commerce commerce = new Commerce();
        commerce.setBrandId(1);
        commerce.setPrice(1.2);
        commerce.setProductId(2);
        commerce.setPriceList(3);
        List<Commerce> list = new ArrayList<>();
        list.add(commerce);

        when(repository.findAll()).thenReturn(list);

        List<Commerce>  transaction_end = service.findAll();
        assertEquals(list,transaction_end);
    }
}