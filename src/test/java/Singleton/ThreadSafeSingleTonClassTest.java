package Singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeSingleTonClassTest {

	@Test
	@DisplayName("객체가 같은지 확인한다.")
	public void sameObject(){
		ThreadSafeSingleTonClass c1 =  ThreadSafeSingleTonClass.getSingleTonClass();
		ThreadSafeSingleTonClass c2 =  ThreadSafeSingleTonClass.getSingleTonClass();
		System.out.println(c1);
		System.out.println(c2);
		c1.setSu(3);

		//객체가 동일한지 확인
		assertEquals(c1,c2);
		//멤버 변수가 동일한지 확인
		assertEquals(c1.getSu(),c2.getSu());
	}


	@Test
	@DisplayName("멀티 쓰레드 환경에서 싱글톤메소드가 같은지 확인한다")
	@RepeatedTest(10)
	public void mulThreadTest() throws InterruptedException{
		class TestNone extends Thread implements Runnable{
			public ThreadSafeSingleTonClass clazz = null;
			@Override
			public void run() {
				clazz = ThreadSafeSingleTonClass.getSingleTonClass();
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