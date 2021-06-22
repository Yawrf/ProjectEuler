
package projecteuler;

import java.util.ArrayList;

/**
 *
 * @author rewil
 */
public class Problem3 implements Problem{

    String prompt = "Problem 3: \n" + 
                    "The prime factors of 13195 are 5, 7, 13 and 29.\n" +
                    "What is the largest prime factor of the number 600851475143?";
    
    @Override
    public void solve() {
        long check = 600851475143l;
        int root = (int) Math.ceil(Math.sqrt(check));
        ArrayList<Integer> factors = new ArrayList<>();
        
        while(check % 2 == 0) {
            check /= 2;
            if(!factors.contains(2)) factors.add(2);
        }
        int i = 3;
        while(i <= root && i <= check) {
            while(check % i == 0) {
                check /= i;
                if(!factors.contains(i)) factors.add(i);
            }
            i += 2;
        }
        
        factors.sort(null);
        int largest = factors.get(factors.size() - 1);
        
        System.out.println(prompt + '\n');
        System.out.println("All Factors: " + factors);
        System.out.println("Largest Factor: " + largest);
    }

}
