
package projecteuler;

/**
 *
 * @author rewil
 */
public class Problem6 implements Problem{

    String prompt = "Problem 6: \n" + 
                    "The sum of the squares of the first ten natural numbers is,\n" +
                    "\t1^2 + 2^2 + ... + 10^2 = 385\n" + 
                    "The square of the sum of the first ten natural numbers is,\n" +
                    "\t(1 + 2 + ... + 10)^2 = 55^2 = 3025\n" + 
                    "Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.\n" +
                    "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.";
    
    @Override
    public void solve() {
        
        long squareSum = 0;
        long sumSquare = 0;
        
        for(int i = 1; i <= 100; ++i) {
            squareSum += Math.pow(i, 2);
            sumSquare += i;
        } sumSquare = (long) Math.pow(sumSquare, 2);
        
        long diff = sumSquare - squareSum;
        
        System.out.println(prompt + '\n');
        System.out.println("Sum of Squares: " + squareSum);
        System.out.println("Square of Sums: " + sumSquare);
        System.out.println("Difference: " + diff);
    }

}
