
package projecteuler;

/**
 *
 * @author rewil
 */
public class Problem10 implements Problem{

    String prompt = "Problem 10: \n" + 
                    "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.\n" +
                    "Find the sum of all the primes below two million.";
    
    @Override
    public void solve() {
        int cap = 2000000;
        int sum = 0;
        
        for(int i = 3; i < cap; i += 2) if(isPrime(i)) sum += i;
        
        System.out.println(prompt + '\n');
        System.out.println("Sum: " + sum);
    }
    
    private boolean isPrime(long check) {
        if(check % 2 == 0) return false;
        long root = (long) Math.ceil(Math.sqrt(check));
        for(int i = 3; i <= root; i += 2) {
            if(check % i == 0) return false;
        }
        return true;
    }

}
