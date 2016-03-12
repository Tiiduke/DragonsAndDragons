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

    public static void changeToNextVariation(boolean[] variation) {
        int lastMemberIndex = getLastMember(variation);

        if (lastMemberIndex != variation.length - 1) {
            variation[lastMemberIndex + 1] = true;
            variation[lastMemberIndex] = false;
        }


    }

    private static int getLastMember(boolean[] variation) {

        for (int i = variation.length - 1; i > 0; i--) {
            if (variation[i])
                return i;
        }

        return 0;
    }

    private static boolean allMembersInEnd(boolean[] variation) {
        int changeCount = 0;

        boolean state = false;

        for (boolean bool : variation) {
            if (bool != state) {
                changeCount += 1;
                state = bool;
            }

            if (changeCount > 1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        boolean[] a = {true, false, true, true};

        System.out.println(getLastMember(a));
        System.out.println(allMembersInEnd(a));
    }
}
