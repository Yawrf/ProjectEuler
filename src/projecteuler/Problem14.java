
package projecteuler;

/**
 *
 * @author rewil
 */
public class Problem14 implements Problem{
    
    String prompt = "Problem 14: \n" + 
                    "The following iterative sequence is defined for the set of positive integers:\n" +
                    "\tn → n/2 (n is even)\n" +
                    "\tn → 3n + 1 (n is odd)\n" +
                    "Using the rule above and starting with 13, we generate the following sequence:\n" +
                    "\t13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1\n" +
                    "It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.\n" +
                    "Which starting number, under one million, produces the longest chain?\n" +
                    "NOTE: Once the chain starts the terms are allowed to go above one million.";

    @Override
    public void solve() {
        int cap = 1000000;
        int longest = 0;
        int steps = 0;
        
        for(int i = 1; i < cap; ++i) {
            int temp = collatzSteps(i);
            if(temp > steps) {
                steps = temp;
                longest = i;
//                System.out.println("(" + steps + ") " + i);
            }
        }
        
        System.out.println(prompt + "\n");
        System.out.println("Steps Taken: " + steps);
        System.out.println("Starting Number: " + longest);
    }
    
    private int collatzSteps(long check) {
        int steps = 0;
        while(check > 1) {
            switch((int)(check % 2)) {
                case 1: check = 3 * check + 1;
                    break;
                case 0: check = check / 2;
                    break;
            }
            steps++;
        }
        return steps;
    }

}
