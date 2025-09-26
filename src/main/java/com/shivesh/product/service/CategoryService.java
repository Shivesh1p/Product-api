package com.shivesh.product.service;


import com.shivesh.product.dto.CategoryDTO;
import com.shivesh.product.entity.Category;
import com.shivesh.product.mapper.CategoryMapper;
import com.shivesh.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);


    }

}
