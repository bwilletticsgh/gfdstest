// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.util.Random;

// Extend HttpServlet class
public class HelloWorld extends HttpServlet {
 
  private String message;

  public void init() throws ServletException
  {
      // Do required initialization
      message = "<img src=\"./header.png\">";
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
	
	// This is a bug to test FindBugs
	PrintWriter writer = new PrintWriter("/tmp/the-file-name.txt", "UTF-8");
	// Don't close the file
	
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
	  
	  Date date = new Date();
	  out.println("<h1>Today's date: " + date.toString() + "</h1>");
	  
	  Random rand = new Random();
	  int a = rand.nextInt(100) + 1;
	  int b = rand.nextInt(100) + 1;
	  
	  out.println("<h1>" + a + " + " + b + " = " + this.doAdd(a, b) + "</h1>");	  
	  
	  a = rand.nextInt(100) + 1;
	  b = rand.nextInt(100) + 1;
	  
	  out.println("<h1>" + a + " - " + b + " = " + this.doSubtract(a, b) + "</h1>");
	  
	  a = rand.nextInt(100) + 1;
	  b = rand.nextInt(100) + 1;
	  
	  out.println("<h1>" + a + " * " + b + " = " + this.doMultiply(a, b) + "</h1>");
	  
	  a = rand.nextInt(100) + 1;
	  b = rand.nextInt(100) + 1;
	  
	  out.println("<h1>" + a + " */ " + b + " = " + this.doDivide(a, b) + "</h1>");
	  
	  a = rand.nextInt(100) + 1;
	  
	  out.println("<h1>Sqrt(" + a + ") = " + this.doSqrt(a) + "</h1>");
  }
  
  public int doAdd(int a, int b)
  {
	return a + b;
  }
  
  public int doSubtract(int a, int b)
  {
	return a - b;
  }

  public int doMultiply(int a, int b)
  {
	return a * b;
  }

  public float doDivide(int a, int b)
  {
	if(b == 0)
	{
		throw new IllegalArgumentException("Argument 'divisor' is 0");
	}
	
	return (float)a / (float)b;
  }
  
  public double doSqrt(int a)
  {
	if(a < 0)
	{
		throw new IllegalArgumentException("Argument is negative");
	}
	
	return Math.sqrt((double)a);
  }
  
  public void destroy()
  {
      // do nothing.
  }
}