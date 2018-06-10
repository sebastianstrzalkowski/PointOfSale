package pl.sebastianstrzalkowski.devices.output;

import pl.sebastianstrzalkowski.models.Product;
import pl.sebastianstrzalkowski.models.ShoppingCart;

import java.util.List;

public class Printer {

    public Printer(){};

    public void printBill(ShoppingCart shoppingCart){
        StringBuilder bill = new StringBuilder();
        createBill(bill,shoppingCart.getListOfProducts(),shoppingCart.getWorthOfShopping());
        System.out.print(bill);
    }

    private void createBill(StringBuilder bill, List<Product> products, double worthOfShopping){
        createHeader(bill);
        createBody(bill, products);
        createFooter(bill, worthOfShopping);
    }


    private void createHeader(StringBuilder bill){
        bill.append("Name\t").append("Price\t").append(System.lineSeparator());
    }

    private void createBody(StringBuilder bill, List<Product> products){
        for(Product x : products){
            bill.append(x.getName()).append("\t").append(x.getPrice()).append(System.lineSeparator());
        }

    }

    private void createFooter(StringBuilder bill,double worthOfShopping){
        bill.append("\t").append(worthOfShopping).append(System.lineSeparator());
    }
}
