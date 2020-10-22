//Scott Audet
//cubic root finding function class

package a10;

import java.text.DecimalFormat;

public class BisectMethods {

	//PRE: root exists in [lower .. upper]
	public static double rbisect (double [ ] coefficients, double lower, double upper) {
		
		DecimalFormat fmt = new DecimalFormat("#.0000000000000000");
		
		double funcMid = 0.0;
		double funcUpper = 0.0;
		double funcLower = 0.0;
		double mid = (upper + lower)/2;
		
		System.out.println(fmt.format(lower) + "\t" + fmt.format(mid) + "\t" + 
		fmt.format(upper));
		
		funcMid = BisectMethods.f(coefficients, mid);
		funcUpper = BisectMethods.f(coefficients, upper);
		funcLower = BisectMethods.f(coefficients, lower);
		
		if ((funcMid >= 0) && (funcMid < 0.000000000001)) return mid;
		else if (funcLower * funcMid < 0) return rbisect(coefficients, lower, mid);
		else if (funcUpper * funcMid < 0) return rbisect(coefficients, mid, upper);
		else return rbisect(coefficients, lower, upper);
	}
	// POST: return approximate root using recursive algorithm with precision 0.000000000001
	// POST: display value of function noted by coefficients at lower, middle, and upper 

	// PRE: root exists in [lower .. upper]
	public static double ibisect (double [ ] coefficients, double lower, double upper) {

		double funcMid = 0.0;
		double funcUpper = 0.0;
		double funcLower = 0.0;
		double mid = (upper + lower)/2;
		
		do {
			
			if (funcLower * funcMid < 0) {
				upper = mid;
				mid = (lower + upper)/2;
			}
			else if (funcUpper * funcMid < 0) {
				lower = mid;
				mid = (lower + upper)/2;
			}
			else {
				mid = (lower + upper)/2;
			}
			
			funcMid = BisectMethods.f(coefficients, mid);
			funcUpper = BisectMethods.f(coefficients, upper);
			funcLower = BisectMethods.f(coefficients, lower);
			
		} while (!((funcMid >= 0) && (funcMid < 0.000000000001)));
		
		return mid;
	}
	// POST: return approximate root using iterative algorithm with precision 0.000000000001

	public static double f (double [ ] coefficients, double x) {
		
		double a = coefficients[0];
		double b = coefficients[1];
		double c = coefficients[2];
		double d = coefficients[3];
		
		return a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
	}
	// POST: return value of function evaluated at x

}
