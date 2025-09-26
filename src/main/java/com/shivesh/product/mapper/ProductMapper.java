package com.shivesh.product.mapper;

import com.shivesh.product.dto.ProductDTO;
import com.shivesh.product.entity.Category;
import com.shivesh.product.entity.Product;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );

    }
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(product.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return product;
    }
}
