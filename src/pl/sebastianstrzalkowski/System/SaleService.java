package pl.sebastianstrzalkowski.System;

import pl.sebastianstrzalkowski.devices.input.BarcodeScanner;
import pl.sebastianstrzalkowski.devices.output.LCD;
import pl.sebastianstrzalkowski.devices.output.Printer;
import pl.sebastianstrzalkowski.exception.InvalidBarcodeException;
import pl.sebastianstrzalkowski.exception.ProductNotFoundException;
import pl.sebastianstrzalkowski.models.Barcode;
import pl.sebastianstrzalkowski.models.Product;
import pl.sebastianstrzalkowski.models.ShoppingCart;

import java.util.List;

import static pl.sebastianstrzalkowski.System.Validator.checkNotNull;

public class SaleService {
    BarcodeScanner barcodeScanner;
    ShoppingCart shoppingCart;
    LCD lcd = new LCD();

    public SaleService(BarcodeScanner barcodeScanner, ShoppingCart shoppingCart){
        this.barcodeScanner = barcodeScanner;
        this.shoppingCart = shoppingCart;
    }

    public void scan(String input){
        checkNotNull(input);

        if(isExit(input)){
            printSummary();

        }

        scanSingleProductWithHoldException(input);
    }

    private void scanSingleProductWithHoldException(String input) {
        try {
            scanSingleProduct(new Barcode(input));
        } catch (ProductNotFoundException e) {
            lcd.printNotFound();
        } catch (InvalidBarcodeException e) {
            lcd.printInvalidBarcode();
        }
    }

    private void scanSingleProduct(Barcode barcode) {
        Product product = barcodeScanner.scan(barcode);
        shoppingCart.add(product);
        lcd.printProduct(product);
    }

    private boolean isExit(String input) {
        return input.equals("exit");
    }

    private void printSummary(){
        Printer print = new Printer();
        print.printBill(shoppingCart);

        LCD lcd = new LCD();
        lcd.printSummary(shoppingCart);
    }
}
