/**
 * Created by Tiit on 11.03.2016.
 */
public class DarknessDragon extends Dragon implements AssignStats {

    public static String description = "The darkness dragon draws power from the fear of his foes! " +
            "He is a strong melee fighter, but has a small chance of casting a powerful spell!";

    public static double spellCastChance = 0.1;

    public DarknessDragon(String name, double health, double armor,
                          int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                          double blockChance, double critChance) {
        super(name, health, armor,
                attackDamageMinimum, attackDamageMaximum, spellDamage,
                blockChance, critChance);
    }

    public DarknessDragon() {
    }

    @Override
    public void assignStats(int[] stats) {
        health = stats[0] * 13.5;
        armor = stats[1] * 9.0;
        attackDamageMinimum = (int) (stats[2] * 0.55);
        attackDamageMaximum = (int) (stats[3] * 0.70);
        spellDamage = (int) (stats[4] * 1.5);
        critChance = stats[5] / 250.0;
        blockChance = stats[6] / 200.0;
    }

}
