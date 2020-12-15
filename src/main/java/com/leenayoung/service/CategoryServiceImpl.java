package com.leenayoung.service;

import com.leenayoung.model.Category;
import com.leenayoung.repository.CategoryRepository;

public class CategoryServiceImpl {

    CategoryRepository categoryRepo;

    public int insertCategory(Category category) {

        if(categoryRepo.findByName(category.getName())!=null){
            categoryRepo.save(category);
            return 1;
        } else {
            System.out.println("이미 존재하는 이름입니다.");
            return -1;
        }

    }
}
