package se.liu.hanba478henan555.entity.entity_enemy;

import se.liu.hanba478henan555.entity.entity_abstract.EntityInput;
import se.liu.hanba478henan555.entity.entity_abstract.EntityType;
import se.liu.hanba478henan555.game_director.game_managers.ZinkPanel;

import java.awt.*;

/**
 * Enemy
 * Will shoot projectile at a random interval
 *
 * for TDDD78 at LIU 2022-03-25
 * 	hanba478@student.liu.se
 * 	henan555@student.liu.se
 */
public class EnemyBlob extends Enemy
{

    private static final int BLOB_HEALTH = 3;

    public EnemyBlob(final ZinkPanel zp, final Point pos) {
	super(zp, pos, EntityType.BLOB);
	setDefaultValues();
    }


    @Override public void setImages() {
	String path = "images/enemyImages/blob";
	up1    = getImage( path + "/up/blob_up_1.png");
	up2    = getImage(path + "/up/blob_up_2.png");
	down1  = getImage(path + "/down/blob_down_1.png");
	down2  = getImage(path + "/down/blob_down_2.png");
	right1 = getImage(path + "/right/blob_right_1.png");
	right2 = getImage(path + "/right/blob_right_2.png");
	left1  = getImage(path + "/left/blob_left_1.png");
	left2  = getImage(path + "/left/blob_left_2.png");
    }

    @Override public void setDefaultValues() {
	setImages();
	setCollisionArea();

	this.collision = true;
	this.spriteFrames = 10;
	this.speed = 2;
	this.moveTick = 0;

	this.maxHealth = BLOB_HEALTH;
	this.health = maxHealth;
	this.ammountOfDamage = 1;

	this.attackCounter = 0;
	this.attackSpeed = 2;
	this.canDelayAttack = true;
	this.attackBound = 1;
	this.canAttack = true;

	this.entityInput = EntityInput.DOWN;
    }

}
