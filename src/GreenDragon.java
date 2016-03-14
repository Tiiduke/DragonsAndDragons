/**
 * Created by Tiit on 10.03.2016.
 */
public class GreenDragon extends Dragon implements AssignStats{

    double spellCastChance;

    public static Spell centaursCall = new Spell("Centaur's Call", 15, 25);
    public static Spell powerOfTheWild = new Spell("Power of the Wild", 5, 25);
    public static Spell emeraldBreath = new Spell("Emerald Breath", 20, 20);

    public GreenDragon(String name, double health, double armor,
                       int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                       double blockChance, double critChance) {
        super(name, health, armor,
                attackDamageMinimum, attackDamageMaximum, spellDamage,
                blockChance, critChance);
        this.spells = new Spell[] {centaursCall, powerOfTheWild, emeraldBreath};
        this.spellCastChance = 0.25;
    }

    public GreenDragon() {
        this.spells = new Spell[] {centaursCall, powerOfTheWild, emeraldBreath};
        this.spellCastChance = 0.25;
    }

    public GreenDragon(Dragon dragon) {
        super(dragon);
        this.spells = new Spell[] {centaursCall, powerOfTheWild, emeraldBreath};
        this.spellCastChance = 0.25;
    }

    @Override
    public void assignStats(int[] stats) {
        this.stats = stats;
        health = 100 + stats[0] * 12.0;
        armor = stats[1] * 8.5;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.4);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.6);
        spellDamage = (int) (stats[3] * 0.75);
        critChance = stats[4] / 125.0;
        blockChance = stats[5] * 0.9 / 125.0;
    }
    @Override
    public void resetStats() {
        assignStats(stats);
    }
}