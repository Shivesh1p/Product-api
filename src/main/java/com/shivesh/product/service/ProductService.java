package com.shivesh.product.service;


import com.shivesh.product.dto.ProductDTO;
import com.shivesh.product.entity.Category;
import com.shivesh.product.entity.Product;
import com.shivesh.product.mapper.ProductMapper;
import com.shivesh.product.repository.CategoryRepository;
import com.shivesh.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category Not Found!"));

        //DTO-> Entity
       Product product =  ProductMapper.toProductEntity(productDTO , category);
       product = productRepository.save(product);

       //Entity-> DTO
       return ProductMapper.toProductDTO(product);



    }
    //get all product
    public List<ProductDTO> getAllProducts(){
        return  productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    //get product By id
    public  ProductDTO getProductById(Long id){
       Product product = productRepository.findById(id)
               .orElseThrow(() -> new
               RuntimeException("Product Not Found"));
       return ProductMapper.toProductDTO(product);
    }

    //update Product

    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category Not Found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product "+ id + "has been deleted!";
    }
}


