import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

// Class Simulation will read the data from the text file for the items and fill the rockets.
public class Sim {

    Sim() {

        System.out.println("Simulation Created!");
    }

    Rocket getPlaceHolder(boolean isU1) {
        if (isU1) {
            U1 placeHolder = new U1();
            return placeHolder;
        } else {
            U2 placeHolder = new U2();
            return placeHolder;
        }
    }

    ArrayList<Item> itemList = new ArrayList();

    public ArrayList<Item> loadItems(File file) {

        try {
            Scanner myScanner = new Scanner(file);
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();

                Item tempItem = new Item();
                tempItem.name = line.split("=")[0];
                tempItem.item = Integer.parseInt(line.split("=")[1]);

                //System.out.println(tempItem.name + " " + tempItem.item);
                itemList.add(tempItem);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    private void runLoop(ArrayList<Item> itemList, Rocket rocket) {

        // Issue that I'm running into is that some items can't fit in the U1, but
        ArrayList<Item> removedItems = new ArrayList();
        for (Item loopItem : itemList) {
            // Need to check if it is full, if so, break.
            if (rocket.canCarry(loopItem)) {

                //System.out.println("Item Added!");
                rocket.carry(loopItem);
                removedItems.add(loopItem);
                //System.out.println("Remove");

            } else {
                //System.out.println("Break " + loopItem.item);
                //System.out.println(loopItem.name);
                //System.out.println(rocket.weight);
                //System.out.println(removedItems.isEmpty());

            }
        }
        itemList.removeAll(removedItems);

    }

    public ArrayList<U1> loadU1(ArrayList<Item> itemList) {

        ArrayList<U1> U1List = new ArrayList();
        int U1ListLength = 0;

        U1 simU1 = new U1();
        U1 currentObject;

        // While the list of items isn't empty.
        //System.out.println("Running");
        currentObject = simU1;
        U1List.add(currentObject);

        while (!(itemList.isEmpty())) {
            currentObject = U1List.get(U1ListLength);
            // Need to somehow move to the next object if it can't fit it.
            //System.out.println("Running 2");

            // While loop should be fine here.
            if (currentObject.weight <= currentObject.maxWeight) {

                runLoop(itemList, currentObject);
                //System.out.println("1: ");
                //System.out.println(currentObject.maxWeight - currentObject.weight);

            }

            // ANOTHER ISSUE: Just stops, but it could theoretically fit more objects.
            U1 u1ToAdd = new U1();
            U1List.add(u1ToAdd);
            U1ListLength++;

            break;
        }

        for (U1 u1 : U1List) {

            //System.out.println(u1.weight);

        }
        return U1List;

    }

    public ArrayList<U2> loadU2(ArrayList<Item> itemList) {

        ArrayList<U2> U2List = new ArrayList();
        int U2ListLength = 0;

        U2 simU2 = new U2();
        U2 currentObject;

        // While the list of items isn't empty.
        //System.out.println("Running");
        currentObject = simU2;
        U2List.add(currentObject);

        while (!(itemList.isEmpty())) {
            currentObject = U2List.get(U2ListLength);
            // Need to somehow move to the next object if it can't fit it.
            //System.out.println("Running 2");

            // While loop should be fine here.
            if (currentObject.weight <= currentObject.maxWeight) {

                runLoop(itemList, currentObject);
                //System.out.println("1: ");
                //System.out.println(currentObject.maxWeight - currentObject.weight);

            }

            // ANOTHER ISSUE: Just stops, but it could theoretically fit more objects.
            U2 u2ToAdd = new U2();
            U2List.add(u2ToAdd);
            U2ListLength++;

            break;
        }

        for (U2 u2 : U2List) {

            //System.out.println(u2.weight);

        }
        return U2List;

    }

    public void runSimulation(File file1, File file2) {

        ArrayList<U1> phase1U1 = loadU1(loadItems(file1));
        ArrayList<U1> phase2U1 = loadU1(loadItems(file2));

        ArrayList<U2> phase1U2 = loadU2(loadItems(file1));
        ArrayList<U2> phase2U2 = loadU2(loadItems(file2));

        int costU1 = 0;
        int costU2 = 0;

       for (U1 u1 : phase1U1){

           System.out.println("U1 " + u1.weight);
           costU1 = costU1 + u1.cost;

       }
       for (U1 u1 : phase2U1){

            System.out.println("U1 " + u1.weight);
            costU1 = costU1 + u1.cost;
        }
        for (U2 u2 : phase1U2){
            System.out.println("U2 " + u2.weight);
            costU2 = costU2 + u2.cost;

        }
        for (U2 u2 : phase2U2){
            System.out.println("U2 " + u2.weight);
            costU2 = costU2 + u2.cost;
        }
        System.out.println("U1: " + costU1 + " U2: " + costU2);
    }
}