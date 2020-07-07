import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
/**
 * 
 * @author Philip Burggraf
 *This program will import a Kansas Towns file and use a while loop to calculate the 
 *population of the cities. If the file is not able to be located, it will utilize 
 *a try/catch to display an exception message. 
 */

public class KSTowns {
  public static void main (String[] args){
  //Declaring variables and instantiating file object. 
  String cityNames = "";
  String cityName;
  int cityPopulation;
  int populationTotal = 0;
  File file = new File("KansasTownsPop1.txt");  //I need to update the file name and get correct files.
  Scanner input = null;
  //Utilizing try/catch statement to address File Not Found Exceptions. If no exception, 
  //while loop will run and populate results. 
  try {
    input = new Scanner(file);
    while(input.hasNext()) {  
      cityName = input.next();
      cityNames += " " + cityName;  
      cityPopulation = input.nextInt();
      populationTotal += cityPopulation;
    }
    System.out.println("The total population of " + cityNames + " is " + populationTotal + ".");     
  } catch(FileNotFoundException e){
      System.out.println(file.getName() + " does not exist.");
      System.exit(1); 
    } 
  }
}

  