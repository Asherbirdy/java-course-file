package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/students/{studentId}",3)
                .header("headerName", "headerValue")
                .param("graduate", "true");

        MvcResult mvcResult = mockMvc.perform(request)
                .andDo(print()) // request語法
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id",equalTo(3)))
                .andExpect(jsonPath("$.name", notNullValue()))
                .andReturn(); // api 結果

        String body = mvcResult.getResponse().getContentAsString();
        System.out.println("返回的 response body: " + body);

        }


    @Test
    public void create() throws  Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\":\"test\",\n" +
                        "    \"score\":13.3,\n" +
                        "    \"graduate\": false\n" +
                        "}");

        mockMvc.perform(request)
                .andExpect(status().is(201));
    }
}