/**
 * Created by Tiit on 10.03.2016.
 */
public class RubyDragon extends Dragon implements AssignStats{

    double spellCastChance;

    public static Spell innervate = new Spell("Innervate", 20, 25);
    public static Spell wisdomOfTheAncients = new Spell("Wisdom of the Ancients", 25, 30);
    public static Spell fieryGaze = new Spell("Fiery Gaze", 15, 30);

    public RubyDragon(String name, double health, double armor,
                      int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                      double blockChance, double critChance) {
        super(name, health, armor,
                attackDamageMinimum, attackDamageMaximum, spellDamage,
                blockChance, critChance);
        this.spells = new Spell[] {innervate, wisdomOfTheAncients, fieryGaze};
        this.spellCastChance = 0.40;
    }

    public RubyDragon() {
        this.spells = new Spell[] {innervate, wisdomOfTheAncients, fieryGaze};
        this.spellCastChance = 0.40;
    }

    public RubyDragon(Dragon dragon) {
        super(dragon);
        this.spells = new Spell[] {innervate, wisdomOfTheAncients, fieryGaze};
        this.spellCastChance = 0.40;
    }

    @Override
    public void assignStats(int[] stats) {
        this.stats = stats;
        health = 100 + stats[0] * 9.0;
        armor = stats[1] * 6.5;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.3);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.5);
        spellDamage = (int) (stats[3] * 1.25);
        critChance = stats[4] / 100.0;
        blockChance = stats[5] / 100.0;
    }
    @Override
    public void resetStats() {
        assignStats(stats);
    }

}