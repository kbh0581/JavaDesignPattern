package Creational.factoryMethod;

public class Americano extends Coffee {
    @Override
    public String getName() {
        return "아메리카노";
    }

    @Override
    public int getPrice() {
        return 100;
    }
}
