/**
 * Created by Tiit on 10.03.2016.
 */
public class Test {
    public static void main(String[] args) {
        Dragon dragon1 = new RubyDragon();
        Dragon dragon2 = new Dragon(dragon1);

        dragon1.name = "Tiit";

        for (Spell spell : dragon2.spells)
            System.out.println(spell);

    }
}
