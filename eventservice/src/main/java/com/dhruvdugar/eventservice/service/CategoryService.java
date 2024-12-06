package com.dhruvdugar.eventservice.service;

import com.dhruvdugar.eventservice.entity.Category;
import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAllCategories();
}
