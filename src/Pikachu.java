import java.util.Scanner;

public  class Pikachu extends ElectricPokemon{
    private Attack quickAttack;
    private Attack electroBall;
    private Attack electricSurfer;

    public Pikachu(){
        super(40,40, (int) (30*0.75),30,1);
        this.quickAttack = new Attack(5,10,10);
        this.electroBall = new Attack(10,30,40);
        this.electricSurfer = new Attack(60,20,120);
    }

    public void attack(Pokemon enemy){
        this.setTurnCounter(this.getTurnCounter()+1);
        Scanner scanner = new Scanner(System.in);
        Attack attack = null;
        int userChoice;
        boolean realChoose;
        do {
            System.out.println("Choose an Attack " +
                    "\n1 - for Quick Attack "+
                    "\n2 - for Electro Ball "+
                    "\n3 - for Electric Surfer"+
                    "\n4 - for kick");
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    realChoose=true;
                    attack = this.quickAttack;
                    break;
                case 2:
                    realChoose=true;
                    attack = this.electroBall;
                    break;
                case 3:
                    realChoose=true;
                    attack = this.electricSurfer;
                case 4:
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
        if((attack == 3)&&(this.getLevel() == 3 )) valid = true;
        return valid;
    }

    public void upgrade() {
        int currentLevel = this.getLevel();
        switch(currentLevel){
            case 1:
                if(this.getCurrentLife() > 20 && this.getCurrentAttackPoints() >
                        25){
                    this.nextLevel();
                    this.performUpgrade(20,25,50,40);
                    System.out.println("I upgraded to Pikachu!");
                }else System.out.println("You can't upgrade");
                break;
            case 2:
                if(this.getCurrentLife() > 30 && this.getCurrentAttackPoints() >
                        40){
                    this.nextLevel();
                    this.performUpgrade(30,40,160,80);
                    System.out.println("I upgraded to Raichu!");
                }else System.out.println("You can't upgrade");
                break;
            default:
                System.out.println("You reached the maximum level");
        }
    }
}



