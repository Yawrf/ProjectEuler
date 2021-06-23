/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

/**
 *
 * @author rewil
 */
public class ProjectEuler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("This project contains my progress in solving the problems at https://projecteuler.net \n");
        
                Problem p = new Problem15();
                p.solve();

//        try {
//            runThroughX(9);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } 
    }
    
    public static void runThroughX(int x) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String divider = "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
        for(int i = 1; i <= x; ++i) {
            Problem p = (Problem) Class.forName("projecteuler.Problem" + i).newInstance();
            p.solve();
            if(i != x) System.out.println('\n' + divider + '\n');
        }
    }
    
}
