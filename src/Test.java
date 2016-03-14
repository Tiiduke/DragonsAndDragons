import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Tiit on 10.03.2016.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {


        Scanner andmed = new Scanner(System.in);

        int[] array = new int[6];

        //Dragon dragon1 = new GreenDragon();
        //Dragon dragon2 = new GreenDragon(dragon1);

        GreenDragon dragon1 = new GreenDragon("Green Dragon", 100, 50, 10, 12, 10, 0.2, 0.3);
        Dragon dragon2 = new Dragon("King Black Dragon", 100, 40, 8, 14, 12, 0.2, 0.3);
        RubyDragon dragon3 = new RubyDragon("Red Dragon", 100, 50, 10, 12, 10, 0.2, 0.3);
        DarknessDragon dragon4 = new DarknessDragon("Black Dragon", 100, 50, 10, 12, 10, 0.2, 0.3);
        StarDragon dragon5 = new StarDragon("Whie Lotus", 100, 50, 10, 12, 10, 0.2, 0.3);
        Dragon meieDragon = new Dragon("nimi", 0, 0, 0, 0, 0, 0, 0);

        //dragon1.attack(dragon2);

        while (dragon1.getHealth() > 0 && dragon2.getHealth() > 0) {

            for (int i = 1; i < 3; i++) {

                dragon1.attack(dragon2);
                if (dragon2.getHealth() < 0) {
                    System.out.println("\n" + dragon1.getName() + " made one last crushing blow and won");
                    return;
                } else
                    Thread.sleep(2000);
                System.out.println(dragon2.getName() + " has " + dragon2.getHealth() + " health after " + dragon1.getName() + " attack.");

                dragon2.attack(dragon1);
                if (dragon1.getHealth() < 0) {
                    System.out.println("\n" + dragon2.getName() + " made one last crushing blow and won");
                    return;
                } else
                    Thread.sleep(2000);
                System.out.println(dragon1.getName() + " has " + dragon1.getHealth() + " health after " + dragon2.getName() + " attack.");

            }
            Scanner sc = new Scanner(System.in);
            System.out.println("\nType in which spell to use : Flame Breath : Poison Breath : Kappa");
            String valik = sc.nextLine();

            if (valik.equals("Flame Breath")) {
                dragon2.cast_spell(dragon2.flameBreath, dragon1);
            } else if (valik.equals("Poison Breath")) {
                dragon2.cast_spell(Dragon.poisonBreath, dragon1);
            } else if (valik.equals("Kappa")) {
                dragon2.cast_spell(Dragon.kappa, dragon1);
            }

            if (dragon1.getHealth() < 0) {
                System.out.println("\n" + dragon2.getName() + " won");
                return;
            } else if (dragon2.getHealth() < 0) {
                System.out.println("\n" + dragon1.getName() + " won");
                return;
            }



/*
        System.out.println("Palju elusi saab teie draakonil olema?");
        int draakoniElud = andmed.nextInt();
        array[0]=(draakoniElud);


        System.out.println("How many hitpoints will your dragon have?");
        int draakoniEludTest = andmed.nextInt();
        meieDragon.setHealth(draakoniEludTest);*/


       /* System.out.println("How many hitpoints will your dragon have?");
        int draakoniEludTest = andmed.nextInt();
        array[0] = (draakoniEludTest);*/

/*
        System.out.println(meieDragon.getHealth());
        System.out.println(array[1]);
*/
/*
        for(int i = 0 ; i<5 ; i++){
            System.out.println(meieDragon.stats[i]);
        }*/
/*

        System.out.println("Palju rüüd saab teie draakonil olema?");
        int draakoniRüü = andmed.nextInt();
        array[1] = (draakoniRüü);


        System.out.println("Kui suur saab teie draakoni rünne olema?");
        int draakoniRünne = andmed.nextInt();
        array[2] = (draakoniRünne);

        System.out.println("Kui suur saab teie draakoni spell damage olema?");
        int draakoniSpellDamage = andmed.nextInt();
        array[3] = (draakoniSpellDamage);

        System.out.println("Kui suur saab teie draakoni critc chance olema?");
        int draakoniCritChance = andmed.nextInt();
        array[4] = (draakoniCritChance);

        System.out.println("Kui suur saab teie draakoni block chance olema?");
        int draakoniBlockChance = andmed.nextInt();
        array[5] = (draakoniBlockChance);
*/

//        for(int i = 0 ; i<6 ; i++){
//            meieDragon.stats[i]= array[i];
//        }
            // meieDragon.stats = array;
            // System.out.println(meieDragon.stats);


        }
    }
}


//dragon1.name = "Tiit";

// System.out.println(dragon2.spellCastChance);

