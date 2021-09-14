package strategy.DI;

public class AhasC {
	C c;
	AhasC(C c){
		this.c = c;
	}
	AhasC(){
		c = new C();
	}

	public void print(){
		System.out.println("A has C");
	}
}
