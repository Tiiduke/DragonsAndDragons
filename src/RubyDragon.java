/**
 * Created by Tiit on 10.03.2016.
 */
public class RubyDragon extends Dragon implements AssignStats{

    public static String description =
            "This is the red dragon, who yields the power of Ruby! " +
                    "They benefit a lot from spell damage, but benefit less from health and armor and attack damage.";

    public static double spellCastChance = 0.45;

    public static Spell innervate = new Spell("Innervate", 40, 50);
    public static Spell wisdomOfTheAncients = new Spell("Wisdom of the Ancients", 50, 60);
    public static Spell fieryGaze = new Spell("Fiery Gaze", 30, 60);

    public static Spell[] spells = {innervate, wisdomOfTheAncients, fieryGaze};

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

    public RubyDragon(Dragon dragon) {
        super(dragon);
    }

    @Override
    public void assignStats(int[] stats) {
        health = 10 + stats[0] * 9;
        armor = stats[1] * 6.5;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.3);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.5);
        spellDamage = (int) (stats[3] * 1.25);
        critChance = stats[4] / 100.0;
        blockChance = stats[5] / 100.0;
    }

    public String toString() {
        return description + "\n" + "This is the powerful Ruby dragon " + name;
    }

}
