package com.edu.domain.model.category;

import com.edu.domain.model.user.UserId;
import com.edu.infrastructure.repository.CategoryRepository;

import org.springframework.stereotype.Component;

@Component
public class CategoryManagement {

  private CategoryRepository categoryRepository;

  public CategoryManagement(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

}
