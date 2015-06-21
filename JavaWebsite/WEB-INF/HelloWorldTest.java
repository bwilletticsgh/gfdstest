import java.util.Random;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;

public class HelloWorldTest extends TestCase
{
	public void testAdd()
	{
		HelloWorld hw = new HelloWorld();
		
		Random rand = new Random();
		int a = rand.nextInt(100) + 1;
		int b = rand.nextInt(100) + 1;
		
		int trueSum = a + b;
		int hwSum = hw.doAdd(a, b);
		
		assertEquals(trueSum, hwSum);
	}

	public void testSubtract()
	{
		HelloWorld hw = new HelloWorld();
		
		Random rand = new Random();
		int a = rand.nextInt(100) + 1;
		int b = rand.nextInt(100) + 1;
		
		int trueDiff = a - b;
		int hwDiff = hw.doSubtract(a, b);
		
		assertEquals(trueDiff, hwDiff);
	}

	public void testMultiply()
	{
		HelloWorld hw = new HelloWorld();
		
		Random rand = new Random();
		int a = rand.nextInt(100) + 1;
		int b = rand.nextInt(100) + 1;
		
		int trueProd = a * b;
		int hwProd = hw.doMultiply(a, b);
		
		assertEquals(trueProd, hwProd);
	}
	
	public void testDivide()
	{
		HelloWorld hw = new HelloWorld();
		
		Random rand = new Random();
		int a = rand.nextInt(100) + 1;
		int b = 0;
		
		while(b == 0)
		{
			b = rand.nextInt(100) + 1;
		}
		
		float trueQuot = (float)a / (float)b;
		float hwQuot = hw.doDivide(a, b);
		
		assertEquals(trueQuot, hwQuot);
	}
	
	public void testDivideByZero()
	{
		HelloWorld hw = new HelloWorld();
		
		Random rand = new Random();
		
		int a = rand.nextInt(100) + 1;
		
		Throwable e = null;
		try
		{
			float quot = hw.doDivide(a, 0);
		}
		catch (Throwable ex)
		{
			e = ex;
		}
		
		assertTrue(e instanceof IllegalArgumentException);
	}
	
	public void testSqrt()
	{
		HelloWorld hw = new HelloWorld();
		
		Random rand = new Random();
		int a = rand.nextInt(100);
		
		double trueSqrt = Math.sqrt((double)a);
		double hwSqrt = hw.doSqrt(a);
		
		assertEquals(trueSqrt, hwSqrt);
	}
		
	public void testNegativeSqrt()
	{
		HelloWorld hw = new HelloWorld();
		
		Random rand = new Random();
		int a = rand.nextInt(100) - 101;
		
		Throwable e = null;
		try
		{
			double ans = hw.doSqrt(a);
		}
		catch (Throwable ex)
		{
			e = ex;
		}
		
		assertTrue(e instanceof IllegalArgumentException);
	}	
}
	