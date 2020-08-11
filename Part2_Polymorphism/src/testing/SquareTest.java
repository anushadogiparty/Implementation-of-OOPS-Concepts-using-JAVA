package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {
	
	JunitTesting test = new JunitTesting();
	
	@Test
	void positiveTest() {
		int output = test.square(10);
		assertEquals(100,output);
	}
	
	@Test
	void negativeTest() {
		int output = test.square(10);
		assertEquals(10,output);
	}

}
