
package projecteuler;

/**
 *
 * @author rewil
 */
public class Problem12 implements Problem{
    
    String prompt = "Problem 12: \n" + 
                    "The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:\n" +
                    "1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...\n" +
                    "Let us list the factors of the first seven triangle numbers:\n" +
                    " 1: 1\n" +
                    " 3: 1,3\n" +
                    " 6: 1,2,3,6\n" +
                    "10: 1,2,5,10\n" +
                    "15: 1,3,5,15\n" +
                    "21: 1,3,7,21\n" +
                    "28: 1,2,4,7,14,28\n" +
                    "We can see that 28 is the first triangle number to have over five divisors.\n" +
                    "What is the value of the first triangle number to have over five hundred divisors?";

    @Override
    public void solve() {
        int goal = 500;
        Triangle t = new Triangle();
        
        int most = 0;
        while(most < goal) {
            int temp = countFactors(t.next());
            if(temp > most) {
                most = temp;
//                System.out.println("(" + most + ") " + t.getCurrent());
            }
        }
        
        System.out.println(prompt + "\n");
        System.out.println("Triangle Index: " + t.getIndex());
        System.out.println("Triangle Number: " + t.getCurrent());
    }
    
    private int countFactors(long check) {
        int count = 0;
        int root = (int) Math.floor(Math.sqrt(check));
        for(int i = 1; i < root; ++i) {
            if(check % i == 0) count += 2;
        } if(root * root == check) ++count;
        return count; 
    }
    
    private class Triangle{
        private long current = 1;
        private int index = 1;
        
        public long next() {
            current += ++index;
            return current;
        }
        
        public long getCurrent() {
            return current;
        }
        public int getIndex() {
            return index;
        }
    }

}
