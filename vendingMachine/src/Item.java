import java.io.IOException;
import java.io.PrintWriter;

/**
 * Abstract class Item sets constructors and parameters for child classes.
 * @author Philip Burggraf
 *
 */

public abstract class Item {
  private String name;
  private double price;
  private int quantity;
	    
  Item(){
    setName("");
	setPrice(0.0);
	setQuantity(0);
  }
  
  Item(String name, double price, int quantity){
    setName(name);
    setPrice(price);
    setQuantity(quantity);
  }
/**
 * Method returns item name.
 * @return method returns item name.
 */
  public String getName() {
    return name;
  }
  
 /**
  * Method sets item name. 
  * @param name is passed from VendingMachine
  */
  public void setName(String name) {
    this.name = name;
  }
/**
 * Method returns price.
 * @return method returns item price.
 */
  public double getPrice() {
    return price;
  }
/**
 * Method sets items name.
 * @param price  is passed from VendingMachine.
 */
  public void setPrice(double price) {
    if(price > 0) {
      this.price = price;
    } else {
        this.price = 0;
    }
  }
/**
 * Method returns quantity.
 * @return  method returns quantity. 
 */
  public int getQuantity() {
    return quantity;
  }
/**
 * Method using arguments to set quantity. 
 * @param quantity  is passed from VendingMachine.
 */
  public void setQuantity(int quantity) {
    if(quantity > 0) {
	  this.quantity = quantity;
	} else {
	  this.quantity = 0;
	}
  }
/**
 * Method reduces the quantity by the amount passed to it.
 * @param amount  is passed from VendingMachine. 
 */
  public void reduce(int amount) {
    if(amount > 0 && amount <= quantity) {
      quantity = quantity - amount;
    } 
  }
/**
 * Method displays Item data to console using specific format. 
 */
  public void display() {
    System.out.printf("%s,$%1.2f,%d remaining ", this.name,this.price,this.quantity); 
    
  }
/**
 * Method overrides toString () to return variables.
 */
  public String toString() {
    return this.name + ',' + this.price + ',' + this.quantity;  
  }  
  /**
   * Method writes data to file. 
   * @param outFile  is passed from VendingMachine and represents PrintWriter object. 
   * @throws IOException  IOException is thrown. 
   */
  public abstract void store(PrintWriter outFile) throws IOException;
} //end of class
