
package projecteuler;

/**
 *
 * @author rewil
 */
public class Problem7 implements Problem{

    String prompt = "Problem 7: \n" + 
                    "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.\n" +
                    "What is the 10 001st prime number?";
    
    @Override
    public void solve() {
        int found = 1; 
        int goal = 10001;
        long check;
        for(check = 3l; found < goal; check += 2) {
            if(isPrime(check)) found++;
        } check -= 2;
        
        System.out.println(prompt + '\n');
        System.out.println("10,001st Prime: " + check);
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
