import java.util.Random;
import java.util.Scanner;

public class Charmander extends FirePokemon {
    private Attack scratch;
    private Attack flameTail;
    private Attack fieryBlast;
    private Attack[] attacks;

    public Charmander(){
        super(80,80, (int) (40*0.75),40,1);
        this.scratch = new Attack(15,25,30);
        this.flameTail = new Attack(40,30,50);
        this.fieryBlast = new Attack(50,30,50);
        this.attacks = new Attack[]{scratch, flameTail, fieryBlast};
    }

    public void attack(Pokemon enemy){
        this.setTurnCounter(this.getTurnCounter()+1);
        Scanner scanner = new Scanner(System.in);
        Attack attack = null;
        int userChoice;
        boolean realChoose;
        do {
            System.out.println("Choose an Attack" +
                    "\n1 - for Scrath"+
                    "\n2 - for Flame Tail" +
                    "\n3 - for Fiery Blast"+
                    "\n4 - for kick");
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    realChoose=true;
                    attack = this.scratch;
                    break;
                case 2:
                    realChoose=true;
                    attack = this.flameTail;
                    break;
                case 3:
                    realChoose=true;
                    attack = this.fieryBlast;
                    break;
                case 4:
                    realChoose=true;
                    kick(enemy);
                default:
                    realChoose=false;
                    System.out.println("There is no such option");
            }

        } while(!isValidAttack(userChoice)&&!realChoose);
        this.performAttack(enemy , attack);
    }

    public void upgrade() {
        int currentLevel = this.getLevel();
        switch(currentLevel){
            case 1:
                if(this.getCurrentLife() > 20 && this.getCurrentAttackPoints() >
                        25){
                    this.nextLevel();
                    this.performUpgrade(20,25,90,60);
                    System.out.println("I upgraded to Charmeleon!");
                }else System.out.println("You can't upgrade");
                break;
            case 2:
                if(this.getCurrentLife() > 30 && this.getCurrentAttackPoints() >
                        40){
                    this.nextLevel();
                    this.performUpgrade(30,40,130,80);
                    System.out.println("I upgraded to Charizard!");
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
        int firstRand = random.nextInt(0,3);
        int secondRand = random.nextInt(0,3);
        this.perform2Attacks(enemy,attacks[firstRand],attacks[secondRand]);
    }

    public boolean isValidAttack(int attack){
        boolean valid = false;
        if (attack == 1) valid= true;
        if((attack == 2) && (this.getLevel() >=2)) valid = true;
        if((attack == 3)&&(this.getLevel() == 3)) valid = true;
        if(!valid){
            System.out.println("You can't perform this attack");
        }
        return valid;
    }


}

