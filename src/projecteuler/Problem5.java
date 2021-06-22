
package projecteuler;

/**
 *
 * @author rewil
 */
public class Problem5 implements Problem {

    String prompt = "Problem 5: \n" + 
                    "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.\n" +
                    "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?";
    
    @Override
    public void solve() {
        long num = 20;
        while(!isDivisble(num)) num++;
        
        System.out.println(prompt + '\n');
        System.out.println("Smallest Number: " + num);
    }
    
    private boolean isDivisble(long check) {
        for(int i = 2; i <= 20; ++i) {
            if(check % i != 0) return false;
        }
        return true;
    }

}
