package com.SpringBoot.Ecomm.controller;


import com.SpringBoot.Ecomm.model.Product;
import com.SpringBoot.Ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/getProductById")
    public Product getProductById(@PathVariable Long productId)
    {
        return productService.getProductById(productId);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@PathVariable Long id)
    {
        productService.deleteProductById(id);
    }



}
