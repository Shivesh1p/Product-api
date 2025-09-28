package com.shivesh.product.service;


import com.shivesh.product.dto.CategoryDTO;
import com.shivesh.product.entity.Category;
import com.shivesh.product.mapper.CategoryMapper;
import com.shivesh.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);


    }
    //get all categories
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    public CategoryDTO getCategoryById(Long id){
       Category category =  categoryRepository.findById(id).orElseThrow(()-> new
                RuntimeException("Category not found"));
       return CategoryMapper.toCategoryDTO(category);
    }

    //delete category
    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category "+ id + "has been deleted";
    }

}
