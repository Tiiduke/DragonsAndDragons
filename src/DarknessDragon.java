/**
 * Created by Tiit on 11.03.2016.
 */
public class DarknessDragon extends Dragon implements AssignStats {

    double spellCastChance;

    public static Spell dragonUtopia = new Spell("Dragon Utopia", 30, 40);
    public static Spell coverOfDarkness = new Spell("Cover Of Darkness", 35, 45);
    public static Spell endOfRealm = new Spell("End of Realm", 50, 50);

    public DarknessDragon(String name, double health, double armor,
                          int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                          double blockChance, double critChance) {
        super(name, health, armor,
                attackDamageMinimum, attackDamageMaximum, spellDamage,
                blockChance, critChance);
        this.spells = new Spell[] {dragonUtopia, coverOfDarkness, endOfRealm};
        this.spellCastChance = 0.05;
    }

    public DarknessDragon() {
        this.spells = new Spell[] {dragonUtopia, coverOfDarkness, endOfRealm};
        this.spellCastChance = 0.05;
    }

    public DarknessDragon(Dragon dragon) {
        super(dragon);
        this.spells = new Spell[] {dragonUtopia, coverOfDarkness, endOfRealm};
        this.spellCastChance = 0.05;
    }

    @Override
    public void assignStats(int[] stats) {
        this.stats = stats;
        health = 100 + stats[0] * 13.5;
        armor = stats[1] * 9.0;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.55);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.70);
        spellDamage = (int) (stats[3] * 1.5);
        critChance = stats[4] / 250.0;
        blockChance = stats[5] * 0.9 / 200.0;
    }
    @Override
    public void resetStats() {
        assignStats(stats);
    }
}
