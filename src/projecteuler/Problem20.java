
package projecteuler;

import java.math.BigInteger;

/**
 *
 * @author rewil
 */
public class Problem20 implements Problem{
    
    String prompt = "Problem 20: \n" + 
                    "n! means n × (n − 1) × ... × 3 × 2 × 1\n" +
                    "For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,\n" +
                    "and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.\n" +
                    "Find the sum of the digits in the number 100!";

    @Override
    public void solve() {
        BigInteger fact = new BigInteger("100");
        for(int i = fact.intValue() - 1; i > 0; --i) {
            fact = fact.multiply(new BigInteger("" + i));
        }
        
        int sum = 0;
        for(char c : fact.toString().toCharArray()) {
            sum += Integer.parseInt("" + c);
        }
        
        System.out.println(prompt + '\n');
        System.out.println("Factorial: " + fact);
        System.out.println("Sum of Digits: " + sum);
    }

}
