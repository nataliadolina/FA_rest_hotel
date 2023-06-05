package com.example.hotelfrontend;

public class Client {
    public Integer id;
    public String name;
    public String surname;
    public String patronymic;

    @Override
    public String toString(){
        return String.format("%s %s. %s.", surname, String.valueOf(name.charAt(0)).toUpperCase(), String.valueOf(patronymic.charAt(0)).toUpperCase());
    }
}
