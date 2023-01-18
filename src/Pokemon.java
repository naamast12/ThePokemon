import java.util.Random;

public abstract class Pokemon {

    private int currentLife;
    private int maxLife;
    private int currentAttackPoints;
    private int maxAttackPoints;
    private int level;
    private boolean tripleAttack;
    private int turnCounter;
    private int tripleAttackTurn;

    private boolean specialAbility;

    public Pokemon(int currentLife, int maxLife, int currentAttackPoints, int maxAttackPoints, int level) {
        this.currentLife = currentLife;
        this.maxLife = maxLife;
        this.currentAttackPoints = currentAttackPoints;
        this.maxAttackPoints = maxAttackPoints;
        this.level = level;
        this.tripleAttack = false;
        this.tripleAttackTurn = 0;
        this.turnCounter = 0;
        this.specialAbility = true;
    }

    protected int getMaxLife() {
        return maxLife;
    }

    protected int getMaxAttackPoints() {
        return maxAttackPoints;
    }

    protected boolean isSpecialAbility() {
        return specialAbility;
    }

    protected void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    protected void setCurrentAttackPoints(int currentAttackPoints) {
        this.currentAttackPoints = currentAttackPoints;
    }

    protected void setSpecialAbility(boolean specielAbility) {
        this.specialAbility = specielAbility;
    }

    public abstract void attack(Pokemon enemy);

    protected boolean hasEnoughAttackPoints (Attack attack){
        boolean enough = false;
        if (this.currentAttackPoints >= attack.getCost()) {
            enough = true;

        }
        return enough;
    }

    protected void reduceAttackPoints (int amount){
        this.currentAttackPoints -= amount;
    }

    protected boolean isTripleAttack() {
        return tripleAttack;
    }


    protected void reduceLife(int amount){
        this.currentLife -= amount;
    }

    protected int getCurrentAttackPoints(){
        return this.currentAttackPoints;
    }


    protected int getLevel() {
        return level;
    }


    protected void nextLevel(){ this.level++;}

    protected void addLife(){
        Random random = new Random();
        int randomLifeAdd = random.nextInt(30 - 5)+ 5;
        if(this.currentLife + randomLifeAdd > this.maxLife)
            this.currentLife = this.maxLife;
        else this.currentLife += randomLifeAdd;
        System.out.println("You received "+randomLifeAdd+" extra life points");
    }

    protected void addAttackPoints(){
        Random random = new Random();
        int randomAttackAdd = random.nextInt(40 );
        if(this.currentAttackPoints + randomAttackAdd > this.maxAttackPoints)
            this.currentAttackPoints = this.maxAttackPoints;
        else this.currentAttackPoints += randomAttackAdd;
        System.out.println("You received "+randomAttackAdd+" extra attack points");
    }

    protected boolean isAlive(){
        boolean alive = true;
        if(this.currentLife <= 0) {
            alive = false;
        }
        return alive;
    }
    protected int getCurrentLife(){return  this.currentLife;}

    protected void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    protected int getTurnCounter() {
        return this.turnCounter;
    }

    protected int getTripleAttackTurn() {
        return this.tripleAttackTurn;
    }
    public void kick(Pokemon enemy){
        if (enemy.getCurrentLife()>=0)
            enemy.reduceLife(2);
    }

    public void skipTurn(){
        Random random = new Random();
        int choice = random.nextInt(4)+1;
        turnCounter++;
        switch (choice){
            case 1:
                this.addLife();
                break;
            case 2:
                this.addAttackPoints();
                break;
            case 3:
                this.tripleAttack = true;
                this.tripleAttackTurn = this.turnCounter;
                System.out.println("You got triple attack power in the next queue");
                break;
        }
    }

    public void performAttack(Pokemon enemy , Attack attack){
        if(hasEnoughAttackPoints(attack)) {
            reduceAttackPoints(attack.getCost());
            int damage = attack.getDamage();
            if(this.isTripleAttack() &&(this.getTurnCounter() - this.getTripleAttackTurn() == 1))
            {
                damage = damage * 3;
                enemy.reduceLife(damage);
            } else {
                enemy.reduceLife(damage);
            }
            System.out.println("damage: "+ damage);
        } else {
            System.out.println("You do not have enough attack points");
        }
    }



    public abstract void upgrade();


    public void performUpgrade(int lifeAmount, int attackAmount, int newMaxLife, int newMaxAttack){
        this.reduceLife(lifeAmount);
        this.reduceAttackPoints(attackAmount);
        this.maxLife = newMaxLife;
        this.maxAttackPoints = newMaxAttack;
    }

    public String toString(){
        return "Life ("+this.currentLife +" / "+ this.maxLife + " )" +
                " , Attack Points: ("+ this.currentAttackPoints+ " / "+this.maxAttackPoints+")";
    }

    public abstract void performSpecialAbility(Pokemon player2);

}

