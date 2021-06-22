
package projecteuler;

/**
 *
 * @author rewil
 */
public class Problem4 implements Problem{

    String prompt = "Problem 4: \n" + 
                    "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.\n" +
                    "Find the largest palindrome made from the product of two 3-digit numbers.";
    
    @Override
    public void solve() {
        
        int factorMin = 100;
        int factorMax = 999;
        
        long largest = 0;
        for(int i = factorMin; i <= factorMax; ++i) {
            for(int j = factorMin; j < factorMax; ++j) {
                long product = i * j;
                if(product > largest && isPalindrome(product)) largest = product;
            }
        }
        
        System.out.println(prompt + "\n");
        System.out.println("Largest: " + largest);
        
    }
    
    private boolean isPalindrome(long num) {
        boolean out = true;
        
        char[] nums = ("" + num).toCharArray();
        
        for(int i = 0; i < nums.length / 2; ++i) {
            out = out && nums[i] == nums[nums.length - 1 - i];
        }
        
        return out;
    }
    
}
