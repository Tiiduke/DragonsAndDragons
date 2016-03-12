/**
 * Created by Tiit on 9.03.2016.
 */
public class Spell {

    String name;
    int minimumDamage;
    int maximumDamage;

    public Spell(String name, int minimumDamage, int maximumDamage) {
        this.name = name;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
    }

    public int netDamage() {
        return (int) (Math.random() * (maximumDamage - minimumDamage)) + minimumDamage;
    }

    public String toString() {
        return name + " does " + minimumDamage + " to " + maximumDamage + " damage!";
    }
}
