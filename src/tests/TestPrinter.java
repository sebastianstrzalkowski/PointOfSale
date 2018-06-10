package tests;

import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pl.sebastianstrzalkowski.devices.output.LCD;
import pl.sebastianstrzalkowski.devices.output.Printer;
import pl.sebastianstrzalkowski.exception.ProductNotFoundException;
import pl.sebastianstrzalkowski.models.Barcode;
import pl.sebastianstrzalkowski.models.Product;
import pl.sebastianstrzalkowski.models.ProductsRepository;
import pl.sebastianstrzalkowski.models.ShoppingCart;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPrinter {
    private ShoppingCart shoppingCart;
    private ByteArrayOutputStream systemOutStream;
    private PrintStream originalSystemOut;


    @Test
    public void shouldPrintSummary(){
        originalSystemOut = System.out;
        systemOutStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutStream));

        Printer printer = new Printer();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Product(new Barcode("232"), "Name1", 5));
        shoppingCart.add(new Product(new Barcode("123"), "Name2", 7));

        printer.printBill(shoppingCart);

        String expectedString = getExpectedString();
        assertEquals(expectedString, systemOutStream.toString());
    }

    private String getExpectedString() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Product(new Barcode("232"), "Name1", 5));
        shoppingCart.add(new Product(new Barcode("123"), "Name2", 7));

        StringBuilder bill = new StringBuilder();
        return bill.append("Name\t").append("Price\t").append(System.lineSeparator()).
                append(shoppingCart.getListOfProducts().get(0).getName()).append("\t").append(shoppingCart.getListOfProducts().get(0).getPrice()).append(System.lineSeparator()).
                append(shoppingCart.getListOfProducts().get(1).getName()).append("\t").append(shoppingCart.getListOfProducts().get(1).getPrice()).append(System.lineSeparator()).
                append("\t").append(shoppingCart.getWorthOfShopping()).
                toString();

    }
}
