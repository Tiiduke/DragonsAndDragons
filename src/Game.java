import java.util.Scanner;

/**
 * Created by Tiit on 10.03.2016.
 */
public class Game {

    public static int getSpellInt(Dragon dragon) throws Exception{

        Scanner scan = new Scanner(System.in);

        System.out.println("Valige loits mida soovite kasutada!");
        System.out.println("Iga loitsu tugevusele liitub " + dragon.spellDamage + " tugevust!");
        System.out.println(dragon.spellsToString());

        int spellNumber = Integer.parseInt(scan.nextLine());
        System.out.println("Valisite loitsu " + dragon.spells[spellNumber - 1]);

        return spellNumber - 1;
    }

    public static void main(String[] args) throws Exception{

        Dragon opponentDragon = new Dragon(DragonCreator.dragonTypes[(int) (Math.random() * DragonCreator.dragonTypes.length)]);
        Dragon playerDragon = DragonCreator.getPlayerDragon();

        Scanner scan = new Scanner(System.in);

        System.out.println("Lahing on alanud!");
        Thread.sleep(2000);
        System.out.println("Teie lohe võitleb tugeva vastasega!");
        System.out.println(opponentDragon);
        Thread.sleep(4000);
        System.out.println();

        while (BattleSimulator.dragonsNotDead(playerDragon, opponentDragon)) {
            if (Math.random() < playerDragon.spellCastChance) {

                System.out.println(playerDragon.getName() + " has attacked " + opponentDragon.getName());

                int spellNumber = getSpellInt(playerDragon);

                playerDragon.playerCastspell(spellNumber, opponentDragon);
            }
            else {
                playerDragon.playerMeleeAttack(opponentDragon);
            }

            System.out.println(opponentDragon.getName() + " has " + opponentDragon.getHealth() + " health remaining!");
            Thread.sleep(2500);
            System.out.println();

            opponentDragon.simulationCombinedAttackWithOutput(playerDragon);

            System.out.println(playerDragon.getName() + " has " + playerDragon.getHealth() + " health remaining!");
            Thread.sleep(2500);
            System.out.println();
        }

        if (playerDragon.health > 0 && opponentDragon.health <= 0) {
            System.out.println("Teie lohe " + playerDragon.getName() + " võitis!!!");
        }

        else if (opponentDragon.health > 0 && playerDragon.health <= 0) {
            System.out.println("See kord võitis vastaslohe " + opponentDragon.getName() + "!");
        }
        else
            System.out.println("Mõlemad lohed surid väärikalt pingelises lahingus!");

        scan.close();
    }
}
