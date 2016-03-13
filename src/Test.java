/**
 * Created by Tiit on 10.03.2016.
 */
public class Test {
    public static void main(String[] args) {
        Dragon dragon1 = new GreenDragon();
        Dragon dragon2 = new GreenDragon(dragon1);

        dragon1.name = "Tiit";

        System.out.println(dragon2.spellCastChance);

    }
}
