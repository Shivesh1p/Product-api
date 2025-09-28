package com.shivesh.product.controller;

import com.shivesh.product.dto.ProductDTO;
import com.shivesh.product.entity.Product;
import com.shivesh.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


    //getallproduct
    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    //getProductB
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }


    @PostMapping
    public ResponseEntity<ProductDTO> createProductDTO(@RequestBody ProductDTO productDTO){
       ProductDTO createdProduct = productService.createProduct(productDTO);
       return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);


    }

    // update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);

    }

    //delete mapping

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }


}
