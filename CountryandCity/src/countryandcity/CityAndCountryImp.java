
package countryandcity;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author noham
 */
public class CityAndCountryImp implements CityAndCountryDAO{
    private List <Country>AllCountries ;
    private List <City>AllCities ;
    private List <City>myCity ;
    private Map <String , List <City>>CountryCode_ListOfCities = new LinkedHashMap<>();
   
    @Override
    public List<City> getAllCities(String fname) {
        try {
            AllCities= new ArrayList <City>();
            BufferedReader csvReader;
            csvReader = new BufferedReader(new FileReader(fname));
            String row ,headerLine ;
            headerLine = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                createCityObject(data);
                
            }   
        } catch (IOException ex) {
            Logger.getLogger(CityAndCountryImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AllCities;
    }

    @Override
    public List<Country> getAllCountries(String fname) {
        try {
            AllCountries= new ArrayList <Country>();
            BufferedReader csvReader;
            csvReader = new BufferedReader(new FileReader(fname));
            String row ;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                createCountryObject(data);
                
            }   
        } catch (IOException ex) {
            Logger.getLogger(CityAndCountryImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AllCountries;
    }

    @Override
    public void createCityObject(String[] data) {
        City c = new City(Integer.parseInt(data[0]), data[1],Integer.parseInt(data[4]),data[2]);
        AllCities.add(c);
    }

    @Override
    public void createCountryObject(String[] data) {
        Country cou = new Country(data[0], data[1], data[2],Double.parseDouble(data[4]),Integer.parseInt(data[3]), Double.parseDouble(data[5]), Integer.parseInt(data[6]));
        AllCountries.add(cou);
    }
    //CountryCode_ListOfCities
    @Override
    public Map <String , List <City>> getCitiesByCcode()
    {
        if (!AllCities.isEmpty())
        {
            for (City c:AllCities)
            {
            String key = c.getCountryCode();
            if (CountryCode_ListOfCities.containsKey(key))
            {
                CountryCode_ListOfCities.get(key).add(c);
            }else {
                List<City> temp = new ArrayList<City>();
                temp.add(c);
                CountryCode_ListOfCities.put(key,temp);
            }
    
            }
        
        
        }
    
    return CountryCode_ListOfCities ;
    }

    @Override
    public List<City> SortedCityByCode(String code) {
        
        List<City> temp2 = new ArrayList<City>();
               
        if (!AllCities.isEmpty())
        {
            for (City c:AllCities)
            {
            String key = c.getCountryCode();
            if (code.equals(key))
            {
                 temp2.add(c);
            }
            }
        }
    return temp2;
        }

    @Override
    public OptionalDouble getAvgCountryPop() {
        OptionalDouble avg = AllCountries.stream().mapToLong(Country::getPopulation).average();
        return avg;
    }

    @Override
    public Country getMaxPopCountry() {
        return AllCountries.stream().max(Comparator.comparing(Country::getPopulation)).get();
    }

    @Override
    public Map<String, List<City>> getCitiesByCcodeSorted() {
       if (!AllCities.isEmpty())
        {
        CountryCode_ListOfCities.forEach((k,v)->{
            v= v.stream().sorted(Comparator.comparing(City::getPopulation).reversed()).collect(Collectors.toList());
            CountryCode_ListOfCities.replace(k, v);
            });
    
    }
        
    return CountryCode_ListOfCities ;
    }
}
   /* @Override
    public List <City> getHPopCapital() {
        myCity = AllCities.stream().filter(city->AllCountries.stream()
       .map(Country::getCapital)
       .anyMatch(Cc->Cc==city.getId()))
       .max(Comparator.comparing(City::getPopulation));
        
       return myCity ;    
    
    }*/

    
