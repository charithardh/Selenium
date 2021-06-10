package testPackage1;

import org.testng.annotations.Test;

public class TestMethodParallel {
  @Test
  public void m1() {
	  System.out.println(Thread.currentThread().getId());
  }
  @Test
  public void m2() {
	  System.out.println(Thread.currentThread().getId());
  }
  @Test
  public void m3() {
	  System.out.println(Thread.currentThread().getId());
  }
}
