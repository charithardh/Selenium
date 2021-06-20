package testPackage1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is before method:"+Thread.currentThread().getId());
  }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method:"+Thread.currentThread().getId());
  }
}
