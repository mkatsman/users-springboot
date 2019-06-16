package myspringboot.service;

public class Fibonacci {
	/**
	 * The Fibonacci numbers are the numbers in the following integer sequence.
	 * 
	 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, …
	 * 
	 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the
	 * recurrence relation
	 * 
	 * Fn = Fn-1 + Fn-2
	 * 
	 * with seed values
	 * 
	 * F0 = 0 and F1 = 1.
	 * 
	 * Given a number n, print n-th Fibonacci Number.
	 * Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	We can observe that this implementation does a lot of repeated work 
	(see the following recursion tree). 
	So this is a bad implementation for nth Fibonacci number.

                       fib(5)   
                     /                \
               fib(4)                fib(3)   
             /        \              /       \ 
         fib(3)      fib(2)         fib(2)   fib(1)
        /    \       /    \        /      \
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /     \
fib(1) fib(0)
	 * 
	 **/
	
	public static long fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	
	public static long optimizedFib(int n) {
		
	    { 
	    /* Declare an array to store Fibonacci numbers. */
	    long f[] = new long[n+2]; // 1 extra to handle case, n = 0 
	    int i; 
	       
	    /* 0th and 1st number of the series are 0 and 1*/
	    f[0] = 0; 
	    f[1] = 1; 
	      
	    for (i = 2; i <= n; i++) 
	    { 
	       /* Add the previous 2 numbers in the series 
	         and store it */
	        f[i] = f[i-1] + f[i-2]; 
	    } 
	       
	    return f[n]; 
	    } 
	       
	}
	public static void main(String args[]) {
		long  tm1 = System.currentTimeMillis();
		System.out.println("Recursive:");
		for (int n = 0; n <= 46; n++) {
			System.out.println("n: " + n + "  fib(n): " + fib(n));
		}
		long  tm2 = System.currentTimeMillis();
		System.out.println("Duration in ms:" + (tm2 -tm1));
		
		System.out.println("Optimized:");
		  tm1 = System.currentTimeMillis();
		for (int n = 0; n <= 46; n++) {
			System.out.println("n: " + n + "  fib(n): " + optimizedFib(n));
		}
		 tm2 = System.currentTimeMillis();
		System.out.println("Duration optimized  in ms:" + (tm2 -tm1));
	}
}
