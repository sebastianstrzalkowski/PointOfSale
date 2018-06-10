package pl.sebastianstrzalkowski.models;

import pl.sebastianstrzalkowski.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsRepository {
    private List<Product> productTable = new ArrayList<>();



    public ProductsRepository(List<Product> productTable){
        this.productTable = productTable;
    }

    public Product findByBarcode(Barcode barcode){
        Product foundProduct = searchForProduct(barcode);

        if(foundProduct == new Product()){
            throw new ProductNotFoundException("Product not found");
        }
        return foundProduct;
    }

    public Product searchForProduct(Barcode barcode){
        Product foundProduct = new Product();
        for(Product x : productTable){
            if(x.getBarcode().toString().equals(barcode.toString())){
                foundProduct = x;
                break;
            }
        }
        return foundProduct;
    }
}
