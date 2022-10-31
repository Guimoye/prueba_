package com.example.prueba_.repositories;

import com.example.prueba_.entities.Commerce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CommerceRepositoryTest {

    @Autowired
    CommerceRepository repository;

    @Test
    void findByStartDateAndProductIdAndBrandId() {
        Commerce test = repository.findByStartDateAndProductIdAndBrandId("2020-06-14",1,2);
        Commerce test_end = new Commerce();
        assertEquals(test,test_end);
    }


    @Test
    void testSave() {

        Commerce commerce = new Commerce();
        commerce.setBrandId(1);
        commerce.setPrice(1.2);
        commerce.setProductId(2);
        commerce.setPriceList(3);

        Commerce test_end = repository.save(commerce);

        assertEquals(1, test_end.getBrandId());
        assertEquals(1.2, test_end.getPrice());
    }


    @Test
    void findAll() {
        List<Commerce> test = repository.findAll();
        List<Commerce> test_end = new ArrayList<>();
        assertEquals(test,test_end);
    }


}