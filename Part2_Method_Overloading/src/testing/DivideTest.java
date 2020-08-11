package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DivideTest {
	
	
	JunitTesting test = new JunitTesting();
	
	@Test
	void positiveTest() {
		double output = test.divide(10, 2);
		assertEquals(5,output);
	}

	@Test
	void negativeTest() {
		double output = test.divide(10, 2);
		assertEquals(3,output);
	}
}