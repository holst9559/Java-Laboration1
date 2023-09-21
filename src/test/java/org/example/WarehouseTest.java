package org.example;

import static org.example.Laboration3.entities.Category.*;

import org.example.Laboration3.entities.ProductRecord;
import org.example.Laboration3.entities.Product;

import org.example.Laboration3.service.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {
    private Warehouse warehouse;
    private LocalDate now;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
        Clock fixedClock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        now = LocalDate.now(fixedClock);

    }

    @Test
    void shouldAddNewProduct() {
        Product product = new Product("Pilsnermalt", MALT, 4);
        warehouse.addNewProduct(product.toRecord());

        assertNotNull(product.getId());
        assertEquals("Pilsnermalt", product.getName());
        assertEquals(MALT, product.getCategory());
        assertEquals(4, product.getRating());
        assertEquals(now, product.getCreatedAt());
        assertEquals(now, product.getUpdatedAt());
    }

    @Test
    void shouldThrowAddNewProductException() {
        Product product1 = new Product("", MALT, 4);
        Product product2 = new Product("Pilsnermalt", MALT, 6);
        Product product3 = new Product("Pilsnermalt", MALT, -1);

        assertThrows(IllegalArgumentException.class, () -> warehouse.addNewProduct(product1.toRecord()));
        assertThrows(IllegalArgumentException.class, () -> warehouse.addNewProduct(product2.toRecord()));
        assertThrows(IllegalArgumentException.class, () -> warehouse.addNewProduct(product3.toRecord()));
    }


    @Test
    void shouldUpdateProduct() {
        Product mockProduct = new Product("Pilsnermalt", MALT, 4, LocalDate.now().minusDays(1), LocalDate.now());
        warehouse.addNewProduct(mockProduct.toRecord());

        ProductRecord update = new ProductRecord(mockProduct.getId(), "Simcoe", HOPS, 1, LocalDate.now(), LocalDate.now());
        ProductRecord updatedProduct = warehouse.updateProduct(update);

        assertEquals(1, updatedProduct.rating());
        assertEquals("Simcoe", updatedProduct.name());
        assertEquals(HOPS, updatedProduct.category());
        assertEquals(LocalDate.now(), updatedProduct.updatedAt());
        assertEquals(LocalDate.now().minusDays(1), updatedProduct.createdAt());
    }

    @Test
    void shouldThrowUpdateException() {
        Product mockProduct = new Product("Pilsnermalt", MALT, 4, LocalDate.now().minusDays(1), LocalDate.now());
        warehouse.addNewProduct(mockProduct.toRecord());

        ProductRecord update1 = new ProductRecord("123", "Simcoe", HOPS, 1, LocalDate.now(), LocalDate.now());
        ProductRecord update2 = new ProductRecord("", "Simcoe", HOPS, 1, LocalDate.now(), LocalDate.now());

        assertThrows(IllegalArgumentException.class, () -> warehouse.updateProduct(update1));
        assertThrows(IllegalArgumentException.class, () -> warehouse.updateProduct(update2));
    }

    @Test
    void shouldReturnAllProducts() {
        Product product1 = new Product("Pilsnermalt", MALT, 4);
        Product product2 = new Product("Simcoe", HOPS, 5);

        warehouse.addNewProduct(product1.toRecord());
        warehouse.addNewProduct(product2.toRecord());

        List<ProductRecord> allProducts = warehouse.getAllProducts();

        assertEquals(2, allProducts.size());
        assertEquals("Pilsnermalt", allProducts.get(0).name());
        assertEquals("Simcoe", allProducts.get(1).name());
    }

    @Test
    void shouldReturnMatchingId() {
        Product product = new Product("Pilsnermalt", MALT, 4);

        warehouse.addNewProduct(product.toRecord());

        ProductRecord getProduct = warehouse.getProductById(product.getId());

        assertEquals("Pilsnermalt", getProduct.name());
        assertEquals(product.getId(), getProduct.id());
        assertNotEquals("Simcoe", getProduct.name());
    }

    @Test
    void shouldThrowExceptionWhenIdIsNotPresent() {
        Product product = new Product("Pilsnermalt", MALT, 4);

        warehouse.addNewProduct(product.toRecord());

        assertThrows(IllegalArgumentException.class, () -> warehouse.getProductById("123"));
        assertThrows(IllegalArgumentException.class, () -> warehouse.getProductById(""));
    }

    @Test
    void shouldReturnMatchingCategory() {
        Product product1 = new Product("Pilsnermalt", MALT, 4);
        Product product2 = new Product("Chokladmalt", MALT, 2);
        Product product3 = new Product("Simcoe", HOPS, 5);

        warehouse.addNewProduct(product1.toRecord());
        warehouse.addNewProduct(product2.toRecord());
        warehouse.addNewProduct(product3.toRecord());

        List<ProductRecord> categoryList = warehouse.getProductsByCategory(MALT);

        assertEquals(2, categoryList.size());
        assertEquals("Chokladmalt", categoryList.get(0).name());

    }

    @Test
    void shouldReturnProductsAfterSpecificDate() {
        Product product1 = new Product("Pilsnermalt", MALT, 4,
                LocalDate.now().minusDays(5),
                LocalDate.now().minusDays(5));
        Product product2 = new Product("Simcoe", HOPS, 5);

        warehouse.addNewProduct(product1.toRecord());
        warehouse.addNewProduct(product2.toRecord());

        List<ProductRecord> newProducts = warehouse.getProductsAfterDate(LocalDate.now()
                .minusDays(2));

        assertEquals(1, newProducts.size());
        assertEquals("Simcoe", newProducts.get(0).name());

    }

    @Test
    void shouldReturnUpdatedProducts() {
        Product product1 = new Product("Pilsnermalt", MALT, 4, LocalDate.now().minusDays(2), LocalDate.now().minusDays(2));
        Product product2 = new Product("Chokladmalt", MALT, 2, LocalDate.now().minusDays(2), LocalDate.now().minusDays(2));

        warehouse.addNewProduct(product1.toRecord());
        warehouse.addNewProduct(product2.toRecord());

        ProductRecord update = new ProductRecord(product1.getId(), "Pilsnermalt", MALT, 1, LocalDate.now(), LocalDate.now());
        warehouse.updateProduct(update);

        List<ProductRecord> updatedProducts = warehouse.getUpdatedProducts();
        System.out.println(updatedProducts);

        assertEquals(1, updatedProducts.size());
        assertEquals(1, updatedProducts.get(0).rating());

    }
}
