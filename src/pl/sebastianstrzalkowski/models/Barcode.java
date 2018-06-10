package pl.sebastianstrzalkowski.models;

import pl.sebastianstrzalkowski.System.Validator;

public class Barcode {
    private String code;

    public Barcode(String code){
        Validator.checkNotNull(code);
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
