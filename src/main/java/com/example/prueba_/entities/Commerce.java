package com.example.prueba_.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="commerces")
public class Commerce {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter
    private Integer brandId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter
    private Date startDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter
    private Date endDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter
    private Integer priceList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter
    private Integer productId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter
    private Integer priority;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter
    private  Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter
    private  String curr;

    @JsonIgnore
    public String getResponString (){

        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        String hours = dateFormat.format(startDate);

        dateFormat = new SimpleDateFormat("dd");
        String day = dateFormat.format(startDate);

        return "Petición a las "+hours+" del día "+day+" del producto "+this.productId+" para la brand "+this.brandId +" (ZARA)";
    }



}
