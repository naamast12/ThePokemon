import java.util.Scanner;

public class Blitzle extends ElectricPokemon{
    private Attack flop;
    private Attack zapKick;

    public Blitzle(){
        super(90,90, (int) (35*0.75),35,1);
        this.flop = new Attack(20,20,25);
        this.zapKick = new Attack(30,30,35);
    }
    public void upgrade() {
        int currentLevel = this.getLevel();
        switch(currentLevel){
            case 1:
                if(this.getCurrentLife() > 20 && this.getCurrentAttackPoints() >
                        25){
                    this.nextLevel();
                    this.performUpgrade(20,25,100,50);
                    System.out.println("I upgraded to Zebstrika!");
                }else System.out.println("You can't upgrade");
                break;
            default:
                System.out.println("You reached the maximum level");
        }
    }

    public void attack(Pokemon enemy){
        this.setTurnCounter(this.getTurnCounter()+1);
        Scanner scanner = new Scanner(System.in);
        Attack attack = null;
        int userChoice;
        boolean realChoose;
        do {
            System.out.println("Choose an Attack" +
                    "\n1 - for Flop"+
                    "\n2 - for Zap Kick"+
                    "\n3 - for kick");
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    realChoose=true;
                    attack = this.flop;
                    break;
                case 2:
                    realChoose=true;
                    attack = this.zapKick;
                    break;
                case 3:
                    realChoose=true;
                    kick(enemy);
                default:
                    realChoose=false;
                    System.out.println("There is no such option");
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
