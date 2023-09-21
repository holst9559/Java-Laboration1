package org.example.Laboration3.service;

import org.example.Laboration3.entities.Product;
import org.example.Laboration3.entities.ProductRecord;

import java.time.LocalDate;
import java.util.*;

/*
Lägga till en ny produkt. (Bör ha någon enkel validering så att produkter utan namn ej kan läggas till)
•Modifiera en befintlig produkt. (Byta namn, kategori, rating)
•Hämta alla produkter.•Hämta en produkt genom produktens id.
•Hämta alla produkter som hör till en kategori sorterat efter produktnamn a-z.
•Hämta alla produkter skapade efter ett angivet datum. (Nya produkter sen sist)
•Hämta alla produkter som modifierats sen de skapades. (Datum ej samma)

*/


public class Warehouse {

    private final List<Product> products = new ArrayList<>();
    private final int maxRating = 5;


    public ProductRecord addNewProduct(ProductRecord product) {
        if (product.name() == null || product.name().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (product.rating() > maxRating || product.rating() < 0) {
            throw new IllegalArgumentException("Rating cannot be higher than 5");
        }

        Product newProduct = new Product(product);
        products.add(newProduct);


        return newProduct.toRecord();
    }

    public ProductRecord updateProduct(ProductRecord productUpdate){
        return products.stream().filter(product -> product.getId().equals(productUpdate.id())).findFirst()
                .map(product -> {
                    product.setName(productUpdate.name());
                    product.setCategory(productUpdate.category());
                    product.setRating(productUpdate.rating());
                    product.setUpdatedAt(LocalDate.now());
                    return product.toRecord();
                }).orElseThrow(() -> new IllegalArgumentException("Product ID does not exist"));
    }

}
