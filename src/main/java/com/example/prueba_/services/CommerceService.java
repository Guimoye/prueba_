package com.example.prueba_.services;

import com.example.prueba_.entities.Commerce;
import java.util.List;

public interface CommerceService {

    Commerce save(Commerce commerce);
    List<Commerce> findAll();
    Commerce findByStartDateAndProductIdAndBrandId(String date,int productId,int brandId);

}
