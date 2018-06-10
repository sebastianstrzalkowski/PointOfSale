package pl.sebastianstrzalkowski.models;

import java.util.ArrayList;
import java.util.List;

import static pl.sebastianstrzalkowski.System.Validator.checkNotNull;

public class ShoppingCart {

    private static List <Product> listOfProducts;
    private double worthOfShopping = 0;

    public ShoppingCart() {
        this.listOfProducts = new ArrayList<>();
    }

    private void setWortOfShopping(Product product){
            worthOfShopping +=  product.getPrice();
    }

    public double getWorthOfShopping() {
        return worthOfShopping;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void add(Product product) {
        checkNotNull(product);
        listOfProducts.add(product);
        setWortOfShopping(product);
    }
}
