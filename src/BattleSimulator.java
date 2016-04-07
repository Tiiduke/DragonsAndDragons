import java.util.ArrayList;

/**
 * Created by Tiit on 10.03.2016.
 */
/*
 * Klass mis on mõeldud lahingute simuleerimiseks draakonite vahel,
 * et oleks võimalik draakonite statistikuid ja Spelle balansseerida.
 */
public class BattleSimulator {

    public static ArrayList<Dragon> createDragons(int amountOfBalances) {

        int DRAGON_TYPE_COUNT = 4;

        boolean[] variation = new boolean[6];

        ArrayList<Dragon> dragons= new ArrayList<>();

        while(!BooleanVariation.checkForAllTrues(variation)) {
            BooleanVariation.changeToNextVariation(variation);

            double[] probabilities = BooleanVariation.getProbabilityArray(variation);

            for (int i = 0; i < amountOfBalances; i++) {

                for (int j = 0; j < DRAGON_TYPE_COUNT; j++) {
                    Dragon dragon;

                    dragon = DragonCreator.dragonTypes[j];

                    dragon.assignStats(Stats.getStats(probabilities));
                    dragons.add(dragon);
                }
                Stats.balanceArray(probabilities);
            }
        }

        return dragons;

    }

    public static void showAverageDragonStats(ArrayList<Dragon> allDragons, int fightCount) {

        ArrayList<Dragon> rubyDragons = getTypeDragons(allDragons, RubyDragon.class);
        ArrayList<Dragon> starDragons = getTypeDragons(allDragons, StarDragon.class);
        ArrayList<Dragon> darknessDragons = getTypeDragons(allDragons, DarknessDragon.class);
        ArrayList<Dragon> greenDragons = getTypeDragons(allDragons, GreenDragon.class);

        System.out.println("Ruby Dragons: " + getAverageWinningStats(rubyDragons, allDragons, fightCount));
        System.out.println("Star Dragons: " + getAverageWinningStats(starDragons, allDragons, fightCount));
        System.out.println("Darkness Dragons: " + getAverageWinningStats(darknessDragons, allDragons, fightCount));
        System.out.println("Green Dragons: " + getAverageWinningStats(greenDragons, allDragons, fightCount));
    }

    public static String getAverageWinningStats(ArrayList<Dragon> typeDragons, ArrayList<Dragon> allDragons, int repeatTimes) {

        double[] total = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        int winCount = 0;
        int fightCount = 0;

        for (int i = 0; i < repeatTimes; i++) {
            for (Dragon testDragon : allDragons) {
                for (Dragon typeDragon : typeDragons) {

                    Dragon winner = getFightWinner(testDragon, typeDragon);
                    testDragon.resetStats();
                    typeDragon.resetStats();

                    if (winner.getClass() == typeDragon.getClass() && testDragon.getClass() != typeDragon.getClass()) {
                        addElements(total, winner.getStats());
                        winCount++;
                    }

                    fightCount++;
                }
            }
        }

        fightCount *= 0.75;


        divideElements(total, winCount);

        String statString = arrayToString(total);

        return statString + " Fight count: " + fightCount + " Win count: " + winCount + " Win percentage: " + winCount * 100.0 / fightCount + "%";

    }

    public static ArrayList<Dragon> getTypeDragons(ArrayList<Dragon> allDragons, Class<?> dragonType) {

        ArrayList<Dragon> typeDragons = new ArrayList<>();

        for (Dragon dragon : allDragons)
            if (dragonType == dragon.getClass())
                typeDragons.add(dragon);

        return typeDragons;
    }

    public static Dragon getFightWinner(Dragon dragon1, Dragon dragon2) {

        while(dragonsNotDead(dragon1, dragon2)) {
            dragon1.simulationCombinedAttack(dragon2);
            dragon2.simulationCombinedAttack(dragon1);
        }

        if (dragon1.getHealth() > 0)
            return dragon1;
        return dragon2;
    }

    public static boolean dragonsNotDead(Dragon dragon1, Dragon dragon2) {
        return dragon1.getHealth() > 0 && dragon2.getHealth() > 0;
    }

    private static String arrayToString(double[] array) {

        String total = "{";

        for (double d : array)
            total += d + " ";

        total += "}";

        return total;
    }

    private static void divideElements(double[] array, int amount) {

        for (int i = 0; i < array.length; i++) {
            array[i] /= (double) amount;
        }

    }

    private static void addElements(double[] array1, int[] array2) {

        for (int i = 0; i < array1.length; i++) {
            array1[i] += array2[i];
        }
    }

    public static void main(String[] args) {

        ArrayList<Dragon> dragons = createDragons(5);

        showAverageDragonStats(dragons, 1);
    }
}
