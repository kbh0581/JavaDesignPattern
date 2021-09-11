package creational.factoryMethod;

class IceTea extends Coffee{
    @Override
    public int getPrice() {
        return 10;
    }

    @Override
    public String getName() {
        return "아이스티";
    }
}
