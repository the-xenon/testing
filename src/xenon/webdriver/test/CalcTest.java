package xenon.webdriver.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest {
	
	@Test
	public void testAdd() {
		Calc calc = new Calc();
		
		Assert.assertEquals(5, calc.add(2, 3));
	}
}
