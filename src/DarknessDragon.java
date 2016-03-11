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
    public void assignStats(int healthStat, int armorStat,
                            int damageStat, int spellDamageStat,
                            int critChanceStat, int blockChanceStat) {
        health = healthStat * 13.5;
        armor = armorStat * 9.0;
        attackDamageMinimum = (int) (damageStat * 0.55);
        attackDamageMaximum = (int) (damageStat * 0.70);
        spellDamage = (int) (spellDamageStat * 1.5);
        critChance = critChanceStat / 250.0;
        blockChance = blockChanceStat / 200.0;
    }

}
