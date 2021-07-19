
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

    
}
