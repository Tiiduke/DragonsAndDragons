/**
 * Created by Tiit on 11.03.2016.
 */
public class StarDragon extends Dragon implements AssignStats{

    public static Spell starburst = new Spell("Starburst", 20, 35);
    public static Spell novasMight = new Spell("Nova's Might", 25, 40);
    public static Spell celestialWrath = new Spell("Celestial Wrath", 25, 45);

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
        this.spellCastChance = 0.3;
        health = 70 + stats[0] * 10.5;
        armor = stats[1] * 5.5;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.35);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.65);
        spellDamage = (int) (stats[3] * 0.8);
        critChance = stats[4] / 175.0;
        blockChance = stats[5] * 0.9 / 100.0;
    }
    @Override
    public void resetStats() {
        assignStats(stats);
    }

}