import java.util.ArrayList;

/**
 * Created by Tiit on 10.03.2016.
 */
public class BattleSimulator {

    public static boolean dragonsNotDead(Dragon dragon1, Dragon dragon2) {
        return dragon1.health > 0 && dragon2.health > 0;
    }

    public static ArrayList<Dragon> createDragons(int amountOfBalances) {

        Dragon[] dragonTypes = {new GreenDragon(), new DarknessDragon(), new RubyDragon(), new StarDragon()};

        boolean[] variation = new boolean[6];

        ArrayList<Dragon> dragons= new ArrayList<>();

        while(!BooleanVariation.checkForAllTrues(variation)) {
            BooleanVariation.changeToNextVariation(variation);

            double[] probabilities = BooleanVariation.getProbabilityArray(variation);

            for (int i = 0; i < amountOfBalances; i++) {

                for (int j = 0; j < dragonTypes.length; j++) {
                    Dragon dragon;

                    switch (j) {
                        case 0: dragon = new GreenDragon(); break;
                        case 1: dragon = new DarknessDragon(); break;
                        case 2: dragon = new StarDragon(); break;
                        case 3: dragon = new RubyDragon(); break;
                        default: dragon = new Dragon(); break;
                    }

                    dragon.assignStats(getStats(probabilities));
                    dragons.add(dragon);
                }

                balanceArray(probabilities);
            }
        }

        return dragons;

    }

    public static void balanceArray(double[] probabilities) {

        double sum = 0.0;
        double max = max(probabilities);

        for (int i = 0; i < probabilities.length; i++) {
            if (probabilities[i] == max)
            {
                sum += probabilities[i] * 0.2;
                probabilities[i] = 0.8 * probabilities[i];
            }
        }

        double difference = sum / probabilities.length;
        //Spreads difference
        for (int i = 0; i < probabilities.length; i++) {
            probabilities[i] = probabilities[i] + difference;
        }
    }

    public static int[] getStats(double[] probabilities) {

        int[] stats = new int[probabilities.length];

        for (int i = 0; i < 100; i++) {
            stats[getProbabilisticInteger(probabilities)]++;
        }

        return stats;
    }

    private static int getProbabilisticInteger(double[] probabilities) {
        double sum = 0.0;
        double random = Math.random();

        for (int i = 0; i < probabilities.length; i++) {
            sum += probabilities[i];

            if (sum > random)
                return i;
        }

        return probabilities.length - 1;
    }

    private static double max(double[] list) {
        double max = Double.NEGATIVE_INFINITY;

        for (double number : list) {
            if (number > max)
                max = number;
        }

        return max;
    }

    public static void main(String[] args) {

        boolean[] a = {false, true, false, false, false, false, true};
        boolean[] b = {false, false, false, false, false, false};

        double[] c = BooleanVariation.getProbabilityArray(a);

        ArrayList<Dragon> dragons = createDragons(5);


        System.out.println(dragons.size());

    }
}
