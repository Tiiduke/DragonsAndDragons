/**
 * Created by Tiit on 11.03.2016.
 */
public class StarDragon extends Dragon implements AssignStats{

    public static String description = "The stardragon yields the might of supernovas! " +
            "He gains more from health and damage stats, but is a lot less likely to crit.";

    public StarDragon(String name, double health, double armor,
                      int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                      double blockChance, double critChance) {
        super(name, health, armor,
                attackDamageMinimum, attackDamageMaximum, spellDamage,
                blockChance, critChance);
    }

    public StarDragon() {
        super();
    }

    @Override
    public void assignStats(int[] stats) {
        health = stats[0] * 11.5;
        armor = stats[1] * 6.0;
        attackDamageMinimum = (int) (stats[2] * 0.45);
        attackDamageMaximum = (int) (stats[3] * 0.60);
        spellDamage = (int) (stats[4] * 0.8);
        critChance = stats[5] / 150.0;
        blockChance = stats[6] / 100.0;
    }
}
