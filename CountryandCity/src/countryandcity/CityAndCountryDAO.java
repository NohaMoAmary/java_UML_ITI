
package countryandcity;

import java.util.*;

/**
 *
 * @author noham
 */
public interface CityAndCountryDAO {
    public List <City> getAllCities(String fname); 
    public List <Country> getAllCountries(String fname); 
    public void createCityObject (String [] data);
    public void createCountryObject (String [] data);
    public Map <String , List <City>> getCitiesByCcode();
    public Map <String , List <City>> getCitiesByCcodeSorted();
    public List <City>SortedCityByCode(String code );
    public OptionalDouble getAvgCountryPop();
    public Country getMaxPopCountry () ;
    //public List<City> getHPopCapital();
    
}
