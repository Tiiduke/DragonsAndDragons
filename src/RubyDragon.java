/**
 * Created by Tiit on 10.03.2016.
 */
public class RubyDragon extends Dragon implements AssignStats{

    public static String description =
            "This is the red dragon, who yields the power of Ruby! " +
                    "They benefit a lot from spell damage, but benefit less from health and armor and attack damage.";

    public static double spellCastChance = 0.45;

    public RubyDragon(String name, double health, double armor,
                      int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                      double blockChance, double critChance) {
        super(name, health, armor,
                attackDamageMinimum, attackDamageMaximum, spellDamage,
                blockChance, critChance);
    }

    public RubyDragon() {
        super();
    }

    @Override
    public void assignStats(int[] stats) {
        health = stats[0] * 9;
        armor = stats[1] * 6.5;
        attackDamageMinimum = (int) (stats[2] * 0.3);
        attackDamageMaximum = (int) (stats[3] * 0.5);
        spellDamage = (int) (stats[4] * 1.25);
        critChance = stats[5] / 100.0;
        blockChance = stats[6] / 100.0;
    }

}
