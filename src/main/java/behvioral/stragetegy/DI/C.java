package behvioral.stragetegy.DI;

public class C {

	C(){
		throw new RuntimeException("런타임 익셉션");
	}
	public void print(){
		System.out.println("C 의 프린트 수행");
	}
}
