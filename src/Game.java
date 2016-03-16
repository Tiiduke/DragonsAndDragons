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

        Dragon opponentDragon = DragonCreator.defaultDragons[(int) (Math.random() * DragonCreator.defaultDragons.length)];
        Dragon playerDragon = DragonCreator.getPlayerDragon();

        Scanner scan = new Scanner(System.in);

        System.out.println("Lahing on alanud!");
        System.out.println("Teie lohe võitleb tugeva vastasega!");
        System.out.println(opponentDragon);
        System.out.println();

        while (BattleSimulator.dragonsNotDead(playerDragon, opponentDragon)) {
            if (Math.random() < playerDragon.spellCastChance) {

                System.out.println(playerDragon.name + " has attacked " + opponentDragon.name);

                int spellNumber = getSpellInt(playerDragon);

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
