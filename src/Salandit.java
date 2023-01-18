import java.util.Random;
import java.util.Scanner;

public class Salandit extends FirePokemon{
    private Attack liveCoal;
    private Attack fireClaws;
    private Attack[] attacks;
    public Salandit(){
        super(100,100, (int) (60*0.75),60,1);
        this.liveCoal = new Attack(10,0,25);
        this.fireClaws = new Attack(25,0,50);
        this.attacks = new Attack[]{liveCoal,fireClaws};

    }
    public void upgrade() {
        int currentLevel = this.getLevel();
        switch(currentLevel){
            case 1:
                if(this.getCurrentLife() > 20 && this.getCurrentAttackPoints() >
                        25){
                    this.nextLevel();
                    this.performUpgrade(20,25,160,80);
                    System.out.println("I upgraded to Salazzle!");
                }else System.out.println("You can't upgrade");
                break;
            default:
                System.out.println("You reached the maximum level");
        }
    }


    public void performSpecialAbility(Pokemon enemy) {
        this.setCurrentAttackPoints(0);
        this.setCurrentLife((int) (this.getCurrentLife() * 0.5));
        Random random = new Random();
        int firstRand = random.nextInt(2);
        int secondRand = random.nextInt(2);
        this.perform2Attacks(enemy,attacks[firstRand],attacks[secondRand]);

    }

    public void attack(Pokemon enemy){
        this.setTurnCounter(this.getTurnCounter()+1);
        Scanner scanner = new Scanner(System.in);
        Attack attack = null;
        int userChoice;
        boolean realChoose;
        do {
            System.out.println("Choose an Attack" +
                    "\n1 - for Live Coal"+
                    "\n2 - for Fire Claws"+
                    "\n3 - for kick");
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    realChoose=true;
                    attack = this.liveCoal;
                    break;
                case 2:
                    realChoose=true;
                    attack = this.fireClaws;
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


}


