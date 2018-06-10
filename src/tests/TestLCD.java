package tests;


import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pl.sebastianstrzalkowski.devices.output.LCD;
import pl.sebastianstrzalkowski.exception.ProductNotFoundException;
import pl.sebastianstrzalkowski.models.Barcode;
import pl.sebastianstrzalkowski.models.Product;
import pl.sebastianstrzalkowski.models.ProductsRepository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLCD {


    private PrintStream originalSystemOut;
    private ByteArrayOutputStream systemOutStream;


    @Test
    public void shouldFindByBarcode() {
        originalSystemOut = System.out;
        systemOutStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutStream));

        LCD lcdDisplay = new LCD();

        lcdDisplay.printInvalidBarcode();

        String expected = "Invalid bar-code";
        assertEquals(systemOutStream.toString(), expected);
    }
    @Test
    public void productNotFound(){
        originalSystemOut = System.out;
        systemOutStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutStream));

        LCD lcdDisplay = new LCD();

        lcdDisplay.printNotFound();

        String expected = "Product not found";
        assertEquals(systemOutStream.toString(), expected);
    }



}