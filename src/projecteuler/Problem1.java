
package projecteuler;

import java.util.ArrayList;

/**
 *
 * @author rewil
 */
public class Problem1 implements Problem{
    
    String prompt = "Problem 1: \n" + 
                    "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.\n" + 
                    "Find the sum of all the multiples of 3 or 5 below 1000.";
    
    @Override
    public void solve() {
        int mult1 = 3;
        int mult2 = 5;
        int cap = 1000;
        
        ArrayList<Integer> nums = new ArrayList<>();
        int i = 0;
        while(i < cap) {
            i += mult1;
            if(i < cap) nums.add(i);
        } i = 0;
        while(i < cap) {
            i += mult2;
            if(!nums.contains(i) && i < cap) nums.add(i);
        } 
//        nums.sort(null);
        
        int sum = 0;
        for(int j : nums) sum += j;
        
        System.out.println(prompt + '\n');
        System.out.println("Total: " + sum);
    }
    
}
