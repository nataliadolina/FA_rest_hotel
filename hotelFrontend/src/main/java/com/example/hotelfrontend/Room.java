package com.example.hotelfrontend;

public class Room{
    public Integer id;
    public String type_room;
    public Integer number;
    public Integer floor;
    public Float price;

    @Override
    public String toString(){
        return String.format("Тип: %s, номер: %d, этаж: %s, цена: %f",
                type_room, number, floor, price);
    }
}
