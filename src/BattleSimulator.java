import java.util.ArrayList;

/**
 * Created by Tiit on 10.03.2016.
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

                    switch (j) {
                        case 0: dragon = new GreenDragon(); break;
                        case 1: dragon = new DarknessDragon(); break;
                        case 2: dragon = new StarDragon(); break;
                        case 3: dragon = new RubyDragon(); break;
                        default: dragon = new Dragon(); break;
                    }

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

                    if (winner.getClass() == typeDragon.getClass()) {
                        addElements(total, winner.stats);
                        winCount++;
                    }

                    fightCount++;
                }
            }
        }


        divideElements(total, winCount);

        String statString = arrayToString(total);

        winCount -= fightCount / 4;
        fightCount = fightCount * 3 / 4;

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
            dragon1.attack(dragon2);
            dragon2.attack(dragon1);
        }

        if (dragon1.health > 0)
            return dragon1;
        return dragon2;
    }

    public static boolean dragonsNotDead(Dragon dragon1, Dragon dragon2) {
        return dragon1.health > 0 && dragon2.health > 0;
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
            array[i] /= amount;
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
