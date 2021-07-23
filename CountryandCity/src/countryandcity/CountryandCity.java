/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countryandcity;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author noham
 */
public class CountryandCity {

    
    public static void main(String[] args) throws IOException {
        CityAndCountryDAO cDAO= new CityAndCountryImp();
        List<City> city = cDAO.getAllCities("Cities.csv");
        List<Country> country = cDAO.getAllCountries("Countries.csv");
        /*int i =1;
        for (Country p :country)
        {
            System.out.println ("#"+(i++)+"  "+p);
        }*/
         System.out.println ("Now cities and countries are stored in list of objects ");
         System.out.println ("country code as keys and a list of cities as the value for  each country \n");
         
         cDAO.getCitiesByCcode().forEach((k,v)->{
            System.out.print("Country Code : ");
            System.out.println(k);
            v.forEach( tmpCity ->{ System.out.println(tmpCity.getName());
            
        });
          System.out.println("_________________________________________________________________________"); 
        });
        
         System.out.println ("Task 3 For a given country code (from Console) sort the cities according to the population \n");
         Scanner myObj = new Scanner(System.in);
         System.out.print("Enter Country Code :");
         String code  = myObj.nextLine();
         cDAO.SortedCityByCode(code).stream().sorted(Comparator.comparing(City::getPopulation)).collect(Collectors.toList())
                 .forEach(c->System.out.println(c.getName()+"  "+c.getPopulation()));
         
        
        
         
        System.out.println("_________________________________________________________________________"); 
        System.out.println ("Get a List of countries population \n");
        country.stream().forEach(c->{
        System.out.println (c.getName()+"  "+c.getPopulation());
        });
        
        
        System.out.println("\n\n\n_________________________________________________________________________"); 
        System.out.println ("Get the average countries population \n");
        System.out.println ("the average population :"+ cDAO.getAvgCountryPop());
        System.out.println ("Get the maximum countries population");
        System.out.println ("the max population country is :"+ cDAO.getMaxPopCountry());
        System.out.println("_________________________________________________________________________"); 
        System.out.println ("Highest population city of each country");
        String cou ; 
        
        cDAO.getCitiesByCcodeSorted().forEach((k,v)->{ 
        System.out.println(k);
        System.out.println(v.get(0));
        System.out.println("_________________________________________________________________________"); 
        }
        );
        
        System.out.println("_________________________________________________________________________"); 
        System.out.println (" Highest population capital");
        
        
        
        
        
        }
         
    }
    
