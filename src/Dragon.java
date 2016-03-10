/**
 * Created by Tiit on 9.03.2016.
 */
public class Dragon implements AssignStats{

    public static String description =
            "The regular dragon is a mighty being, whose power is not to be taken lightly!";
    String name;

    double health;
    double armor;

    int attackDamageMinimum;
    int attackDamageMaximum;
    int spellDamage;

    double blockChance;
    double critChance;

    public static double spellCastChance = 0.33;

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
    }

    public Dragon() {
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

    public void attack(Dragon target) {
        if (Math.random() > target.blockChance) {
            double damage = armorDamage(target);

            if (Math.random() < critChance)
                target.health -= 2 * damage;
            else
                target.health -= damage;

            System.out.println(name + " did " + damage + " damage to " + target.name + "!");
        }

        else
            System.out.println(target.name + "blocked the attack!");
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

    public void cast_spell(Spell spell, Dragon target) {

        if (Math.random() > target.blockChance) {
            int damage = spell.netDamage() + spellDamage;
            target.health -= damage;
            System.out.println(name + " casted " + spell.name + "!");
            System.out.println(name + " did " + damage + " damage to " + target.name + "!");
        }
        else
            System.out.println(target.name + " has blocked the spell!");
    }

    public void assignStats(int healthStat, int armorStat,
                            int damageStat, int spellDamageStat,
                            int critChanceStat, int blockChanceStat) {
        health = healthStat * 10;
        armor = armorStat * 7.5;
        attackDamageMinimum = (int) (damageStat * 0.4);
        attackDamageMaximum = (int) (damageStat * 0.6);
        spellDamage = (int) (spellDamageStat * 0.75);
        critChance = critChanceStat / 100.0;
        blockChance = blockChanceStat / 100.0;
    }

    public String toString() {
        return description + "\n" + "This is the mighty Dragon " + name;
    }


}
