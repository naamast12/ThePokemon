public abstract class ElectricPokemon extends Pokemon{


    public ElectricPokemon(int currentLife, int maxLife, int currentAttackPoints, int maxAttackPoints, int level) {
        super(currentLife, maxLife, currentAttackPoints, maxAttackPoints, level);
    }

    public void attack(Pokemon enemy) {
        //nothing happens
    }

    public void upgrade() {
        //nothing happens
    }

    public void performSpecialAbility(Pokemon enemy){
        if(this.isSpecialAbility()){
            this.setSpecialAbility(false);
            this.setCurrentLife(this.getMaxLife());
            this.setCurrentAttackPoints(this.getMaxAttackPoints());
            System.out.println("done!");
        } else System.out.println("You already used your special ability");
    }
}
