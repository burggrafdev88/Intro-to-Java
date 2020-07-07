import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class extends abstract class Item. Sets parameters and methods for Candy.
 * @author Philip Burggraf
 *
 */
class Candy extends Item {
  private boolean nuts;
  
  Candy(){
	super();  
    setNuts(false);
  }
  
  Candy(String name, double price, int quantity, boolean nuts){
    super(name, price, quantity);
    setNuts(nuts);
  }
  /**
   * Method returns whether or not Candy contains nuts.
   * @return  returns whether or not Candy contains nuts. 
   */
  public boolean getNuts() {
    return nuts;
  }
  /**
   * Method sets boolean value for whether or not Candy contains nuts. 
   * @param nuts is passed from VendingMachine.
   */
  public void setNuts(boolean nuts) {
    this.nuts = nuts;
  }
  /**
   * Method calls super constructor and uses parameters to display whether or not Candy
   * contains nuts.
   */
  public void display() {
    super.display();
    
    if(this.nuts == true) {   //should I use this.nuts or just nuts?
      System.out.print("(nuts)");
    } else {
      System.out.print("(no nuts)");
    }
  }
  /**
   * Method overrides toString() to return Candy variables. Calls super toString. 
   */
  public String toString() {
    return "Candy," + super.toString() + "," + this.nuts;
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
