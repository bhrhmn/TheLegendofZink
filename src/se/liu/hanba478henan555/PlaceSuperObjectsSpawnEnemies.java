package se.liu.hanba478henan555;

import java.awt.*;

/**
 * Places objects and enemies on frame
 */
public class PlaceSuperObjectsSpawnEnemies
{
    private ZinkPanel zinkPanel;

    public PlaceSuperObjectsSpawnEnemies(ZinkPanel zp){
	this.zinkPanel = zp;
    }

    public void placeDoor(int x, int y){
	Door door = new Door(zinkPanel);
	door.setValues(x,y);
	zinkPanel.getGameObjects().add(door);
    }

    private void placeKey(int x, int y){
	Key key = new Key(zinkPanel);
	key.setValues(x,y);
	zinkPanel.getGameObjects().add(key);
    }

    private void spawnEnemy(int x, int y){
	Enemy en = new Enemy(zinkPanel, zinkPanel.getCollisionHandler(),new Point(x, y));
	zinkPanel.getEnemyList().add(en);
    }

    public void placeObjects(){

	placeDoor(6,4);
	placeKey(1,1);
	placeKey(10,10);
	placeKey(10,21);
	placeKey(46,1);

	placeDoor(42,1);

    }

    public void spawnEnemies(){

	spawnEnemy(6,20);
	spawnEnemy(7,20);
	spawnEnemy(8,20);
	spawnEnemy(9,20);

    }


}