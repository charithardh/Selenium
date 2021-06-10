package testPackage1;

import org.testng.annotations.Test;

public class TestA2 {
  @Test
  public void testA2() throws Exception {
		System.out.println("Starging testA2");

		Thread.sleep(3000);

		System.out.println("Ending testA2");
  }
}
