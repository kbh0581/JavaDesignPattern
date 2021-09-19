# 팩토리 메소드 패턴
> 팩토리 메소드 패턴은 어떠한 분기에 따라 객체 생성을 하는 역할을 직접하지 않고  
> 팩토리 메소드에 위임하여 객체를 생성하는 패턴 입니다.  
>
> 예시) _특정 분기에 객체를 직접생성한다면 여러구간의 코드의 중복성이 나타날 것.. 이를 방지_

1. 팩토리의 역할을 하는 추상클래스를 생성한다.
2. 추상클래스내의 특정 분기를 통해 생성하는 팩토리 메소드를 생성하고
3. 추상화 할 수 있는 메소드를 정의 
4. 특정 객체는 추상 클래스를 상속하여 추상화된 메소드를 작성한다.


* 커피의 예시

* 커피 클래스(팩토리 메소드를 포함한) 
    ```java
    public abstract class Coffee {
        public abstract String getName();
        public abstract int getPrice();
    
        public enum coffeType {
            아메리카노,아이스티,딸기스무디;
        }
    
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
    ```
  
* 아이스티 클래스 
    ```java
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
    ```
  
* 사용 메인
  ```java
      public static void main(String[]args){
          Coffee coffe = Coffee.coffeeFactory(coffee);
          System.out.println(coffe.getName() + "생성");
      }
      
  ```

