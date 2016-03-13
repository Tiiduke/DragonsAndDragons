/**
 * Created by Tiit on 11.03.2016.
 */
public class StarDragon extends Dragon implements AssignStats{

    double spellCastChance;

    public static Spell starburst = new Spell("Starburst", 25, 35);
    public static Spell novasMight = new Spell("Nova's Might", 25, 40);
    public static Spell celestialWrath = new Spell("Celestial Wrath", 30, 45);

    public StarDragon(String name, double health, double armor,
                      int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                      double blockChance, double critChance) {
        super(name, health, armor,
                attackDamageMinimum, attackDamageMaximum, spellDamage,
                blockChance, critChance);
        this.spells = new Spell[] {starburst, novasMight, celestialWrath};
        this.spellCastChance = 0.3;
    }

    public StarDragon() {
        this.spells = new Spell[] {starburst, novasMight, celestialWrath};
        this.spellCastChance = 0.3;
    }

    public StarDragon(Dragon dragon) {
        super(dragon);
        this.spells = new Spell[] {starburst, novasMight, celestialWrath};
        this.spellCastChance = 0.3;
    }

    @Override
    public void assignStats(int[] stats) {
        this.stats = stats;
        health = 100 + stats[0] * 11.5;
        armor = stats[1] * 6.0;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.45);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.60);
        spellDamage = (int) (stats[3] * 0.8);
        critChance = stats[4] / 150.0;
        blockChance = stats[5] / 100.0;
    }
    @Override
    public void resetStats() {
        assignStats(stats);
    }

}