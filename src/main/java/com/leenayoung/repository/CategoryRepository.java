package com.leenayoung.repository;

import com.leenayoung.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    public Category findByName(String name);
}
