public class Rocket implements Spaceship{
    int cost;
    double weight;
    double maxWeight;
    double chanceOfExplosionLaunch;
    double getChanceOfExplosionLanding;

    public boolean launch(){

        return true;

    }

    public boolean land(){

        return true;

    }

    public boolean canCarry(Item item) {

        if (item.item + this.weight >= this.maxWeight){
            //System.out.println("F");
            return false;

        }
        else{
         //System.out.println("T");
         return true;
        }

    }

    public void carry(Item item){

        weight = weight + item.item;

    }

}
