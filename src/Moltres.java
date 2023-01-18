import java.util.Random;
import java.util.Scanner;

public class Moltres extends FirePokemon{
    private Attack assistingHeater;
    private Attack fireWing;
    private Attack[] attacks;

    public Moltres(){
        super(100,100, (int) (60*0.75),60,1);
        this.assistingHeater = new Attack(30,10,60);
        this.fireWing = new Attack(30,30,30);
        this.attacks = new Attack[]{assistingHeater,fireWing};
    }

    public void attack(Pokemon enemy){
        this.setTurnCounter(this.getTurnCounter()+1);
        Scanner scanner = new Scanner(System.in);
        Attack attack = null;
        int userChoice;
        boolean realChoose;
        do {
            System.out.println("Choose an Attack" +
                    "\n1 - for Assisting Heater"+
                    "\n2 - for Fire Wing"+
                    "\n3 - for kick");
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    realChoose=true;
                    attack = this.assistingHeater;
                    break;
                case 2:
                    realChoose=true;
                    attack = this.fireWing;
                    break;
                case 3:
                    realChoose=true;
                    kick(enemy);
                default:
                    realChoose=false;
                    System.out.println("There is no such option");
                    break;
            }

        } while(!isValidAttack(userChoice)&&!realChoose);
        this.performAttack(enemy , attack);
    }

    public boolean isValidAttack(int attack){
        boolean valid = false;
        if (attack == 1) valid= true;
        if((attack == 2) && (this.getLevel() >=2)) valid = true;
        return valid;
    }

    public void upgrade() {
        System.out.println("That Pokemon can not evolve");
    }

    public void performSpecialAbility(Pokemon enemy) {
        this.setCurrentAttackPoints(0);
        this.setCurrentLife((int) (this.getCurrentLife() * 0.5));
        Random random = new Random();
        int firstRand = random.nextInt(2);
        int secondRand = random.nextInt(2);
        this.perform2Attacks(enemy,attacks[firstRand],attacks[secondRand]);

    }


}
