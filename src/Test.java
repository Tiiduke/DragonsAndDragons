import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Tiit on 10.03.2016.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        DraakoniLooja draakoniLooja = new DraakoniLooja();
        Dragon[] bots = draakoniLooja.getBots();
        Dragon meieDragon = draakoniLooja.getPlayer();
        int a = (int)(Math.random()*5);

        while (bots[a].getHealth() > 0 && meieDragon.getHealth() > 0) {

            for (int i = 1; i < 3; i++) {
                bots[a].attack(meieDragon);
                if (meieDragon.getHealth() < 0) {
                    System.out.println("\n" + bots[a].getName() + " made one last crushing blow and won");
                    return;
                } else
                    Thread.sleep(2000);
                System.out.println(meieDragon.getName() + " has " + meieDragon.getHealth() + " health after " + bots[a].getName() + " attack.");

                meieDragon.attack(bots[a]);
                if (bots[a].getHealth() < 0) {
                    System.out.println("\n" + meieDragon.getName() + " made one last crushing blow and won");
                    return;
                } else
                    Thread.sleep(2000);
                System.out.println(bots[a].getName() + " has " + bots[a].getHealth() + " health after " + meieDragon.getName() + " attack.");}

            Scanner sc = new Scanner(System.in);
            System.out.println("\nChoose a spell to use : "+"\n"+ meieDragon.spells[0]+"\n"+meieDragon.spells[1]+"\n"+meieDragon.spells[2]);
            String valik = sc.nextLine();

            if (valik.equals("1")) {
                meieDragon.cast_Kindelspell(meieDragon.spells[0] , bots[a]);
            } else if (valik.equals("2")) {
                meieDragon.cast_Kindelspell(meieDragon.spells[1] , bots[a]);
            } else if (valik.equals("3")) {
                meieDragon.cast_Kindelspell(meieDragon.spells[2] , bots[a]);
            }

            if (bots[a].getHealth() < 0) {
                System.out.println("\n" + meieDragon.getName() + " won");
                return;
            } else if (meieDragon.getHealth() < 0) {
                System.out.println("\n" + bots[a].getName() + " won");
                return;
            }

        }
    }
}