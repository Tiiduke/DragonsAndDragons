import java.util.Scanner;

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

    public Dragon() {}

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

    public void simulationCombinedAttack(Dragon target) {
        if (Math.random() > target.blockChance)
            if (Math.random() < this.spellCastChance)
            {
                int random = (int) (Math.random() * this.spells.length);
                Spell spell = this.spells[random];

                simulationCastSpell(spell, target);
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

    public void simulationCastSpell(Spell spell, Dragon target) {
        if (Math.random() > target.blockChance) {
            int damage = spell.netDamage() + spellDamage;
            target.health -= damage;
        }
    }

    public void simulationCombinedAttackWithOutput(Dragon target) {

        System.out.println(name + " has attacked " + target.name);

        if (Math.random() > target.blockChance) {
            if (Math.random() < this.spellCastChance) {

                Spell spell = spells[(int) (Math.random() * spells.length)];
                castSpellWithOutput(spell, target);
            }
            else {

                double damage = armorDamage(target);

                if (Math.random() < critChance) {
                    target.health -= 2 * damage;
                    System.out.println(name + " did critical damage worth " + damage * 2 + " to " + target.name + "!");
                }
                else {
                    target.health -= damage;
                    System.out.println(name + " did " + damage + " damage to " + target.name + "!");
                }
            }
        }

        else
            System.out.println(target.name + " blocked the attack!");
    }

    public void playerMeleeAttack(Dragon target) {

        System.out.print(name + " has attacked " + target.name);

        if (Math.random() > target.blockChance) {
            double damage = armorDamage(target);

            if (Math.random() < critChance) {
                target.health -= 2 * damage;
                System.out.println("\n" + name + " did critical damage worth " + damage * 2 + " to " + target.name + "!");
            } else {
                target.health -= damage;
                System.out.println("\n" + name + " did " + damage + " damage to " + target.name + "!");
            }
        }
        else
            System.out.println("\n" + target.name + " blocked the attack!");
    }

    public void playerCastspell(int spellNumber, Dragon target) {

        Spell spell = spells[spellNumber];

        castSpellWithOutput(spell, target);
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

    private void castSpellWithOutput(Spell spell, Dragon target) {

        System.out.println(name + " casted " + spell.name + "!");

        if (Math.random() > target.blockChance) {
            int damage = spell.netDamage() + spellDamage;
            target.health -= damage;
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
        String description = "Draakonil " + name + " on ";
        String stats = health + " elu, " + armor + " rüüd, " + attackDamageMinimum + "-" + attackDamageMaximum + " ründejõudu, " +
                spellDamage + " loitsimisjõudu, " + blockChance * 100 + "% võimalus blokeerida rünnakuid, " +
                critChance * 100 + "% võimalus teha eriti tugev rünnak ja " + spellCastChance * 100 + "% võimalus kasutada loitsu!";


        return description + stats;
    }

    public String spellsToString() {

        String spellString = "";

        for (int i = 0; i < spells.length; i++) {
            spellString += (i + 1) + ". " + spells[i] + "\n";
        }

        return spellString;
    }
}
