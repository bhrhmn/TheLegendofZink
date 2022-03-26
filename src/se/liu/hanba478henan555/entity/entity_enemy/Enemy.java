package se.liu.hanba478henan555.entity.entity_enemy;

import se.liu.hanba478henan555.entity.entity_abstract.AbstractEntity;
import se.liu.hanba478henan555.entity.entity_abstract.EntityInput;
import se.liu.hanba478henan555.entity.entity_abstract.EntityType;
import se.liu.hanba478henan555.game_director.game_managers.ZinkPanel;
import se.liu.hanba478henan555.objects.abstract_game_object.ObjectType;
import se.liu.hanba478henan555.objects.life.BloodPile;

import java.awt.*;

/**
 * Adds functions for entities with EntityType Enemy
 *
 * for TDDD78 at LIU 2022-03-25
 * 	hanba478@student.liu.se
 * 	henan555@student.liu.se
 */
public abstract class Enemy extends AbstractEntity
{

    protected EntityType enemyType;
    protected boolean canAttack;

    protected Enemy(final ZinkPanel zp, final Point pos, EntityType enemyType) {
	super(zp, pos, EntityType.ENEMY);
	this.enemyType = enemyType;
    }

    @Override protected void die(){
	zinkPanel.sound.playSoundEffect(3);
	zinkPanel.getEnemyList().remove(this);
	BloodPile bloodPile = new BloodPile(zinkPanel);
	bloodPile.setValues(this.pos.x/ zinkPanel.getTileSize(), this.pos.y/ zinkPanel.getTileSize());
	zinkPanel.getGameObjects().add(bloodPile);
    }

    @Override public void update() {
	changeCanAttack();
	attackRandom(attackBound);
	updateEntity();
	changeImage();
    }

    @Override public void attack() {
	if (!canAttack) return;
	if(!isCanDelayAttack()){
	    return;
	}
	attackCounter = 0;
	shootProjectile(ObjectType.ENEMY_BOW, entityInput);
    }

    protected boolean isCanDelayAttack() {
	return canDelayAttack;
    }

    protected void moveRandom(){
	if (moveTick == zinkPanel.getFPS() * 2){
	    int i = RANDOM.nextInt(4);
	    if(i == 0){
		entityInput = EntityInput.UP;
	    }
	    else if(i == 1){
		entityInput = EntityInput.LEFT;
	    }
	    else if(i == 2){
		entityInput = EntityInput.RIGHT;
	    }
	    else {
		entityInput = EntityInput.DOWN;
	    }
	    moveTick = 0;
	}
    }

    protected void updateEntity(){
	updateCollision();
	spriteCounter++; moveTick++;
	moveRandom();
	moveEntity(entityInput,1,speed);
    }

    public EntityType getEnemyType() {
	return enemyType;
    }
}
