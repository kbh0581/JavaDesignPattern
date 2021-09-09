package Singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleTonClassTest {

    @Test
    void 싱글톤메소드가_같은지_확인한다(){
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



}