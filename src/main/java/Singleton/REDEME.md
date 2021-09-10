# 싱글톤 패턴 
> 인스턴스가 오직 1개만 생성되야 하는 경우에 사용되는 패턴입니다.

* 일반적인 패턴   
  1. 기본생성자를 private로 선언하여 외부에서의 객체생성을 막는다.
  2. static 메소드 특정 메소드(객체생성메소드)를 통해서만 인스턴스를 전달한다.
  3. 특정 메소드에서 현재 인스턴스가 null(초기화) 되지 않았으면 생성하고 해당인스턴스를 반환 



* ### 일반적이지만 쓰레드에 안전하지 않은 생성 방식 
  ```java
    public class NoneThreadSingleTonClass {
  
    //외부에 접근할 수 있는 클래스
    private static NoneThreadSingleTonClass noneThreadSingleTonClass = null;
    //멤버변수
    private int su = 0;
  
    
    //객체를 하나만 생성할 수 있도록 기본 생성자 와부생성을 막음
    private NoneThreadSingleTonClass(){}
  
    //해당 단 하나만의 객체를 가져올 수 있도록 getSingleTonClass 메소드를 통해 가져온다.
    public static NoneThreadSingleTonClass getSingleTonClass() {
      //생성 초기화 시점에 여러쓰레드에서 접근시 2개이상의 인스턴스를 생성이 될수도 있다.
      if (noneThreadSingleTonClass == null) {
        noneThreadSingleTonClass = new NoneThreadSingleTonClass();
      }
  
      return noneThreadSingleTonClass;
    }
  }
  
  ``` 

* ### 많이 활용되는 LazyHolder를 이용한 쓰레드에 안전한 생성 방식
  1. 기존 여러방식과 다르게 내부 클래스를 이용하여 객체 초기화와 동시에 객체생성을 내부 클래스에 위임하고 
  2. 실제 싱글턴 인스턴스를 가져오는 메소드를 내부 클래스에 의해 반환해준다.
  
  ```java
  public class ThreadSafeSingleTonClass {
  
      //객체를 외부에서 생산할수 없도록 기본 생성자 막음
      private ThreadSafeSingleTonClass(){}
      
      //실제로 사용할때까지 inner Class를 이용하여 막는다;
      private static class LazyLoad{
          private final static ThreadSafeSingleTonClass clazz = new ThreadSafeSingleTonClass();
  
      }
      //해당 단 하나만의 객체를 가져올 수 있도록 getSingleTonClass 메소드를 통해 가져온다.
      public static ThreadSafeSingleTonClass getSingleTonClass() {
          return LazyLoad.clazz;
      }
  
  
  }
  ```

