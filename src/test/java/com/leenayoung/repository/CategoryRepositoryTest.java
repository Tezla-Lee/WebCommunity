package com.leenayoung.repository;

import com.leenayoung.model.Category;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepo;

    @Before
    public void prepareTest() {
        Category category1 = new Category();
        category1.setName("Category1");
        categoryRepo.save(category1);
    }



    @Test
    public void findByName() {
        Category result = categoryRepo.findByName("Category1");
        assertEquals("Category1", result.getName() );
    }
}