package pl.sebastianstrzalkowski.devices.input;

import pl.sebastianstrzalkowski.System.Validator;
import pl.sebastianstrzalkowski.devices.output.LCD;
import pl.sebastianstrzalkowski.devices.output.Printer;
import pl.sebastianstrzalkowski.exception.InvalidBarcodeException;
import pl.sebastianstrzalkowski.models.Barcode;
import pl.sebastianstrzalkowski.models.Product;
import pl.sebastianstrzalkowski.models.ProductsRepository;

public class BarcodeScanner {


    public BarcodeScanner(){};

    private ProductsRepository productsRepository;
    public BarcodeScanner(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public Product scan(Barcode barcode){
        String code = barcode.getCode();
        if (!Validator.checkNotEmpty(code)) {
            throw new InvalidBarcodeException("Invalid barcode");
        }
        return productsRepository.findByBarcode(barcode);
    }

}
