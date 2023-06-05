package com.example.hotelfrontend;

public class AdditionalServices {
    public Integer id;
    public String name;
    public Float price;

    @Override
    public String toString(){
        return String.format("%s, цена: %f",
                name, price);
    }

}
