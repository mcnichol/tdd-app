package io.mcnichol.tdd.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //Data  is populated  with our data.sql file in  our /src/main/test/resources/data.sql  file. The tests you shared  appear to add these  values through the  testing  process

    @Test
    public void getProduct() throws Exception {
        mockMvc.perform(get("/products/{id}", 1)
                .param("category", "Bedroom"))   //This value is just to show you how to search with a request param, no functionality exists to filter on it
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Bedroom")))
                .andExpect(content().string(containsString("1")));
    }


    @Test
    public void getMissingProduct() throws Exception {
        mockMvc.perform(get("/products/{id}", 4))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("4")));
    }
}