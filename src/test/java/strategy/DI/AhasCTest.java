package strategy.DI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AhasCTest {

	@Test
	public void A가_C를가지고있다(){
		C c = new C();
		AhasC a = new AhasC(c);

	}

}