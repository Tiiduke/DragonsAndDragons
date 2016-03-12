/**
 * Created by Tiit on 11.03.2016.
 */
public class DarknessDragon extends Dragon implements AssignStats {

    public static String description = "The darkness dragon draws power from the fear of his foes! " +
            "He is a strong melee fighter, but has a small chance of casting a powerful spell!";

    public static double spellCastChance = 0.05;

    public static Spell dragonUtopia = new Spell("Dragon Utopia", 60, 80);
    public static Spell coverOfDarkness = new Spell("Cover Of Darkness", 70, 90);
    public static Spell endOfRealm = new Spell("End of Realm", 100, 100);

    public static Spell[] spells = {dragonUtopia, coverOfDarkness, endOfRealm};

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
        health = 10 + stats[0] * 13.5;
        armor = stats[1] * 9.0;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.55);
        attackDamageMaximum = 3 + (int) (stats[3] * 0.70);
        spellDamage = (int) (stats[4] * 1.5);
        critChance = stats[5] / 250.0;
        blockChance = stats[6] / 200.0;
    }

    public String toString() {
        return description + "\n" + "This is the powerful Darkness dragon " + name;
    }

}
