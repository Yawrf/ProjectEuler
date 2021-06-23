
package projecteuler;

import java.math.BigInteger;

/**
 *
 * @author rewil
 */
public class Problem15 implements Problem{
    
    String prompt = "Problem 15: \n" + 
                    "Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.\n" +
                    "\t<Image demonstrating on the site>\n" +
                    "How many such routes are there through a 20×20 grid?";

    @Override
    public void solve() {
        int gridSize = 20;
        
        int steps = gridSize * 2;
        
        // There will be twice as many steps are there are spaces to a side, the number of routes is determined by where you choose to move in one direction or the other
        // which can be phrased as "40 steps: 20x and 20y, which are the are x steps (the rest are y)" - or "40 choose 20", which mathematically reduces to 40!/(20!)^2 (40!/((20!)(40-20)!))
        
        BigInteger numerator = new BigInteger("1");
            for(int i = steps; i > 1; --i) numerator = numerator.multiply(new BigInteger("" + i));
        BigInteger denominator = new BigInteger("1");
            for(int i = gridSize; i > 1; --i) denominator = denominator.multiply(new BigInteger("" + i));
            denominator = denominator.pow(2);
            
        BigInteger routes = numerator.divide(denominator);
        
        System.out.println(prompt + '\n');
        System.out.println("Routes: " + routes);
    }

}
