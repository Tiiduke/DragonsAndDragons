/**
 * Created by Tiit on 10.03.2016.
 */
public class GreenDragon extends Dragon implements AssignStats{

    public static Spell centaursCall = new Spell("Centaur's Call", 15, 25);
    public static Spell powerOfTheWild = new Spell("Power of the Wild", 5, 25);
    public static Spell emeraldBreath = new Spell("Emerald Breath", 20, 20);

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
        this.spellCastChance = 0.25;
        health = 125 + stats[0] * 13.0;
        armor = stats[1] * 9.5;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.45);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.65);
        spellDamage = (int) (stats[3] * 0.80);
        critChance = stats[4] / 125.0;
        blockChance = stats[5] * 0.9 / 125.0;
    }

    @Override
    public void resetStats() {
        assignStats(stats);
    }
}