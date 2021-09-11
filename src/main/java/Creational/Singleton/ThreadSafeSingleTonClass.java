package Creational.Singleton;



/**
 *
 *  <b>LazyHolder기법을 이용한 싱글톤 케이스</b>
 */
public class ThreadSafeSingleTonClass {

    //객체를 외부에서 생산할수 없도록 기본 생성자 막음
    private ThreadSafeSingleTonClass(){}
    //멤버변수
    private int su = 0;

    public int getSu() {
        return su;
    }

    public void setSu(int su) {
        this.su = su;
    }

    public void count(){
        this.su += 1;
    }

    //실제로 사용할때까지 inner Class를 이용하여 막는다;
    private static class LazyLoad{
        private final static ThreadSafeSingleTonClass clazz = new ThreadSafeSingleTonClass();

    }
    //해당 단 하나만의 객체를 가져올 수 있도록 getSingleTonClass 메소드를 통해 가져온다.
    public static ThreadSafeSingleTonClass getSingleTonClass() {
        return LazyLoad.clazz;
    }


}
