package com.example.prueba_.services;

import com.example.prueba_.entities.Commerce;
import com.example.prueba_.repositories.CommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CommerceServiceImpl implements CommerceService {

    @Autowired
    private CommerceRepository repository;


    @Override
    public Commerce save(Commerce commerce) {
        return repository.save(commerce);
    }

    @Override
    public List<Commerce> findAll() {
        return repository.findAll();
    }

    @Override
    public Commerce findByStartDateAndProductIdAndBrandId(String date,int productId,int brandId) {
        return repository.findByStartDateAndProductIdAndBrandId(date,productId,brandId);
    }
}
