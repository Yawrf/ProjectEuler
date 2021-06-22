
package projecteuler;

import java.util.Arrays;

/**
 *
 * @author rewil
 */
public class Problem9 implements Problem{

    String prompt = "Problem 9: \n" +
                    "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,\n" +
                    "\ta^2 + b^2 = c^2\n" +
                    "For example, 32 + 42 = 9 + 16 = 25 = 52.\n" +
                    "There exists exactly one Pythagorean triplet for which a + b + c = 1000.\n" +
                    "Find the product abc.";
    
    @Override
    public void solve() {
        int sum = 1000;
        int[] answer = null;
        int product = 0;
        
        for(int i = 1; i <= sum; ++i) {
            for(int j = i + 1; j <= sum; ++j) {
                for(int k = j + 1; k <= sum; ++k) {
                    if(sum(i, j, k) != sum) continue;
                    if(!isPythagorean(i, j, k)) continue;
                    answer = new int[]{i, j, k};
                    product = i * j * k;
                }
                if(product != 0) break;
            }
            if(product != 0) break;
        }
        
        System.out.println(prompt + '\n');
        if(answer != null) System.out.println("Components: " + Arrays.toString(answer));
        System.out.println("Product: " + product);
        
    }
    
    private boolean isPythagorean(int a, int b, int c) {
        int left = (int) (Math.pow(a, 2) + Math.pow(b, 2));
        int right = (int) Math.pow(c, 2);
        return left == right;
    }
    
    private int sum(int a, int b, int c) {
        return a + b + c;
    }

}
