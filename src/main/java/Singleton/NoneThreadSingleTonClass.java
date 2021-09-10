package Singleton;


/**
 *
 *  <b>싱글톤 케이스 쓰레드 세이프하지 않는다.</b>
 */
public class NoneThreadSingleTonClass {

    //외부에 접근할 수 있는 클래스
    private static NoneThreadSingleTonClass noneThreadSingleTonClass = null;
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


    //객체를 하나만 생성할 수 있도록 기본 생성자 와부생성을 막음
    private NoneThreadSingleTonClass(){}

    //해당 단 하나만의 객체를 가져올 수 있도록 getSingleTonClass 메소드를 통해 가져온다.
    public static NoneThreadSingleTonClass getSingleTonClass() {
        if (noneThreadSingleTonClass == null) {
            noneThreadSingleTonClass = new NoneThreadSingleTonClass();
        }

        return noneThreadSingleTonClass;
    }
}
