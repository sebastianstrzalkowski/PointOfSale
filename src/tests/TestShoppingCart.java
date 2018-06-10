package tests;

import org.junit.jupiter.api.Test;
import pl.sebastianstrzalkowski.models.Barcode;
import pl.sebastianstrzalkowski.models.Product;
import pl.sebastianstrzalkowski.models.ShoppingCart;

public class TestShoppingCart {

    Product product1;

    @Test
    public void shouldAddOne(){
        ShoppingCart shoppingCart = new ShoppingCart();
        product1 = new Product(new Barcode("xx"),"Name",5);
        shoppingCart.add(product1);
        System.out.println(shoppingCart.getWorthOfShopping());
        assert(shoppingCart.getListOfProducts().size() == 1);
        assert(shoppingCart.getWorthOfShopping() == 5.0);
    }

    @Test
    public void shouldAddTwo(){
        ShoppingCart shoppingCart = new ShoppingCart();
        product1 = new Product(new Barcode("xx"),"Name",5);
        shoppingCart.add(product1);
        shoppingCart.add(product1);
        System.out.println(shoppingCart.getWorthOfShopping());
        assert(shoppingCart.getListOfProducts().size() == 2);
        assert(shoppingCart.getWorthOfShopping() == 10.0);
    }
    @Test
    public void shouldAddThree(){
        ShoppingCart shoppingCart = new ShoppingCart();
        product1 = new Product(new Barcode("xx"),"Name",5);
        shoppingCart.add(product1);
        shoppingCart.add(product1);
        shoppingCart.add(product1);
        System.out.println(shoppingCart.getWorthOfShopping());
        assert(shoppingCart.getListOfProducts().size() == 3);
        assert(shoppingCart.getWorthOfShopping() == 15.0);
    }

}
