/**
 * Created by Silver on 14.03.2016.
 */
import java.util.Scanner;

public abstract class DragonCreator {

    public static final Dragon[] dragonTypes = {
            new RubyDragon(),
            new DarknessDragon(),
            new GreenDragon(),
            new StarDragon(),
    };

    public static Dragon[] getDragons() {

        String[] dragonNames = {"Red Dragon", "Darkness Dragon", "Green Dragon", "White Lotus"};

        double[] probabilities = BooleanVariation.getProbabilityArray(new boolean[] {true, true, true, true, true, true});

        for (int i = 0; i < dragonTypes.length; i++) {
            dragonTypes[i].assignStats(Stats.getStats(probabilities));
            dragonTypes[i].setName(dragonNames[i]);
        }

        return dragonTypes;
    }

    private static void printDragonDescriptions() {

        System.out.println("Saadaval on nelja tüüpi draakoneid: ");
        System.out.println("1. Punane draakon - äärmiselt tugev loitsija, kuid tavavõitluses nõrk!");
        System.out.println("2. Pimeduse draakon - tugev võitlusdraakon, kelle loitsud on äärmiselt tugevad, kuid mille kasutamisvõimalus on äärmiselt väike!");
        System.out.println("3. Roheline draakon - tugev loitsija, kes on tugev ka tavavõitluses!");
        System.out.println("4. Tähedraakon - väga tugev loitsija, kes on varieeruva tugevusega tavavõitluses!");
    }

    private static int[] getPlayerArray() {

        Scanner scan = new Scanner(System.in);

        int[] dragonStats = new int[6];
        int remainingStatPoints = 100;

        System.out.println("Määrake statistikupunktide jaotus oma draakonile!");
        System.out.println("Kui valite viimasele statistikule liiga vähe punkte, siis määratakse ülejäänud statistikupunkti eludesse!");
        System.out.println("Kui soovite poole pealt määramist uuesti alustada, vajutage Enter!");


        for (int i = 0; i < dragonStats.length; i++) {
            printNextQuestion(i);
            printRemainingStatPoints(remainingStatPoints);

            String vastus = scan.nextLine();
            if (vastus.equals("")) {
                i = -1;
                remainingStatPoints = 100;
                continue;
            }

            if (Integer.parseInt(vastus) > remainingStatPoints) {
                System.out.println("Teil ei ole nii palju statistikupunkte!");
                i--;
                continue;
            }

            dragonStats[i] = Integer.parseInt(vastus);
            remainingStatPoints -= Integer.parseInt(vastus);

            if (remainingStatPoints <= 0)
                break;
        }

        if (remainingStatPoints > 0)
            dragonStats[0] += remainingStatPoints;

        //scan.close();

        return dragonStats;
    }

    private static void printRemainingStatPoints(int remaningStatPoints) {

        System.out.println("Teil on alles " + remaningStatPoints + " statistikupunkti!");
    }

    private static void printNextQuestion (int questionCount) {

        switch(questionCount) {
            case 0: System.out.println("Kui palju elusid saab teie draakonil olema?"); break;
            case 1: System.out.println("Palju rüüd saab teie draakonil olema?"); break;
            case 2: System.out.println("Kui tugev saab draakoni rünnak olema?"); break;
            case 3: System.out.println("Kui suur saab teie draakoni loitsimisjõud olema?"); break;
            case 4: System.out.println("Kui suur saab teie draakoni kriitilise rünnaku võimalus olema?"); break;
            case 5: System.out.println("Kui suur saab teie draakon rünnaku blokeerimise võimalus olema?"); break;
            default: System.out.println("Too many questions"); break;
        }
    }

    public static Dragon getPlayerDragon () {

        Scanner scan = new Scanner(System.in);

        System.out.println("Kas soovite ise draakoni luua? Y/N");
        String dragonCreateChoice = scan.nextLine().toUpperCase();

        printDragonDescriptions();
        System.out.println("Millist tüüpi draakonit soovite? 1-5");
        int valik = Integer.parseInt(scan.nextLine());

        Dragon playerDragon = new Dragon(dragonTypes[valik - 1]);

        System.out.println("Kuidas te sooviksite oma draakonit nimetada?");
        playerDragon.setName(scan.nextLine());

        if (dragonCreateChoice.equals("Y"))
            playerDragon.assignStats(getPlayerArray());

        System.out.println("Teie " + playerDragon);
        System.out.println();

        //scan.close();

        return playerDragon;
    }
}
