package pl.sebastianstrzalkowski.models;

public class Product {

    private Barcode barcode;
    private String name;
    private double price;

    public Product(){};

    public Product(Barcode barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }



}
