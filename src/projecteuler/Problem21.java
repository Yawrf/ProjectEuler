
package projecteuler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author rewil
 */
public class Problem21 implements Problem{
    
    String prompt = "Problem 21: \n" +
                    "Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).\n" +
                    "If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.\n" +
                    "For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.\n" +
                    "Evaluate the sum of all the amicable numbers under 10000.";

    @Override
    public void solve() {
        int cap = 10000;
        ArrayList<Integer> amicables = new ArrayList<>();
        for(int i = 1; i < cap; ++i) {
            int sum = sumFactors(i);
            sums.put(i, sum);
            if(sum != i) if(sums.containsKey(sum)) if(sums.get(sum) == i) {
                amicables.add(i);
                amicables.add(sum);
            }
        }
        
        int sum = 0;
        for(int i : amicables) sum += i;
        
        System.out.println(prompt + '\n');
        System.out.println("Amicables: " + amicables);
        System.out.println("Sum: " + sum);
    }
    
    private HashMap<Integer, Integer> sums = new HashMap<>();
    
    private int sumFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<>();
            factors.add(1);
        int root = (int) Math.sqrt(num);
        for(int i = 2; i < root; ++i) {
            if(num % i == 0) {
                factors.add(i);
                factors.add(num / i);
            }
        }
        if(root * root == num && !factors.contains(root)) factors.add(root);
        
        int sum = 0;
        for(int i : factors) sum += i;
        
        return sum;
    }

}
