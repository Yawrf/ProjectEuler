
package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;

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
        
        Sieve s = new Sieve(cap);
        long sum = 0;
        for(int i : s.getPrimes()) {
//            System.out.println("Prime: " + i);
            sum += i;
        }
        
        System.out.println(prompt + '\n');
        System.out.println("Sum: " + sum);
    }
    
    private class Sieve{ // of Eratosthenes
        
        private int size = 0;
        private boolean[] sieve = null;
        private ArrayList<Integer> list = new ArrayList<>();
        
        public Sieve(int size) {
            this.size = size;
            sieve = new boolean[size];
            Arrays.fill(sieve, true);
            
            if(size >= 0) sieve[0] = false;
            if(size > 0)  sieve[1] = false;
            calculate();
        }
        
        private void calculate() {
            for(int i = 2; i * i < size; ++i) {
                if(!sieve[i]) continue;
                for(int j = i * i; j < size; j += i) {
                    sieve[j] = false;
                }
            }
            for(int i = 0; i < size; ++i) {
                if(sieve[i]) list.add(i);
            }
        }
        
        public ArrayList<Integer> getPrimes() {
            return (ArrayList<Integer>) list.clone();
        }
        
    }

}
