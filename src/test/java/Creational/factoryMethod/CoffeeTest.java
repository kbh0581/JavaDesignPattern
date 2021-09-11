package Creational.factoryMethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTest {

    @Test
    @DisplayName("각 커피를 생성하고 객체를 확인해본다.")
    public void createCoffee(){
        Coffee coffee = Coffee.coffeeFactory(Coffee.coffeType.아메리카노);
        assertEquals("아메리카노",coffee.getName());
        coffee = Coffee.coffeeFactory(Coffee.coffeType.딸기스무디);
        assertEquals("딸기스무디",coffee.getName());
        coffee = Coffee.coffeeFactory(Coffee.coffeType.아이스티);
        assertEquals("아이스티",coffee.getName());
    }

    @Test
    @DisplayName("활용예시 :: 각 주문에 따라 커피을 생성하여 전달해보자")
    public void orderMakeCoffee(){
        Coffee.coffeType coffee = order(Coffee.coffeType.딸기스무디);
        String name = "";
        if(coffee == Coffee.coffeType.딸기스무디){
            System.out.println("딸기 스무디 생성");
            name = "딸기스무디";
        } else if (coffee == Coffee.coffeType.아메리카노){
            System.out.println("아메리카노 생성");
            name = "아메리카노";
        } else if (coffee == Coffee.coffeType.아이스티){
            System.out.println("아이스티 생성");
            name = "아이스티";
        }

        System.out.println(name + "생성했다");

        // 팩토리 메소드 패턴을 활용한 예시
        Coffee coffe = Coffee.coffeeFactory(coffee);
        System.out.println(coffe.getName() + "생성");
        System.out.println(coffe.getName() + "생성했다");

    }

    private Coffee.coffeType order(Coffee.coffeType 주문){
        System.out.println("주문이 생성된다");
        return 주문;
    }


}