/**
 * Created by Tiit on 10.03.2016.
 */
public class BattleSimulator {

    public static boolean dragonsNotDead(Dragon dragon1, Dragon dragon2) {
        return dragon1.health > 0 && dragon2.health > 0;
    }

    public static void balanceArray(double[] probabilities, int balanceCount) {

        for (int j = 0; j < balanceCount; j++) {
            double max = max(probabilities);
            double sum = 0.0;

            //Lowers big columns
            for (int i = 0; i < probabilities.length; i++) {
                if (probabilities[i] == max)
                {
                    sum += probabilities[i] * 0.1;
                    probabilities[i] *= 0.9;
                }
            }

            //Spreads difference
            for (int i = 0; i < probabilities.length; i++) {
                probabilities[i] += sum / probabilities.length;
            }
        }
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

        boolean[] a = {true, false, false, true, true, false, false, true};
        boolean[] b = {false, false, false, false, false};

        //System.out.println(getLastMember(a));
        //System.out.println(allTruesInEnd(a));
        //System.out.println(getTrueCountInEnd(a));
        while (!BooleanVariation.checkForAllTrues(b)) {
            BooleanVariation.changeToNextVariation(b);
            System.out.println(BooleanVariation.toString(b));
        }

    }
}
