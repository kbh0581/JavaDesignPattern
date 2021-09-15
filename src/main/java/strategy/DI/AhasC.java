package strategy.DI;

public class AhasC {
	C c;
	AhasC(){
		c = new C();
	}

	AhasC(C c){
		this.c = c;
	}


	public void print(){
		c.print();
		System.out.println("A has C");
	}
}
