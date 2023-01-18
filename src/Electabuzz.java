import java.util.Scanner;

public class Electabuzz extends ElectricPokemon{
    private Attack thunder;
    private Attack thunderPunch;

    public Electabuzz(){
        super(30,30, (int) (100*0.75),100,1);
        this.thunder = new Attack(60,40,50);
        this.thunderPunch = new Attack(80,50,120);
    }

    public void attack(Pokemon enemy){
        this.setTurnCounter(this.getTurnCounter()+1);
        Scanner scanner = new Scanner(System.in);
        Attack attack = null;
        int userChoice;
        boolean realChoose;
        do {
            System.out.println("Choose an Attack" +
                    "\n1 - for Thunder"+
                    "\n2 - for Thunder Punch"+
                    "\n3 - for kick");
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    realChoose=true;
                    attack = this.thunder;
                    break;
                case 2:
                    realChoose = true;
                    attack = this.thunderPunch;
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
        int currentLevel = this.getLevel();
        switch(currentLevel){
            case 1:
                if(this.getCurrentLife() > 20 && this.getCurrentAttackPoints() >
                        25){
                    this.nextLevel();
                    this.performUpgrade(20,25,35,120);
                    System.out.println("I upgraded to Electivire!");
                }else System.out.println("You can't upgrade");
                break;
            default:
                System.out.println("You reached the maximum level");
        }
    }


}
