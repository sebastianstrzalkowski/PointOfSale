package tests;

import org.junit.jupiter.api.Test;
import pl.sebastianstrzalkowski.System.SaleService;
import pl.sebastianstrzalkowski.devices.input.BarcodeScanner;
import pl.sebastianstrzalkowski.models.Barcode;
import pl.sebastianstrzalkowski.models.Product;
import pl.sebastianstrzalkowski.models.ProductsRepository;
import pl.sebastianstrzalkowski.models.ShoppingCart;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSaleService{

    @Test
    public void shouldScanExitAndPrintSummary() {

        List<Product> productTable = new ArrayList<Product>();
        Product sampleProduct = new Product(new Barcode("xx"), "Sample name", 5);
        productTable.add(sampleProduct);
        ProductsRepository productsRepository = new ProductsRepository(productTable);
        ByteArrayOutputStream systemOutStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutStream));
        ShoppingCart shoppingCart = new ShoppingCart();
        SaleService saleService = new SaleService(new BarcodeScanner(productsRepository),shoppingCart);
        shoppingCart.add(sampleProduct);

        saleService.scan("exit");
        String expectedPrinterString = "Name\t"  + "Price\t" + System.lineSeparator()
                + sampleProduct.getName() + "\t" + sampleProduct.getPrice() + System.lineSeparator()
                + "\t" + shoppingCart.getWorthOfShopping() + System.lineSeparator();
        String expectedLcdString = "Total price: " + shoppingCart.getWorthOfShopping();
        assertEquals(expectedPrinterString + expectedLcdString,systemOutStream);
    }

}