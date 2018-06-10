package tests;

import pl.sebastianstrzalkowski.devices.input.BarcodeScanner;
import pl.sebastianstrzalkowski.exception.InvalidBarcodeException;
import pl.sebastianstrzalkowski.models.Barcode;


public class TestBarcodeScanner {



    @org.testng.annotations.Test(expectedExceptions = InvalidBarcodeException.class)
    public void invalidScan(){
        BarcodeScanner barcodeScanner = new BarcodeScanner();
        barcodeScanner.scan(new Barcode(""));
    }
}
