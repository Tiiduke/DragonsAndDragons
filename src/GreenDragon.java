/**
 * Created by Tiit on 10.03.2016.
 */
public class GreenDragon extends Dragon implements AssignStats{

    public static String description = "The Green dragon benefits more from health and armor, " +
            "but is less likely to crit or block attacks";

    public static double spellCastChance = 0.25;

    public GreenDragon(String name, double health, double armor,
                       int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                       double blockChance, double critChance) {
        super(name, health, armor,
                attackDamageMinimum, attackDamageMaximum, spellDamage,
                blockChance, critChance);
    }

    public GreenDragon() {
        super();
    }

    @Override
    public void assignStats(int[] stats) {
        health = stats[0] * 12;
        armor = stats[1] * 8.5;
        attackDamageMinimum = (int) (stats[2] * 0.4);
        attackDamageMaximum = (int) (stats[3] * 0.6);
        spellDamage = (int) (stats[4] * 0.75);
        critChance = stats[5] / 125.0;
        blockChance = stats[6] / 125.0;
    }

    public String toString() {
        return description + "\n" + "This is the powerful Green dragon " + name;
    }

}
