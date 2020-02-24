package TestNGListeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNGListeners.TestNgListeners.class)
public class TestListeners {
	@Test
	public void testMehtod1() {
		Assert.assertTrue(true);
	}
	@Test
	public void testMehtod2() {
		Assert.assertTrue(false);
	}
}
