package se.liu.hanba478henan555.entity.enemy;

import se.liu.hanba478henan555.entity.entity_enum.EntityInput;
import se.liu.hanba478henan555.entity.entity_enum.EntityType;
import se.liu.hanba478henan555.game_director.game_managers.ZinkPanel;
import se.liu.hanba478henan555.objects.abstract_game_object.ObjectType;

import java.awt.*;
import java.io.File;

/**
 * Enemy
 * Can shoot projectiles
 */
public class EnemyBlob extends Enemy
{

    private static final int BLOB_HEALTH = 3;

    public EnemyBlob(final ZinkPanel zp, final Point pos) {
	super(zp, pos, EntityType.BLOB);
	setDefaultValues();
    }

    @Override public void attack() {
	if(checkCanAttack()){
	    return;
	}
	attackCounter = 0;
	shootProjectile(ObjectType.ENEMY_BOW, entityInput);
    }

    @Override public void setImages() {
	String fs = File.separator;
	up1    = setImage("images"+fs+"enemyImages"+fs+"blob"+fs+"up"+fs+"blob_up_1.png");
	up2    = setImage("images"+fs+"enemyImages"+fs+"blob"+fs+"up"+fs+"blob_up_2.png");
	down1  = setImage("images"+fs+"enemyImages"+fs+"blob"+fs+"down"+fs+"blob_down_1.png");
	down2  = setImage("images"+fs+"enemyImages"+fs+"blob"+fs+"down"+fs+"blob_down_2.png");
	right1 = setImage("images"+fs+"enemyImages"+fs+"blob"+fs+"right"+fs+"blob_right_1.png");
	right2 = setImage("images"+fs+"enemyImages"+fs+"blob"+fs+"right"+fs+"blob_right_2.png");
	left1  = setImage("images"+fs+"enemyImages"+fs+"blob"+fs+"left"+fs+"blob_left_1.png");
	left2  = setImage("images"+fs+"enemyImages"+fs+"blob"+fs+"left"+fs+"blob_left_2.png");
    }

    @Override public void setDefaultValues() {
	setImages();

	this.collisionArea = new Rectangle();
	collisionArea.width = tileSize*2/3;
	collisionArea.height = tileSize*2/3;

	this.collision = true;
	this.spriteFrames = 10;
	this.speed = 2;
	this.moveTick = 0;

	this.maxHealth = BLOB_HEALTH;
	this.health = maxHealth;
	this.ammountOfDamage = 1;

	this.attackCounter = 0;
	this.attackSpeed = 2;
	this.canAttack = true;
	this.attackBound = 1;

	this.entityInput = EntityInput.DOWN;
    }

    @Override public void update() {
	changeCanAttack();
	attackRandom(attackBound);
	setCollisionAreaRelativePos();
	collisionHandler.objectCollision(this);
	changeImage();
	spriteCounter++; moveTick++;
	moveRandom();
	moveEntity(entityInput,1,speed);
    }


    @Override public void draw(final Graphics2D g2) {
	if (damaged) {
	    damageAnimation(g2);
	}
	g2.drawImage(currentImage, pos.x, pos.y, tileSize, tileSize ,null);
	setAlphaComposite(g2, 1.0f);
    }

    @Override public void heal() {

    }
}
