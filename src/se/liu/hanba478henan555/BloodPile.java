package se.liu.hanba478henan555;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class BloodPile extends AbstractObject
{

    public BloodPile(final ZinkPanel zp) {
	super(zp, ObjectType.BLOOD_PILE);
    }

    @Override public void whenCollided(final AbstractEntity entity) {

    }

    @Override public void setCollisionArea() {
        Rectangle rectangle = new Rectangle(pos.x, pos.y, zinkPanel.getTileSize(), zinkPanel.getTileSize());
        collisionArea = rectangle;

    }

    @Override public void readImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("./enemy/dead.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}