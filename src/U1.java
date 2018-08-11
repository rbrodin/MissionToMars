public class U1 extends Rocket {

    U1(){

        cost = 100000000; // million
        weight = 20000; // tons
        maxWeight = 36000;
        chanceOfExplosionLaunch = 0.05;
        getChanceOfExplosionLanding = 0.01;
        System.out.println("U1 Built.");

    }

    public boolean launch(){
        double tempNum = (this.weight / this.maxWeight);
        //System.out.println(tempNum);
        chanceOfExplosionLaunch = chanceOfExplosionLaunch / tempNum;
        double randomInt = Math.random();
        //System.out.println(chanceOfExplosionLaunch);
        //System.out.println(randomInt);

        // Checks if rocket exploded.
        if((chanceOfExplosionLaunch >= randomInt) && (0.0 <= randomInt)){
            System.out.println("Exploded!");
            return false;
        }

        System.out.println("Launched!");
        return true;
    }

    public boolean land(){

        double tempNum = (this.weight / this.maxWeight);
        //System.out.println(tempNum);
        getChanceOfExplosionLanding = getChanceOfExplosionLanding/ tempNum;
        double randomInt = Math.random();
        //System.out.println(chanceOfExplosionLaunch);
        //System.out.println(randomInt);

        // Checks if rocket exploded.
        if((getChanceOfExplosionLanding >= randomInt) && (0.0 <= randomInt)){
            System.out.println("Exploded!");
            return false;
        }

        System.out.println("Landed!");
        return true;


    }


}
