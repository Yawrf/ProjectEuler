
package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rewil
 */
public class Problem18 implements Problem{
    
    String prompt = "Problem 18: \n" + 
                    "By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.\n" +
                    "\t   3\n" +
                    "\t  7 4\n" +
                    "\t 2 4 6\n" +
                    "\t8 5 9 3\n" +
                    "That is, 3 + 7 + 4 + 9 = 23.\n" +
                    "Find the maximum total from top to bottom of the triangle below:\n" +
                    "\t              75\n" +
                    "\t             95 64\n" +
                    "\t            17 47 82\n" +
                    "\t           18 35 87 10\n" +
                    "\t          20 04 82 47 65\n" +
                    "\t         19 01 23 75 03 34\n" +
                    "\t        88 02 77 73 07 63 67\n" +
                    "\t       99 65 04 28 06 16 70 92\n" +
                    "\t      41 41 26 56 83 40 80 70 33\n" +
                    "\t     41 48 72 33 47 32 37 16 94 29\n" +
                    "\t    53 71 44 65 25 43 91 52 97 51 14\n" +
                    "\t   70 11 33 28 77 73 17 78 39 68 17 57\n" +
                    "\t  91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                    "\t 63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                    "\t04 62 98 27 23 09 70 98 73 93 38 53 60 04 23\n" +
                    "NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method!";

    @Override
    public void solve() {
        int[][] pyramid = getPyramid();
        
        for(int i = pyramid.length - 2; i >= 0; --i) {
            pyramid[i] = maximize(pyramid[i], pyramid[i+1]);
        }
        
        System.out.println(prompt + '\n');
        System.out.println("Max: " + pyramid[0][0]);
        
    }
    
    private int[] maximize(int[] row, int[] below) {
        for(int i = 0; i < row.length; ++i) {
            if(row[i] == 0) break;
            row[i] += Math.max(below[i], below[i+1]);
        }
        return row;
    }
    
    private int[][] getPyramid() {
        String data =   "75\n" +
                        "95 64\n" +
                        "17 47 82\n" +
                        "18 35 87 10\n" +
                        "20 04 82 47 65\n" +
                        "19 01 23 75 03 34\n" +
                        "88 02 77 73 07 63 67\n" +
                        "99 65 04 28 06 16 70 92\n" +
                        "41 41 26 56 83 40 80 70 33\n" +
                        "41 48 72 33 47 32 37 16 94 29\n" +
                        "53 71 44 65 25 43 91 52 97 51 14\n" +
                        "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                        "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                        "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                        "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
        
        String[] lines = data.split("\n");
        ArrayList<String[]> rows = new ArrayList<>();
        for(String s : lines) {
            rows.add(s.split(" "));
        }
        int[][] pyramid = new int[rows.size()][rows.get(rows.size() - 1).length];
        for(int[] row : pyramid) Arrays.fill(row, 0);
        
        for(int i = 0; i < rows.size(); ++i) {
            String[] row = rows.get(i);
            for(int j = 0; j < row.length; ++j) {
                pyramid[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        return pyramid;
    }
    
}
