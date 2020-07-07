import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 * @author Philip Burggraf
 *This program will compute a wind chill based on a randomly generated temperature and wind speed.
 */

public class WindChill {
  public static void main (String[] args) {
    final int RANDTEMP = (int)(Math.random()*51);
    final int RANDWIND = (int)(4 + Math.random()*27);
    DecimalFormat df1 = new DecimalFormat(".#");
    System.out.println("Temperature: " + RANDTEMP + " degrees Fahrenheit");
    System.out.println("Wind speed: " + RANDWIND + " MPH");
    double windChill = computeWindChill(RANDTEMP, RANDWIND);
    System.out.println("Temperature (including wind chill): " + df1.format(windChill) +  " degrees Fahrenheit");
  }
/**
 * @pre: Temperature must be <= 50 degrees and wind speed must be > 3 to run.
 * @param RANDTEMP: random temperature generated in the WindChill class.
 * @param RANDWIND: Random wind speed generated in the WindChill class.
 * @return: method returns the computed wind chill.
 */
public static double computeWindChill(int RANDTEMP, int RANDWIND) {
  double windChill = 35.74 + 0.6215 * RANDTEMP - 35.75 * Math.pow(RANDWIND, 0.16) + 0.4275 * RANDTEMP * Math.pow(RANDWIND, 0.16);
 
  return windChill;
}

}
