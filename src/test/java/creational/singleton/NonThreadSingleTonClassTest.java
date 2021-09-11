package creational.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NonThreadSingleTonClassTest {

    @Test
    @DisplayName("단일 쓰레드 환경에서 싱글톤메소드가_같은지_확인한다")
    void nonThreadSingleToneClass(){
        var sg = NoneThreadSingleTonClass.getSingleTonClass();
        var sg2 = NoneThreadSingleTonClass.getSingleTonClass();

        System.out.println(sg);
        sg.setSu(3);

        System.out.println(sg2);

        if(sg == sg2){
            System.out.println("주소 값이 같다");
        }

        //객체 값 확인
        System.out.printf(" sg 의 값  : %s \n ",sg.toString());
        System.out.printf("sg2 의 값 : %s \n ",sg2.toString());
        //객체가 동일한지 확인
        assertEquals(sg,sg2);
        //멤버 변수가 동일한지 확인
        assertEquals(sg.getSu(),sg2.getSu());
    }



    @Test
    @DisplayName("멀티 쓰레드 환경에서 싱글톤메소드가 같은지 확인한다")
    @RepeatedTest(10)
    public void mulThreadTest() throws InterruptedException{
        class TestNone extends Thread implements Runnable{
            public NoneThreadSingleTonClass clazz = null;
            @Override
            public void run() {
                clazz = NoneThreadSingleTonClass.getSingleTonClass();
            }
        };
        List<TestNone> th = new ArrayList();

        for (int i = 0; i < 1000; i++) {
            th.add(new TestNone());
        }
        for (TestNone item : th) {
            item.start();
        }

        Set<String> chekcker = new HashSet<>();
        for (TestNone item : th) {
            item.join();
            chekcker.add(item.clazz.toString());
        }
        System.out.println("SIZE : " + chekcker.size());
        //쓰레드 세이프 하지 않는다;
        assertEquals(chekcker.size(),1);
    }


}