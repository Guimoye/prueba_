package com.example.prueba_.repositories;

import com.example.prueba_.entities.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommerceRepository extends JpaRepository<Commerce,Long> {

    @Query(value = "SELECT " +
                        "c.ID, " +
                        "c.BRAND_ID, " +
                        "c.CURR, " +
                        "c.END_DATE, " +
                        "c.START_DATE, " +
                        "c.PRICE, " +
                        "c.PRICE_LIST, " +
                        "c.PRIORITY, " +
                        "c.PRODUCT_ID  " +
                    "FROM COMMERCES as c " +
                    "where (c.START_DATE >= ?1 and ?1 <= c.END_DATE) " +
                    "and c.PRODUCT_ID = ?2 and c.BRAND_ID = ?3 limit 1", nativeQuery = true)
    Commerce findByStartDateAndProductIdAndBrandId(String date,int productId,int brandId);

}
