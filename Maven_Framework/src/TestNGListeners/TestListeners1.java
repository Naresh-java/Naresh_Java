package TestNGListeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestListeners1 {
	@Test
	public void testMehtod11() {
		Assert.assertTrue(true);
	}
	@Test
	public void testMehtod12() {
		Assert.assertTrue(false);
	}

}
