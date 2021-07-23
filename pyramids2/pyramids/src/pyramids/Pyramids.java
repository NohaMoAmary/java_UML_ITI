
package pyramids;

import controller.Pyramid;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import model.PyramidDAOImpl;
import model.pyramidcsvDAO;

public class Pyramids {

   
    public static void main(String[] args) throws IOException {
       
        // task 1 explore data 
        
        Scanner scanner = new Scanner(new File("pyramids.csv"));
        scanner.useDelimiter(",");
        while (scanner.hasNext()) 
        {
            System.out.print(scanner.next() + " ");
        }
        scanner.close();
        //another way 
        /*BufferedReader csvReader = new BufferedReader(new FileReader("pyramids.csv"));
        String row ;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            for(String token : data)
                {
                    System.out.println(token);
                }   
        }
        csvReader.close();*/
        
        //task 2 
        pyramidcsvDAO pDAO= new PyramidDAOImpl();
        List<Pyramid> Pyramids = pDAO.getAllPyramids("pyramids.csv");
        int i =0;
        for (Pyramid p :Pyramids)
        {
            System.out.println ("#"+(i++)+"  "+p);
        }
        
    System.out.println("_________________________________________________________");
    System.out.println("lecture 3");
    System.out.println("_________________________________________________________");
    Pyramids=pDAO.SortPyramids();
    System.out.println("sort the list of pyramids you have by pyramid’s height");
    for (Pyramid p :Pyramids)
        {
            System.out.println ("#"+(i++)+"  "+p);
        }
    System.out.println("map all site-location with the number of pyramids in this site");
    System.out.println (pDAO.countSitePyramid());
    }
    
}
