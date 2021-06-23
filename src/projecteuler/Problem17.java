
package projecteuler;

/**
 *
 * @author rewil
 */
public class Problem17 implements Problem{
    
    String prompt = "Problem 17: \n" + 
                    "If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.\n" +
                    "If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?\n" +
                    "NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of \"and\" when writing out numbers is in compliance with British usage.";

    @Override
    public void solve() {
        int min = 1;
        int max = 1000;
        long count = 0;
        
        for(int i = min; i <= max; ++i) {
            String text = convert(i);
//            System.out.println(text);
            count += text.replaceAll(" ", "").length();
        }
        
        System.out.println(prompt + '\n');
        System.out.println("Count: " + count);
        
    }
    
    private static final String[] numNames = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teenNames = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tenNames = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private String convert(int num) {
        char[] nums = ("" + num).toCharArray();
        String out = "";
        
        int index = 0;
        switch(nums.length) {
            case 4: out += Text.thousands.convert(Integer.parseInt("" + nums[index++])) + " ";
            case 3: {
                out += Text.hundreds.convert(Integer.parseInt("" + nums[index++])) + " ";
                if(nums[index] != '0' || nums[index + 1] != '0') out += "and ";
            }
            case 2: {
                if(nums[index] == '1') {
                    out += Text.teens.convert(Integer.parseInt("" + nums[++index]));
                    break;
                } out += Text.tens.convert(Integer.parseInt("" + nums[index++]));
            }
            case 1: out += Text.ones.convert(Integer.parseInt("" + nums[index]));
        }
        
        return out;
    }
    
    private enum Text{
        ones("$"),
        teens("%"),
        tens("^"),
        hundreds("$ Hundred"),
        thousands("$ Thousand");
        
        private final String formula;
        private Text(String formula) {
            this.formula = formula;
        }
        
        public String convert(int num) {
            if(formula.contains("$") && numNames[num].isEmpty()) return "";
            String out = formula.replace("$", numNames[num]);
            out = out.replace("%", teenNames[num]);
            out = out.replace("^", tenNames[num]);
            return out;
        }
        
    }

}
