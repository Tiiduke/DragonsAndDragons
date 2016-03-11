/**
 * Created by Tiit on 10.03.2016.
 */
public class RubyDragon extends Dragon implements AssignStats{

    public static String description =
            "This is the red dragon, who yields the power of Ruby! " +
                    "They benefit a lot from spell damage, but benefit less from health and armor and attack damage.";

    public static double spellCastChance = 0.4;

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

    public void assignStats(int healthStat, int armorStat,
                            int damageStat, int spellDamageStat,
                            int critChanceStat, int blockChanceStat) {
        health = healthStat * 9;
        armor = armorStat * 6.5;
        attackDamageMinimum = (int) (damageStat * 0.3);
        attackDamageMaximum = (int) (damageStat * 0.5);
        spellDamage = (int) (spellDamageStat * 1.25);
        critChance = critChanceStat / 100.0;
        blockChance = blockChanceStat / 100.0;
    }

}
