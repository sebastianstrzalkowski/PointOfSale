package tests;

import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;
import pl.sebastianstrzalkowski.exception.ProductNotFoundException;
import pl.sebastianstrzalkowski.models.Barcode;
import pl.sebastianstrzalkowski.models.Product;
import pl.sebastianstrzalkowski.models.ProductsRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestRepo {
    private ProductsRepository productsRepository;
    private Product sampleProduct;


    @Test
    public void shouldFindByBarcode() {
        //when
        List<Product> productTable = new ArrayList<Product>();
        sampleProduct = new Product(new Barcode("xx"), "Sample name", 5);
        productTable.add(sampleProduct);
        ProductsRepository productsRepository = new ProductsRepository(productTable);
        Product product = productsRepository.searchForProduct(new Barcode("xx"));
        assertEquals(sampleProduct.toString(), product.toString());
    }
    @Test
    public void shouldNotFindByBarcode() {
        //when
        List<Product> productTable = new ArrayList<Product>();
        sampleProduct = new Product(new Barcode("xx"), "Sample name", 5);
        productTable.add(sampleProduct);
        ProductsRepository productsRepository = new ProductsRepository(productTable);
        Product product = productsRepository.searchForProduct(new Barcode("yy"));
        for(Product x : productTable){
            System.out.println(x);
        }
        assertNotEquals(sampleProduct.toString(), product.toString());
    }


}