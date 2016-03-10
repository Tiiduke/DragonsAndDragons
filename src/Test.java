/**
 * Created by Tiit on 10.03.2016.
 */
public class Test {
    public static void main(String[] args) {
        GreenDragon dragon1 = new GreenDragon("Tiit", 100, 50, 10, 12, 10, 0.2, 0.3);
        Dragon dragon2 = new Dragon("Teet", 100, 40, 8, 14, 12, 0.2, 0.3);
        System.out.println(dragon1.toString());
        dragon2.attack(dragon1);
    }
}
