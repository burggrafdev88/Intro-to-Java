import java.io.IOException;
import java.io.PrintWriter;
/**
 * Class extends abstract class Item. Sets parameters and methods for Soda.
 * @author Philip Burggraf
 *
 */

class Soda extends Item {
  private boolean caffeine;
  
  Soda(){
    super();
    setCaffeine(false);
  }
  
  Soda(String name, double price, int quantity, boolean caffeine){
    super(name, price, quantity);
    setCaffeine(caffeine);
  }
  /**
   * Method returns whether or not Soda contains caffeine.
   * @return  returns whether or not Soda contains caffeine. 
   */
  public boolean getCaffeine() {
    return caffeine;
  }
  
  /**
   * Method sets boolean value for whether or not Soda contains caffeine. 
   * @param caffeine is passed from Soda.
   */
  public void setCaffeine(boolean caffeine) {
    this.caffeine = caffeine;
  }
  /**
   * Method calls super constructor and uses parameters to display whether or not Soda
   * contains caffeine.
   */
  public void display() {
    super.display();
    
    if(this.caffeine == true) {   //should I use this.caffeine or just caffeine?
      System.out.print("(caffeine)");
    } else {
        System.out.print("(no caffeine)");
      }
  }
  /**
   * Method overrides toString() to return Soda variables. Calls super toString. 
   */
  public String toString() {
    return "Soda," + super.toString() + "," + this.caffeine;
  }
  /**
   * Method writes data to the file. 
   * @param outFile  is passed from VendingMachine and represents PrintWriter object. 
   * @throws IOException  IOException is thrown. 
   */
  public void store(PrintWriter outFile) throws IOException {
    outFile.println(this.toString());
  }
}
