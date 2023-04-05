import java.util.Hashtable;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Creates a Library, and stores the name,adress,number of Floors, books, and book availability
 * @param name - name of the Library
 * @param address - address of the Library
 * @param nFloors - number of floors in the Library
 * @param title - the title and author of the book
 * @param isAvailable - if the book is available or not
 * @return a Library object
 */
public class Library extends Building {
  
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /* Overloaded constructer with address */
  public Library(String address) {
    super(address);
    this.address = address;
    this.nFloors = 1;
    this.collection = new Hashtable<String, Boolean>();
    }

    /* Overloaded constructor with name, address, nFloors, and hasElevator */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name,address);
    this.name = name;
    this.address = address;
    this.nFloors = nFloors;
    this.hasElevator = hasElevator;
    this.collection = new Hashtable<String, Boolean>();
    }

  public Library(String name, String address, int nFloors, String title, Boolean isAvailable, boolean hasElevator) {
    super(name,address,nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = hasElevator;
  }
  /**
   * Adds a title to the collection
   * @param title
   */
  public void addTitle(String title){
    this.collection.put(title,true);
  }

  /**
   * Removes a title from the collection
   * @param title
   * @return title
   */
  public String removeTitle(String title){
    this.collection.remove(title);
    return title;
  }

  /**
   * Checks if the collection has the title and if its able to be checked out, if so it is checked out
   * @param title
   */
  public void checkOut(String title){
    if (this.collection.containsKey(title) == true && this.collection.get(title) == true){
      this.collection.replace(title,false);
    }
  }

  /**
   * Checks if the collection has the title, if so it is returned to the collection
   * @param title
   */
  public void returnBook(String title){
    if (this.collection.containsKey(title) == true){
      this.collection.replace(title,true);
    }
  }

  /**
   * Checks if the collection has the title
   * @param title
   * @return true if the collection has the title and false if the collection does not have the title
   */
  public boolean containsTitle(String title){
    if (this.collection.containsKey(title) == true){
      System.out.println("Here");
      return true;
    }else{
      System.out.println("Not here");
      return false;
    }
  }

  /**
   * Checks if the title is able to be be checked out
   * @param title
   * @return true if it can be checked out and false if it is not able to be checked out
   */
  public boolean isAvailable(String title){
    if (this.collection.containsKey(title) == true && this.collection.get(title) == true){
      System.out.println("Is available");
      return true;
    }else{
      System.out.println("Is NOT available");
      return false;
    }
  }

  /**
   * Prints the keys and values of the Hashtable
   */
  public void printCollection(){
    Set<Entry<String, Boolean>> entires = this.collection.entrySet();
    if(this.collection.isEmpty()){
	    System.out.println("No books to show");
    }else{
      for(Entry<String,Boolean> ent:entires){
        System.out.print(ent.getKey());
        if(ent.getValue() == true){
          System.out.println(" availale for check out");
        }else{
          System.out.println(" not available for check out");
        }
      }
    }   
  }


  public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + checkOut()\n + returnBook()");
    }

    public void goToFloor(int floorNum) {
        if (this.hasElevator == true){
            super.goToFloor(floorNum);
        }

        if (this.hasElevator == false && (floorNum == activeFloor + 1 || floorNum == activeFloor -1 || floorNum == activeFloor)){
            super.goToFloor(floorNum);
        }else if(this.hasElevator == false) {
            throw new RuntimeException("Invalid floor number. This house has no elevator");
        }

    }

    public static void main(String[] args) {
      Library neilson = new Library("neilson","26 Henshaw Ace Northnahomton", 3,"little red",true,false);
      System.out.println(neilson);

      Library jostens = new Library("26 Henshaw Ace Northnahomton");
      System.out.println(jostens);

      Library hilliyer = new Library("hilliyer","26 Henshaw Ace Northnahomton", 3 , true);
      System.out.println(hilliyer);

      hilliyer.showOptions();
    }
  }