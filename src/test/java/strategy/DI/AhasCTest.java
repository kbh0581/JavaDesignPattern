package strategy.DI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AhasCTest {

	@Test
	public void 외부의_DI(){
		C c = new C();
		AhasC a = new AhasC();
		a.print();

	}

	@Test
	public void 강한의존성테스트(){
		AhasC b = new AhasC();
	}

}