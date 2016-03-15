import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Tiit on 10.03.2016.
 */
public class Game {
    public static void main(String[] args) throws Exception {

        Dragon playerDragon = DragonCreator.getPlayerDragon();
        Dragon opponentDragon = DragonCreator.defaultDragons[(int) (Math.random() * DragonCreator.defaultDragons.length)];

        Scanner scan = new Scanner(System.in);


        while (BattleSimulator.dragonsNotDead(playerDragon, opponentDragon)) {
            playerDragon.playerAttack(opponentDragon);
            System.out.println(opponentDragon.getName() + " has " + opponentDragon.getHealth() + " health remaining!");

            opponentDragon.simulationAttackWithOutput(playerDragon);
            System.out.println(playerDragon.getName() + " has " + playerDragon.getHealth() + " health remaining!");
        }
    }
}
