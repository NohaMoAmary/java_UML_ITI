package model;
import controller.Pyramid ;
import java.util.*;

/**
 *
 * @author noham
 *
 */
public interface pyramidcsvDAO  {
    //read
    public List<Pyramid>getAllPyramids (String fname);
    //create
    public void createPyramidObject (String [] data);
    public Map <String , Integer> countSitePyramid();
    public List<Pyramid> SortPyramids ();
    
    
}
