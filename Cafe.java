public class Cafe extends Building{
   private int nCoffeeOunces;
   private int nSugarPackets;
   private int nCreams; 
   private int nCups; 
    /**
     * Overloaded constructor with adress
     * @param address Adress of the Cafe
     */
    public Cafe(String address) {
    super(address);
    this.address = address;
    this.nFloors = 1;
    }

    /** Overloaded constructor with name, address 
    *@param name Name of the Cafe
    * @param address Address of the Cafe
    */
   public Cafe(String name, String address) {
       super(name,address);
       this.nFloors = 1;
   }

    /** The Cafe constructor creates a new Cafe Object
     * @param name Name of the Cafe
     * @param address Address of the Cafe
     * @param nFloors Number of floors in the Cafe
     */
   public Cafe(String name, String address, int nFloors) {
    super(name,address);
    this.nCoffeeOunces = 40;
    this.nSugarPackets = 10;
    this.nCreams = 10;
    this.nCups = 10;
}

   /**Will decrease the amount of ingredients available after an order
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
   /**Will make all of the ingredients to their maximum value
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
   /**
    * Prints out the possible methods that can be used
    */
   public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + getCoffee()");
   }
   /** Keeps the person on floor one
     * @param floorNum the floor number to go to
     * @throws RuntimeException If customer asks to go to a different floor
     */
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
