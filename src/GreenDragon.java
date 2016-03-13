/**
 * Created by Tiit on 10.03.2016.
 */
public class GreenDragon extends Dragon implements AssignStats{

    public static String description = "The Green dragon benefits more from health and armor, " +
            "but is less likely to crit or block attacks";

    public static double spellCastChance = 0.25;

    public static Spell centrausCall = new Spell("Centaur's Call", 25, 35);
    public static Spell powerOfTheWild = new Spell("Power of the Wild", 10, 50);
    public static Spell emeraldBreath = new Spell("Emerald Breath", 40, 40);

    public static Spell[] spells = {centrausCall, powerOfTheWild, emeraldBreath};

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

    public GreenDragon(Dragon dragon) {
        super(dragon);
    }

    @Override
    public void assignStats(int[] stats) {
        health = 10 + stats[0] * 12;
        armor = stats[1] * 8.5;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.4);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.6);
        spellDamage = (int) (stats[3] * 0.75);
        critChance = stats[4] / 125.0;
        blockChance = stats[5] / 125.0;
    }

    public String toString() {
        return description + "\n" + "This is the powerful Green dragon " + name;
    }

}
