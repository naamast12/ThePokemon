public abstract class FirePokemon extends Pokemon {
    public FirePokemon(int currentLife, int maxLife, int currentAttackPoints, int maxAttackPoints, int level) {
        super(currentLife, maxLife, currentAttackPoints, maxAttackPoints, level);
    }

    public void attack(Pokemon enemy) {
        System.out.println("attack");
    }


    public void upgrade() {
        System.out.println("upgrade");

    }

    public void perform2Attacks(Pokemon enemy, Attack firstAttack, Attack secondAttack){
        int damage = firstAttack.getDamage();
        int damage2= secondAttack.getDamage();
        enemy.reduceLife(damage+damage2);
        System.out.println("damage: "+ damage);
    }

    public abstract void performSpecialAbility(Pokemon enemy);
}
