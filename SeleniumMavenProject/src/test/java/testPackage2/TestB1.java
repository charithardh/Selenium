package testPackage2;

import org.testng.annotations.Test;

public class TestB1 {
  @Test
  public void testB1() throws Exception {
		System.out.println("Starging testB1");

		Thread.sleep(3000);

		System.out.println("Ending testB1");
  }
}
