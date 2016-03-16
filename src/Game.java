import java.util.Scanner;
import java.util.concurrent.Exchanger;

/**
 * Created by Tiit on 10.03.2016.
 */
public class Game {
    public static void main(String[] args) throws Exception{

        Dragon opponentDragon = DragonCreator.defaultDragons[(int) (Math.random() * DragonCreator.defaultDragons.length)];
        Dragon playerDragon = DragonCreator.getPlayerDragon();

        Scanner scan = new Scanner(System.in);

        System.out.println("Lahing on alanud!");
        System.out.println("Teie lohe võitleb tugeva vastasega!");
        System.out.println(opponentDragon);
        System.out.println();

        while (BattleSimulator.dragonsNotDead(playerDragon, opponentDragon)) {
            if (Math.random() < playerDragon.spellCastChance) {

                System.out.println(playerDragon.spellsToString());
                System.out.println("Valige loits mida soovite kasutada!");

                String spellString = scan.nextLine();
                System.out.print("");
                int spellNumber = Integer.parseInt(spellString);

                playerDragon.playerCastspell(spellNumber, opponentDragon);
            }
            else
                playerDragon.playerMeleeAttack(opponentDragon);

            System.out.println(opponentDragon.getName() + " has " + opponentDragon.getHealth() + " health remaining!");
            System.out.println();

            opponentDragon.simulationCombinedAttackWithOutput(playerDragon);

            System.out.println(playerDragon.getName() + " has " + playerDragon.getHealth() + " health remaining!");
            System.out.println();
        }
        scan.close();
    }
}
