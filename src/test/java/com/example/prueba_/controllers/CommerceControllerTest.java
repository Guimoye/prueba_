package com.example.prueba_.controllers;

import com.example.prueba_.entities.Commerce;
import com.example.prueba_.services.CommerceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
import java.util.*;
import static org.mockito.Mockito.*;

@WebMvcTest(CommerceController.class)
class CommerceControllerTest {


    @MockBean
    private CommerceService commerceService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void save() throws Exception{
        Commerce commerce = new Commerce();
        commerce.setBrandId(1);
        commerce.setProductId(2);

        mvc.perform(post("/api/v1/prueba/commerce").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(commerce)))
                .andExpect(status().isCreated())
                .andDo(print());
        verify(commerceService).save(any());
    }

    @Test
    void findAll() throws Exception{

        Commerce commerce = new Commerce();
        commerce.setBrandId(1);
        commerce.setProductId(2);

        List<Commerce> list = new ArrayList<>();
        list.add(commerce);

        when(commerceService.findAll()).thenReturn(list);
        mvc.perform(get("/api/v1/prueba/commerce/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(list.size()))
                .andDo(print());
        verify(commerceService).findAll();
    }

    @Test
    void find() throws Exception{

        Commerce commerce = new Commerce();
        commerce.setStartDate(null);
        commerce.setEndDate(null);
        commerce.setBrandId(1);
        commerce.setProductId(2);

        when(commerceService.findByStartDateAndProductIdAndBrandId("",2,1)).thenReturn(commerce);
        mvc.perform(get("/api/v1/prueba/commerce/find/{date}/{productId}/{brandId}", "",2,1))
                .andExpect(status().isNotFound())
                .andDo(print());

    }


    @Test
    void findString() throws Exception{

        Commerce commerce = new Commerce();
        commerce.setStartDate(null);
        commerce.setEndDate(null);
        commerce.setBrandId(1);
        commerce.setProductId(2);

        when(commerceService.findByStartDateAndProductIdAndBrandId("",2,1)).thenReturn(commerce);
        mvc.perform(get("/api/v1/prueba/commerce/findString/{date}/{productId}/{brandId}", "",2,1))
                .andExpect(status().isNotFound())
                .andDo(print());

    }
}