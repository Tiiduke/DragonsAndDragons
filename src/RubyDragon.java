/**
 * Created by Tiit on 10.03.2016.
 */
public class RubyDragon extends Dragon implements AssignStats{

    public static Spell innervate = new Spell("Innervate", 20, 30);
    public static Spell wisdomOfTheAncients = new Spell("Wisdom of the Ancients", 25, 35);
    public static Spell fieryGaze = new Spell("Fiery Gaze", 25, 45);

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
        this.spellCastChance = 0.40;
        health = 120 + stats[0] * 7.5;
        armor = stats[1] * 5.0;
        attackDamageMinimum = 1 + (int) (stats[2] * 0.3);
        attackDamageMaximum = 1 + (int) (stats[2] * 0.45);
        spellDamage = (int) (stats[3] * 1.25);
        critChance = stats[4] / 125.0;
        blockChance = stats[5] * 0.9 / 150.0;
    }

    @Override
    public void resetStats() {
        assignStats(stats);
    }
}