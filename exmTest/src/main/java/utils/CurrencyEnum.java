package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public enum CurrencyEnum {


    HRYVNIA("UAH", "₴"),
    DOLLAR("USD", "$"),
    EURO("EUR", " €");


    private String title;
    private String sign;

    CurrencyEnum(String title, String sign) {
        this.title = title;
        this.sign = sign;
    }

    public String getTitle() {
        return title;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return "CURRENCY{" +
                "short form ='" + title + '\'' +
                '}';
    }

    public static List<CurrencyEnum> getEnumTitle() {
        return new ArrayList<CurrencyEnum>(Arrays.asList(values()));
    }

}
