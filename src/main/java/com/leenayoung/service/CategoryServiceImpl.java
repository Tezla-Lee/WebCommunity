package com.leenayoung.service;

import com.leenayoung.model.Category;
import com.leenayoung.repository.CategoryRepository;

public class CategoryServiceImpl {

    CategoryRepository categoryRepo;

    public void insertCategory(Category category) {


        categoryRepo.save(category);
    }
}
