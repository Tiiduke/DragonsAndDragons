/**
 * Created by Tiit on 9.03.2016.
 */
public class Dragon implements AssignStats{

    String name;

    double health;
    double armor;

    int attackDamageMinimum;
    int attackDamageMaximum;
    int spellDamage;

    double blockChance;
    double critChance;

    int[] stats;
    Spell[] spells;

    double spellCastChance;

    public Spell flameBreath = new Spell("Flame Breath", 15, 25);
    public Spell poisonBreath = new Spell("Poison Breath", 20, 25);
    public Spell kappa = new Spell("Kappa", 30, 69);


    public Dragon(String name, double health, double armor,
                  int attackDamageMinimum, int attackDamageMaximum, int spellDamage,
                  double blockChance, double critChance) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.attackDamageMinimum = attackDamageMinimum;
        this.attackDamageMaximum = attackDamageMaximum;
        this.spellDamage = spellDamage;
        this.blockChance = blockChance;
        this.critChance = critChance;
        this.spells = new Spell[] {flameBreath, poisonBreath, kappa};
        this.spellCastChance = 0.33;
    }

    public Dragon(Dragon dragon) {
        this.name = dragon.name;
        this.health = dragon.health;
        this.armor = dragon.armor;
        this.attackDamageMinimum = dragon.attackDamageMinimum;
        this.attackDamageMaximum = dragon.attackDamageMaximum;
        this.spellDamage = dragon.spellDamage;
        this.blockChance = dragon.blockChance;
        this.critChance = dragon.critChance;
        this.spells = dragon.spells;
        this.spellCastChance = dragon.spellCastChance;
    }


    public Dragon() {
        this.spells = new Spell[] {flameBreath, poisonBreath, kappa};
        this.spellCastChance = 0.33;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public int getAttackDamageMinimum() {
        return attackDamageMinimum;
    }

    public void setAttackDamageMinimum(int attackDamageMinimum) {
        this.attackDamageMinimum = attackDamageMinimum;
    }

    public int getAttackDamageMaximum() {
        return attackDamageMaximum;
    }

    public void setAttackDamageMaximum(int attackDamageMaximum) {
        this.attackDamageMaximum = attackDamageMaximum;
    }

    public int getSpellDamage() {
        return spellDamage;
    }

    public void setSpellDamage(int spellDamage) {
        this.spellDamage = spellDamage;
    }

    public double getBlockChance() {
        return blockChance;
    }

    public void setBlockChance(double blockChance) {
        this.blockChance = blockChance;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public void simulationAttack(Dragon target) {
        if (Math.random() > target.blockChance)
            if (Math.random() < this.spellCastChance)
            {
                int random = (int) (Math.random() * this.spells.length);
                Spell spell = this.spells[random];

                target.health -= (spell.netDamage() + this.spellDamage);
            }
            else
            {
                double damage = armorDamage(target);

                if (Math.random() < critChance)
                    target.health -= 2 * damage;
                else
                    target.health -= damage;
            }
    }

    private int netDamage() {
        return (int) (Math.random() * (attackDamageMaximum - attackDamageMinimum) + attackDamageMinimum);
    }

    private double armorDamage(Dragon target) {

        int damageAmount = netDamage();

        if (target.armor != 0 && damageAmount < target.armor * 4) {
            target.armor -= 0.25 * damageAmount;
            return 0.5 * damageAmount;
        }
        else if (target.armor != 0) {
            target.armor = 0;
            return 0.5 * damageAmount;
        }
        else
            return netDamage();
    }

    public void cast_spell(Dragon target) {
        Spell spell = this.spells[(int) (Math.random() * this.spells.length)];

        if (Math.random() > target.blockChance) {
            int damage = spell.netDamage() + spellDamage;
            target.health -= damage;
            System.out.println(name + " casted " + spell.name + "!");
            System.out.println(name + " did " + damage + " damage to " + target.name + "!");
        }
        else
            System.out.println(target.name + " has blocked the spell!");
    }

    public void assignStats(int[] stats) {
        this.stats = stats;
        health = 10 + stats[0] * 10;
        armor = stats[1] * 7.5;
        attackDamageMinimum = 3 + (int) (stats[2] * 0.4);
        attackDamageMaximum = 3 + (int) (stats[2] * 0.6);
        spellDamage = (int) (stats[3] * 0.75);
        critChance = stats[4] / 100.0;
        blockChance = stats[5] / 100.0;
    }

    //Usable only after assignStats has been used at least once
    public void resetStats() {
        assignStats(stats);
    }

    public String toString() {

        //String stats = health + " " + armor + " " + attackDamageMinimum + " " + attackDamageMaximum + " " + spellDamage + " " + blockChance + " " + critChance;
        String stats = "";
        for (int i = 0; i < this.stats.length; i++)
            stats += this.stats[i] + " ";

        return stats + name + this.spells[0];
    }
}
