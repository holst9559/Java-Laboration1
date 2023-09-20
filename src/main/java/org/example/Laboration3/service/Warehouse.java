package org.example.Laboration3.service;

import org.example.Laboration3.entities.Category;
import org.example.Laboration3.entities.Product;
import org.example.Laboration3.entities.ProductRecord;

import java.util.*;

public class Warehouse {

    private final List<Product> products = new ArrayList<>();
    private final int maxRating = 5;

    public ProductRecord addNewProduct(ProductRecord product){
        if(product.name() == null || product.name().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }else if(product.rating() > maxRating || product.rating() < 0){
            throw new IllegalArgumentException("Rating cannot be higher than 5");
        }

        Product newProduct = new Product(product.name(), product.category(), product.rating());
        products.add(newProduct);

        return newProduct.toRecord();
    }


}
