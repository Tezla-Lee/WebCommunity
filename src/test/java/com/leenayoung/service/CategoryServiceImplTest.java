package com.leenayoung.service;

import com.leenayoung.model.Category;
import com.leenayoung.repository.CategoryRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    CategoryServiceImpl categoryService;
    CategoryRepository categoryRepo;

    @Before
    public void prepTest(){
        Category category = new Category();
        category.setName("카테고리");
        categoryRepo.save(category);

    }

    @Test
    public void insertCategory() {
        Category category = new Category();
        category.setName("카테고리");
        int result =categoryService.insertCategory(category);

        assertEquals( -1 , result);
    }

    @Test
    public void updateCategory() {

    }
}