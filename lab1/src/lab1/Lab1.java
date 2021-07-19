
package lab1;

import java.io.*; 

/**
 *
 * @author noham
 */
public class Lab1 {

    public static void main(String[] args) throws IOException {
       
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data ;
        while (true)
        {
         System.out.print ("Enter Data :  ") ;
         data = reader.readLine();
         if (data.equals("stop"))
         {
            System.out.println ("Bye !");
            break;
         }
         else 
         {
         System.out.println("data is " + data);
         }
        
        }
         
    }
    
}
