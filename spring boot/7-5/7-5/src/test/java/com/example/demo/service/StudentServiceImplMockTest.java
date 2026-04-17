package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceImplMockTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentDao studentDao;

    @BeforeEach
    public void beforeEach() {
        // MOCK
        Student mockStudent = new Student();
        mockStudent.setId(3);
        mockStudent.setName("Judy");
        Mockito.when(studentDao.getById(Mockito.any())).thenReturn(mockStudent);
    }

    @Test
    public void getById() {
        // TEST
        Student student = studentService.getById(2);
        assertNotNull(student);
        assertEquals(3, student.getId());
        assertEquals("Judy", student.getName());
    }

    @Test
    public void getById2() {
        // TEST
        Student student = studentService.getById(2);
        assertNotNull(student);
        assertEquals(3, student.getId());
        assertEquals("Judy", student.getName());
    }
}