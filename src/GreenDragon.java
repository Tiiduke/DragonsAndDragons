/**
 * Created by Tiit on 10.03.2016.
 */
public class GreenDragon extends Dragon implements AssignStats{

    public static String description = "The Green dragon benefits more from health and armor, " +
            "but is less likely to crit or block attacks";

    public GreenDragon(String name, double health, double armor,
                       int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                       double blockChance, double critChance) {
        super(name, health, armor,
                attackDamageMinimum, attackDamageMaximum, spellDamage,
                blockChance, critChance);
    }

    @Override
    public void assignStats(int healthStat, int armorStat,
                            int damageStat, int spellDamageStat,
                            int critChanceStat, int blockChanceStat) {
        health = healthStat * 12;
        armor = armorStat * 8.5;
        attackDamageMinimum = (int) (damageStat * 0.4);
        attackDamageMaximum = (int) (damageStat * 0.6);
        spellDamage = (int) (spellDamageStat * 0.75);
        critChance = critChanceStat / 125.0;
        blockChance = blockChanceStat / 125.0;
    }

    public String toString() {
        return description + "\n" + "This is the powerful Green dragon " + name;
    }

}
