package pl.sebastianstrzalkowski.devices.output;

import pl.sebastianstrzalkowski.models.Product;
import pl.sebastianstrzalkowski.models.ShoppingCart;

public class LCD {

    public LCD(){};
    public void printSummary(ShoppingCart shoppingCart){
        System.out.println("Total price: " + shoppingCart.getWorthOfShopping());
    }

    public void printProduct(Product product){
        System.out.print(product.getName() + "/t" + product.getPrice());
    }

    public void printNotFound(){
        System.out.print("Product not found");
   }

    public void printInvalidBarcode(){
        System.out.print("Invalid bar-code");
   }

}
