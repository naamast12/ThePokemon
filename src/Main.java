import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Pokemon choosePlayer(Pokemon[] pokemons){
        Random random = new Random();
        int randomPokemonNumber = random.nextInt(6);
        return pokemons[randomPokemonNumber];
    }
    public static void performTurn(Pokemon player1 , Pokemon player2){
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        boolean realChoose;
        do {
            System.out.println("Choose an option: " +
                    "\n1 - Attack" +
                    "\n2 - waiting" +
                    "\n3 - Evolve" +
                    "\n4 - Special Ability ");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    player1.attack(player2);
                    realChoose=true;
                    break;
                case 2:
                    player1.skipTurn();
                    realChoose=true;
                    break;
                case 3:
                    player1.upgrade();
                    realChoose=true;
                    break;
                case 4:
                    realChoose=true;
                    player1.performSpecialAbility(player2);
                    break;
                default:
                    realChoose=false;
                    System.out.println("There is no such option");
                    break;
            }
        }while (!realChoose);
    }



    public static void gameMenu(Pokemon player1, Pokemon player2) {

        System.out.println("player 1: " + player1.toString());
        System.out.println("player 2: " + player2.toString());
        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("Player 1 turn: ");
            performTurn(player1, player2);
            System.out.println("player 1: " + player1.toString());
            System.out.println("player 2: " + player2.toString());
            System.out.println("Player 2 turn: ");
            performTurn(player2, player1);
            System.out.println("player 1: " + player1.toString());
            System.out.println("player 2: " + player2.toString());
        }
        if(player1.isAlive()) System.out.println("Player 1 wins!!");
        else System.out.println("Player 2 wins!!");
    }

    public static void main(String[] args) {

        Pokemon[] pokemons = new Pokemon[6];
        pokemons = generatePokemons();
        Pokemon player1 = choosePlayer(pokemons);
        Pokemon player2 = choosePlayer(pokemons);

        gameMenu(player1, player2);
    }

    private static Pokemon[] generatePokemons() {
        Charmander charmander = new Charmander();
        Salandit salandit = new Salandit();
        Moltres moltres = new Moltres();
        Pikachu pikachu = new Pikachu();
        Blitzle blitzle = new Blitzle();
        Electabuzz electabuzz = new Electabuzz();
        Pokemon[] pokemons= new Pokemon[]{charmander,salandit,moltres,pikachu,blitzle,electabuzz};
        return pokemons;
    }
}