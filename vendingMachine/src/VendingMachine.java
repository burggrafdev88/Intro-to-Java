import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;

/**
 * @author Philip Burggraf
 * class VendingMachine simulates a simple Vending Machine
 * where items may be purchased, and item information is updated
 * and stored.
 */
public class VendingMachine {
  private ArrayList<Item> items;

  public static void main(String[] args) {
    VendingMachine machine = new VendingMachine();
    
    try {
      machine.start("items.txt");
      machine.run();
      machine.stop("items.txt");
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }
  /**
   * Method creates an empty ArrayList named items.
   */
  public VendingMachine() {
    items = new ArrayList<Item>();   
    // Assign a new empty array list to the items field
  }

  /**
   * Method start loads the machine with vending machine data.
   * @param filename The name of the file storing the vending
   *                 machine data.
   * @throws IOException
   */
  public void start(String filename) throws IOException {
	
	File file = new File(filename); 
    
	if(file.exists() == false) {
      System.out.println("This file does not exist.");
      System.exit(1);
    }
	
    Scanner input = new Scanner(file);  
    ArrayList<String> list = new ArrayList<String>();
    String[] lineInfoSplit = null;
    // Check if the filename exists. If not, inform the user that the
    // file does not exist and exit with an error code of 1.  complete.
    // Open the file for reading complete.
    // While there are more lines in the file, read each vending machine
    // item from file into the items list.  
    
    while (input.hasNextLine()) {
      list.add(input.nextLine());
      for(String line : list) {
        lineInfoSplit = line.split(",");
      }
      if(lineInfoSplit[0].equals("Soda")) {
        String name = lineInfoSplit[1];
        double price = Double.parseDouble(lineInfoSplit[2]);
        int quantity = Integer.parseInt(lineInfoSplit[3]);
        boolean caffeine;
        if(lineInfoSplit[4].equals("true")) {
          caffeine = true;
        } else {
            caffeine = false;
        }
        Item soda = new Soda(name, price, quantity, caffeine);
        items.add(soda);
      } else {
    	  String name = lineInfoSplit[1];
          double price = Double.parseDouble(lineInfoSplit[2]);
          int quantity = Integer.parseInt(lineInfoSplit[3]);
          boolean nuts;
          if(lineInfoSplit[4].equals("true")) {
              nuts = true;
            } else {
                nuts = false;
            }
          Item candy = new Candy(name, price, quantity, nuts);
          items.add(candy);
      }
      // Read the next line from the file and split into an
      // array of strings
      // IF the line of data read represents a Soda, build a new
      // Soda object with the name/price/quantity/caffeine information
      // and then add it to items
      // ELSE build a new Candy object with the name/price/quantity/nuts
      // information and add it to items
    }
    input.close();
    // Close the file 

  }

  /**
   * Method lookup performs a case-insensitive linear search to determine
   * if a vending machine item with the given name exists.
   * @param itemName The name of the vending machine item to find.
   * @return A reference to the item found or null if not found.
   */
  public Item lookup(String itemName) {  
    for(Item item : items) {
      if(item.getName().equals(itemName)) {
        return item;
      } 
    }
	return null;
  }

  /**
   * Method displayItems displays each item in the machine.
   */
  public void displayItems() {
    for(Item item : items) {
      item.display();
      System.out.println();
    }
  }

  /**
   * Method run allows a user to purchase items from the machine.
   */
  public void run() {
    String choice;
    Scanner input = new Scanner(System.in);
    // Process transactions until the user quits
    do {
      displayItems();
      System.out.println("Item?");
      choice = input.nextLine();
      //Prompt for and retrieve the item into a String variable named choice

      Item item = lookup(choice);

      // If item is found, proceed with the purchase
      if (item != null) {
    	double payment;
    	double remainingPrice;
    	int itemQuantity;
        if(item.getQuantity() > 0) {
          itemQuantity = item.getQuantity();
          System.out.println("Enter money:");
          choice = input.nextLine();
          payment = Double.parseDouble(choice);
         // payment = input.nextDouble();
          remainingPrice = item.getPrice() - payment;
          while(remainingPrice > 0) {
            System.out.println("Enter $" + remainingPrice + " more:");
            choice = input.nextLine();
            payment = Double.parseDouble(choice);
            //payment = input.nextDouble();
            remainingPrice -= payment;
          }
          System.out.println("Please take your " + item.getName() + ".");
          itemQuantity -= 1;
          item.setQuantity(itemQuantity);
          System.out.println("");
          if(remainingPrice < 0) {
            remainingPrice*=(-1);
            System.out.println("Please take your change ($" + remainingPrice +")");
          }
        }
        // If there is at least one item, then process the purchase
        // Prompt for and retrieve the money
        // Loop until enough money is entered
        // Tell the user to take the product and any remaining change.
        // Reduce the quantity of the item in stock by 1
        else if (item.getQuantity() <= 0) {
          System.out.println("Item sold out.");
        }
      }
      else if (item == null) {
        System.out.println("Invalid item.");
      }
      System.out.println("");
      System.out.println("====================");
      System.out.println("Quit? (y or n)");
      System.out.println("====================");
      choice = input.nextLine();

    } while (!choice.equalsIgnoreCase("y"));
  } // end run

  /**
   * Method stop writes the items to file.
   * @param filename The name of the file to which the items are written.
   * @throws IOException
   */
  public void stop(String filename) throws IOException {
    PrintWriter outFile = new PrintWriter(filename);
    for(Item item : items) {
      item.store(outFile);   
    }
    outFile.close();
  } // end stop
} // end class

