/**
* Creates a Cafe Object
* @param nCoffeeOUnces - the amount of CoffeeOunces
* @param nSugarPackets - the amount of SugarPackets
* @param nCreams - the amount of Creams
* @param nCups - the amount of Cups
* @return the Cafe Object and information about the Object
*/
public class Cafe extends Building{
   private int nCoffeeOunces;
   private int nSugarPackets;
   private int nCreams; 
   private int nCups; 

   /* Overloaded constructer with address */
  public Cafe(String address) {
    super(address);
    this.address = address;
    this.nFloors = 1;
    }

    /* Overloaded constructor with name, address */

   public Cafe(String name, String address) {
       super(name,address);
       this.nFloors = 1;
   }

   /*Full Constructor */
   public Cafe(String name, String address, int nFloors) {
    super(name,address);
    this.nCoffeeOunces = 40;
    this.nSugarPackets = 10;
    this.nCreams = 10;
    this.nCups = 10;
}

   /**
    * Will decrease the amount of ingredients available after an order
    * @param size
    * @param nSugarPackets
    * @param nCreams
    */
   public void getCoffee(int size, int nSugarPackets, int nCreams){
       if(this.nCups == 0 || this.nCoffeeOunces - size <=0 || this.nSugarPackets - nSugarPackets<= 0 || this.nCreams - nCreams<= 0){
           restock(this.nCoffeeOunces, this.nSugarPackets, this.nCreams, this.nCups);
       }
       
       this.nCups = this.nCups - 1;
       this.nCoffeeOunces = this.nCoffeeOunces-size;
       this.nSugarPackets = this.nSugarPackets - nSugarPackets;
       this.nCreams = this.nCreams - nCreams;

       System.out.println("NEW ORDER");
       System.out.println("coffee ounces " + this.nCoffeeOunces);
       System.out.println("coffee SugarPackets " + this.nSugarPackets);
       System.out.println("sugar creams " + this.nCreams);
       System.out.println("cups " + this.nCups);
   }
   /**
    * Will make all of the ingridients to their maximum value
    * @param nCoffeeOunces
    * @param nSugarPackets
    * @param nCreams
    * @param nCups
    */
   private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
       this.nCoffeeOunces = 40;
       this.nSugarPackets = 10;
       this.nCreams = 10;
       this.nCups = 10;
       System.out.println("Stocked");
   }

   public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + getCoffee()");
   }

   public void goToFloor(int floorNum) {
    if (floorNum != 1){
        throw new RuntimeException("Invalid floor number. You may only stay in the first floor");
    }
    }
   
   public static void main(String[] args) {
       Cafe cc = new Cafe("cc","10 richardson", 1);
       cc.showOptions();
       cc.enter();
       cc.goToFloor(1);

   }
   
} 
