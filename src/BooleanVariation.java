/**
 * Created by Tiit on 12.03.2016.
 */
public abstract class BooleanVariation {

    public static void changeToNextVariation(boolean[] variation) {
        int lastTrueIndex = getLastMember(variation);
        if (checkForAllFalse(variation)) {
            variation[0] = true;
        }
        //Kui viimane liige on false, siis liigutab viimast true'd edasi
        else if (lastTrueIndex != variation.length - 1) {
            variation[lastTrueIndex + 1] = true;
            variation[lastTrueIndex] = false;
        }
        //Kui ainult viimased liikmed on true, siis liigutab lõpust kõik true'd tagasi ja liidab ühe true
        else if (allTruesInEnd(variation)) {
            int amount = getTrueCountInEnd(variation) + 1;

            for (int i = 0; i < variation.length; i++) {
                if (i < amount)
                    variation[i] = true;
                else
                    variation[i] = false;
            }
        }

        else
            moveTruesFromEnd(variation);


    }

    private static int getLastMember(boolean[] variation) {

        for (int i = variation.length - 1; i > 0; i--) {
            if (variation[i])
                return i;
        }

        return 0;
    }

    private static boolean allTruesInEnd(boolean[] variation) {
        int changeCount = 0;

        boolean state = false;

        for (boolean bool : variation)
        {
            if (bool != state)
            {
                changeCount += 1;
                state = bool;
            }

            if (changeCount > 1)
                return false;
        }
        return true;
    }

    public static int getMemberCount(boolean[] variation) {
        int memberCount = 0;

        for (boolean item : variation) {
            if (item)
                memberCount++;
        }

        return memberCount;
    }

    private static int getTrueCountInEnd(boolean[] variation) {

        int endCount = 0;

        for (int i = variation.length - 1; i > 0; i--) {
            if(variation[i])
                endCount++;
            else
                break;
        }

        return endCount;

    }

    private static int getMemberBeforeEndTrues(boolean[] variation) {
        int endAmount = getTrueCountInEnd(variation);

        for (int i = variation.length - 1 - endAmount; i > 0; i--) {
            if(variation[i])
                return i;
        }

        return 0;
    }

    private static void moveTruesFromEnd(boolean[] variation) {
        int endamount = getTrueCountInEnd(variation);
        int moveBackTo = getMemberBeforeEndTrues(variation);
        int len = variation.length;

        variation[moveBackTo] = false;

        for (int i = len - endamount - 1; i < len; i++) {
            variation[i] = false;
        }

        for (int i = moveBackTo + 1; i < moveBackTo + 2 + endamount; i++) {
            variation[i] = true;
        }
    }

    public static boolean checkForAllTrues(boolean[] variation) {

        for(boolean bool : variation) {
            if (!bool)
                return false;
        }

        return true;
    }

    public static boolean checkForAllFalse(boolean[] variation) {

        for (boolean bool : variation)
            if (bool)
                return false;

        return true;
    }

    public static String toString(boolean[] variation) {

        String string = "{";

        for (boolean bool : variation)
            string += bool + ", ";

        return string + "}";
    }
}
