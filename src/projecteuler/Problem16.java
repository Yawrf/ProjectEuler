
package projecteuler;

import java.math.BigInteger;

/**
 *
 * @author rewil
 */
public class Problem16 implements Problem{

    String prompt = "Problem 16: \n" + 
                    "2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.\n" +
                    "What is the sum of the digits of the number 2^1000?";
    
    @Override
    public void solve() {
        BigInteger num = new BigInteger("2");
        num = num.pow(1000);
        char[] nums = num.toString().toCharArray();
        
        long sum = 0;
        for(char c : nums) sum += Integer.parseInt("" + c);
        
        System.out.println(prompt + '\n');
        System.out.println("Value: " + num);
        System.out.println("Sum: " + sum);
    }

}
