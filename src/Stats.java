/**
 * Created by Tiit on 13.03.2016.
 */
public class Stats {

    //Korrutab array suurimaid elemente 0.8ga ning jaotab kõigile elementidele ülejäägi suurimatest elementidest
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

    //Annab tõenäosuste arrayle vastava draakonistatistikute array
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
}
