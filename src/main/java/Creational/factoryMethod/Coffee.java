package Creational.factoryMethod;

public abstract class Coffee {
    public abstract String getName();
    public abstract int getPrice();

    public enum coffeType {
        아메리카노,아이스티,딸기스무디;
    }
    //팩토리 메소드
    public static Coffee coffeeFactory(coffeType type){
        Coffee cf = null;
        switch(type){
            case 아이스티:
                cf = new IceTea();
                break;
            case 딸기스무디:
                cf = new Smoth();
                break;
            case 아메리카노:
                cf = new Americano();
                break;
            default:
                break;
        }

        return cf;
    }


}