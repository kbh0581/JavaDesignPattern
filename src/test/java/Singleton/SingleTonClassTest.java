package Singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleTonClassTest {

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
    public void mulThreadTest() throws InterruptedException{
        var sg1 = NoneThreadSingleTonClass.getSingleTonClass();


        Runnable task =  () -> {
            var sg2 = NoneThreadSingleTonClass.getSingleTonClass();

            for (int i = 0; i < 100; i++) {
                sg2.setSu(sg2.getSu()+1);
                System.out.println(":: =>" + Thread.currentThread()  + sg2.getSu());
            }
        };

        var th1 = new Thread(task);
        th1.setName("1번입니다.");
        var th2 = new Thread(task);
        th2.setName("2번입니다.");
        th1.start();
        th2.start();
        th1.join();
        th2.join();



        System.out.println(sg1.getSu());


    }




}