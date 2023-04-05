import java.util.ArrayList;

/**
 * Creates a House, and stores the name,adress,number of Floors, residents, and dining room variables
 * @param name - name of the House
 * @param address - address of the House
 * @param nFloors - number of floors in the House
 * @param hasDiningRoom - if the House has a dining room
 * @return a House object
 */

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

    /* Overloaded constructer with adress */
  public House(String address) {
    super(address);
    this.address = address;
    this.nFloors = 1;
    this.residents = new ArrayList<String>();
}

    /* Overloaded constructor with name, address */
  public House(String name, String address) {
    super(name,address);
    this.name = name;
    this.address = address;
    this.nFloors = 1;
    this.residents = new ArrayList<String>();
}
    /* Full Constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name,address,nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /**
  * Print a String which ccontaints information about the House
  * @return information about the house
  */
  public String toString() {
    String description = super.toString();
    description += " This house has " + this.residents.size() + " residents";
    description += ". This house ";
    if(this.hasDiningRoom){
      description += "has ";
    }else{
      description += "does not have";
    }
    description += "a dining room.";
    return description;
  }

  /**
  * Shows if th house has a dining room
  * @param hasDiningRoom - whether or not the house has a dining room
  * @return true if house has a dining room and false if house does not have a dining room
  */
  public boolean getDiningRoom(boolean hasDiningRoom){
    if(this.hasDiningRoom == true){
      return true;
    }else{
      return false;
    }
  }

  /**
  * Returns the amount of residents in the house
  * @param residents the array containing the people living in the house
  * @return the size of the array
  */
  public Integer residentSize(){
    System.out.println("Resident size: "+this.residents.size());
    return this.residents.size();
  }

  /**
  * Moves a person into the House
  * @param name - name of the Person
  */
  public void moveIn(String name){
    this.residents.add(name);
  }

  /**
  * Removes a person out of the House
  * @param name - name of the Person
  * @return name of the person
  */
  public String moveOut(String name){
    this.residents.remove(name);
    return name;
  }

  /**
  * Shows if that person is a resident in the House
  * @param person - name of the Person
  * @return true if the person is a resident and false if the person is not a resident
  */
  public boolean isResident(String person){
    if (this.residents.contains(person) == true){
      System.out.println(person + " is a resident");
      return true;
    }else{
      System.out.println(person + " Is not a resident");
      return false;
      }
    }

    public void showOptions(){
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + goToDiningRoom()\n + moveIn()\n + moveOut()");
    }

    public void goToDiningRoom(){
        if(hasDiningRoom == false){
            throw new RuntimeException("This house has no dining room.");
        }else{
            System.out.println("You are now in the dining hall.");
        }
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
    House ziskind = new House("Zisking","1 Henshaw Ace northhampton", 3,true,false);
    System.out.println(ziskind);

    House Capen = new House("Capen", "107 s lindale");
    System.out.println(Capen);

    House Lamont = new House("19 ave");
    System.out.println(Lamont);
    Lamont.showOptions();
  }

}