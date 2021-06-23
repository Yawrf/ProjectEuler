
package projecteuler;

import java.util.ArrayList;

/**
 *
 * @author rewil
 */
public class Problem19 implements Problem{
    
    String prompt = "Problem 19: \n" + 
                    "You are given the following information, but you may prefer to do some research for yourself.\n" +
                    "\t- 1 Jan 1900 was a Monday.\n" +
                    "\t- Thirty days has September,\n" +
                    "\t  April, June and November.\n" +
                    "\t  All the rest have thirty-one,\n" +
                    "\t  Saving February alone,\n" +
                    "\t  Which has twenty-eight, rain or shine.\n" +
                    "\t  And on leap years, twenty-nine.\n" +
                    "\t- A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.\n" +
                    "How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?";

    @Override
    public void solve() {
        int start = 1900;
        int min = 1901;
        int end = 2000;
        int sunday = 7; // Any day index evenly divisble by 7 (starting from 1900) will be a Sunday
        
        ArrayList<Integer> starts = new ArrayList<>();
        int totalDays = 0;
        
        for(int year = start; year <= end; ++year) {
            boolean leap = (year % 4 == 0);
            if(leap && (year % 100 == 0)) leap = (year % 400 == 0);
            
            for(Month m : Month.values()) {
                int days = getDays(m, leap);
                totalDays += days;
                if(year >= min) starts.add(totalDays + 1);
            }
        }
        
        int count = 0;
        for(int d : starts) {
            if(d % sunday == 0) ++count;
        }
        
        System.out.println(prompt + '\n');
        System.out.println("Count: " + count);
    }
    
    private int getDays(Month m, boolean leap) {
        switch(m) {
            case Jan: return 31;
            case Feb: return 28 + (leap ? 1 : 0);
            case Mar: return 31;
            case Apr: return 30;
            case May: return 31;
            case June: return 30;
            case July: return 31;
            case Aug: return 31;
            case Sept: return 30;
            case Oct: return 31;
            case Nov: return 30;
            case Dec: return 31;
        }
        return 0;
    }
    
    private enum Month {
        Jan,
        Feb,
        Mar,
        Apr,
        May,
        June,
        July,
        Aug,
        Sept,
        Oct,
        Nov,
        Dec;
    }

}
