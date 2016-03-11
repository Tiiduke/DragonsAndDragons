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
    public void assignStats(int healthStat, int armorStat,
                            int damageStat, int spellDamageStat,
                            int critChanceStat, int blockChanceStat) {
        health = healthStat * 11.5;
        armor = armorStat * 6.0;
        attackDamageMinimum = (int) (damageStat * 0.45);
        attackDamageMaximum = (int) (damageStat * 0.60);
        spellDamage = (int) (spellDamageStat * 0.8);
        critChance = critChanceStat / 150.0;
        blockChance = blockChanceStat / 100.0;
    }


}
