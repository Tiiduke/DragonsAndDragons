/**
 * Created by Tiit on 11.03.2016.
 */
public class StarDragon extends Dragon implements AssignStats{

    public static String description = "The stardragon yields the might of supernovas! " +
            "He gains more from health and damage stats, but is a lot less likely to crit.";

    public static double spellCastChance = 0.3;

    public static Spell starburst = new Spell("Starburst", 50, 70);
    public static Spell novasMight = new Spell("Nova's Might", 50, 80);
    public static Spell celestialWrath = new Spell("Celestial Wrath", 60, 90);

    public static Spell[] spells = {starburst, novasMight, celestialWrath};

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

    public StarDragon(Dragon dragon) {
        super(dragon);
    }

    @Override
    public void assignStats(int[] stats) {
        health = 10 + stats[0] * 11.5;
        armor = stats[1] * 6.0;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.45);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.60);
        spellDamage = (int) (stats[3] * 0.8);
        critChance = stats[4] / 150.0;
        blockChance = stats[5] / 100.0;
    }

    public String toString() {
        return description + "\n" + "This is the powerful Stardragon " + name;
    }
}
