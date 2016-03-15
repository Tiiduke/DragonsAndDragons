/**
 * Created by Silver on 14.03.2016.
 */
import java.util.Arrays;
import java.util.Scanner;



public class DraakoniLooja {
    Dragon[] getBots() {
        Dragon[] temp = {
                new RubyDragon("Red Dragon", 100, 50, 10, 12, 10, 0.2, 0.3),
                new DarknessDragon("Black Dragon", 100, 50, 10, 12, 10, 0.2, 0.3),
                new GreenDragon("Green Dragon", 100, 50, 10, 12, 10, 0.2, 0.3),
                new StarDragon("Whire Lotus", 100, 50, 10, 12, 10, 0.2, 0.3),
                new Dragon("King Black Dragon", 100, 40, 8, 14, 12, 0.2, 0.3)};
        return temp;
    }
    Dragon getPlayer (){

        Scanner valimine = new Scanner(System.in);
        Scanner tegemine = new Scanner(System.in);
        Scanner nimetamine = new Scanner(System.in);


        Dragon meieDragon = new Dragon();

        System.out.println("Kas soovite ise draakoni luua(Y)või valida üks mitmetest valmis draakonites(N)");
        String soov = tegemine.nextLine().toUpperCase();
        if (soov.equals("N")) {

            System.out.println("Ruby Dragon : Darkness Dragon : Green Dragon : Star Dragon : King Black Dragon");
            String valik = valimine.nextLine();

            if (valik.equals("Ruby Dragon") || valik.equals("1")) {
                meieDragon = new RubyDragon("Red Dragon", 100, 50, 10, 12, 10, 0.2, 0.3);
            } else if (valik.equals("Darkness Dragon")|| valik.equals("2")) {
                meieDragon = new DarknessDragon("Black Dragon", 100, 50, 10, 12, 10, 0.2, 0.3);
            } else if (valik.equals("Green Dragon")|| valik.equals("3")) {
                meieDragon = new GreenDragon("Green Dragon", 100, 50, 10, 12, 10, 0.2, 0.3);
            } else if (valik.equals("Star Dragon")|| valik.equals("4")) {
                meieDragon = new StarDragon("White Lotus", 100, 50, 10, 12, 10, 0.2, 0.3);
            } else if (valik.equals("King Black Dragon")|| valik.equals("5")) {
                meieDragon = new Dragon("King Black Dragon", 100, 40, 8, 14, 12, 0.2, 0.3);
            }

            System.out.println("Kuidas te sooviksite oma draakonit nimetada?");
            String nimi = nimetamine.nextLine();
            meieDragon.setName(nimi);


        } else if (soov.equals("Y")) {
            Scanner andmed = new Scanner(System.in);

            int[] array = new int[6];

            int StatPoints = 100;

            System.out.println("Kuidas te sooviksite oma draakonit nimetada?");
            String nimi = nimetamine.nextLine();
            meieDragon.setName(nimi);

            System.out.println("Kui palju elusid saab teie draakonil olema?");
            int draakoniEludTest = andmed.nextInt();
            System.out.println("Teil on veel kasutada "+ (StatPoints-draakoniEludTest)+ " punkti");
            StatPoints=StatPoints-draakoniEludTest;
            if(StatPoints<0){System.out.println("Dosent work");}
            array[0] = (draakoniEludTest);

            System.out.println("Palju rüüd saab teie draakonil olema?");
            int draakoniRüü = andmed.nextInt();
            System.out.println("Teil on veel kasutada "+(StatPoints-draakoniRüü)+ " punkti");
            StatPoints=StatPoints-draakoniRüü;
            if(StatPoints<0){System.out.println("dosent work");}
            array[1] = (draakoniRüü);

            System.out.println("Kui suur saab teie draakoni rünne olema?");
            int draakoniRünne = andmed.nextInt();
            System.out.println("Teil on veel kasutada "+(StatPoints-draakoniRünne)+ " punkti");
            StatPoints=StatPoints-draakoniRünne;
            if(StatPoints<0){System.out.println("dosent work yet");}
            array[2] = (draakoniRünne);

            System.out.println("Kui suur saab teie draakoni spell damage olema?");
            int draakoniSpellDamage = andmed.nextInt();
            System.out.println("Teil on veel kasutada "+(StatPoints-draakoniSpellDamage)+ "punkti");
            StatPoints=StatPoints-draakoniSpellDamage;
            if(StatPoints<0){System.out.println("Dosent work yet");}
            array[3] = (draakoniSpellDamage);

            System.out.println("Kui suur saab teie draakoni critc chance olema?");
            int draakoniCritChance = andmed.nextInt();
            System.out.println("Teil on veel kasutada "+(StatPoints-draakoniCritChance)+ " punkti");
            StatPoints=StatPoints-draakoniCritChance;
            if(StatPoints<0){System.out.println("Dosent work yet");}
            array[4] = (draakoniCritChance);

            System.out.println("Kui suur saab teie draakoni block chance olema?");
            int draakoniBlockChance = andmed.nextInt();
            System.out.println("Teil on veel kasutada "+(StatPoints-draakoniBlockChance)+ " punkti");
            StatPoints=StatPoints-draakoniBlockChance;
            if(StatPoints<0){System.out.println("Dosent work yet");}
            array[5] = (draakoniBlockChance);

            meieDragon.assignStats(array);
        }
        return meieDragon;



    }
}
