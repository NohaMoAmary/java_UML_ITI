 
package model;

import controller.Pyramid;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noham
 */
public class PyramidDAOImpl implements pyramidcsvDAO  {

    List<Pyramid> Pyramids ;
    Map <String , Integer> CountSite = new LinkedHashMap<>();

    @Override
    public List<Pyramid> getAllPyramids(String fname) {
        Pyramids= new ArrayList <Pyramid>();
        BufferedReader csvReader;
        try {
            csvReader = new BufferedReader(new FileReader(fname));
        
            String row ,headerLine ;
            headerLine = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                createPyramidObject(data);
                
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PyramidDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PyramidDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Pyramids;
        
    }

    @Override
    public void createPyramidObject(String[] data) {
        if (data[7].isEmpty())
        {
            data[7]="0.0";
        }
        double temp =Double.parseDouble(data[7]);
        Pyramid p = new Pyramid(data[0], data[2],data[4],temp );
        Pyramids.add(p);
        
    }

    @Override
    public Map<String, Integer> countSitePyramid() {
        if (!Pyramids.isEmpty())
        {
         for (Pyramid p :Pyramids)
         {
             String site = p.getSite();
             Integer count = CountSite.get(site);
             if (count ==null)
             {
              count = 1;
             }else{
             count ++ ;
             }
             CountSite.put(site, count);
         }
        }
        return CountSite;
    }
    

    @Override
    public List<Pyramid> SortPyramids() {
       if (!Pyramids.isEmpty()) 
       {
           Pyramids.sort(Comparator.comparingDouble(Pyramid::getHeight));
       
       }
    return Pyramids ;
    }

    
}
