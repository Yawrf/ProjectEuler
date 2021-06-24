
package projecteuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rewil
 */
public class Problem22 implements Problem{
    
    String prompt = "Problem 22: \n" + 
                    "Using names.txt (provided on the website), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.\n" +
                    "For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.\n" +
                    "What is the total of all the name scores in the file?";

    @Override
    public void solve() {
        try {
            String file = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("names.txt"))).readLine();
            file = file.replace("\"", "");
            ArrayList<String> names = new ArrayList<>(Arrays.asList(file.split(",")));
            names.sort(null);
            
            long sum = 0;
            for(int i = 1; i <= names.size(); ++i) {
                String name = names.get(i - 1);
                int score = score(name);
                sum += score * i;
            }
            
            System.out.println(prompt + '\n');
            System.out.println("Sum: " + sum);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private int score(String name) {
        char[] chars = name.toCharArray();
        int sum = 0;
        int offset = 'A' - 1;
        
        for(char c : chars) sum += c - offset;
        
        return sum;
    }

}
