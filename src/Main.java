import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main (String args[]) throws Exception{

        // Build a sim to go to Mars
        // Send a list of items to Mars, but need to run sims to pick the right rocket.
        // 2 rocket types: U-1, U-2
        // Two phases of the mission: Send building equipment, and then send humans.

        // Need a rocket class. -> Then a u-1 and u-2 class.
        // Need a way to set weights for each phase
        // Need a way to simulate the flight

        U1 myU1 = new U1();
        U2 myU2 = new U2();

        Sim mySimulation = new Sim();
        File myFile1 = new File("items1.txt");
        File myFile2 = new File("items2.txt");
        Item testItem = new Item();

        testItem.item = 16000;
        myU1.canCarry(testItem);
        mySimulation.runSimulation(myFile1, myFile2);
        // Thanks for everything guys :D Love you all - 8/6/2018

    }

}
