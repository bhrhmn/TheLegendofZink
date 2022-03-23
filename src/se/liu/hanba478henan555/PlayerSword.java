package se.liu.hanba478henan555;


import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

public class PlayerSword extends AbstractObject
{

    private int lifeSpan = 0;
    private boolean onGround;

    private Map<ObjectType, Integer> swordDamage = new EnumMap<>(Map.ofEntries(
            Map.entry(ObjectType.PLAYER_SWORD_BAD, 1),
            Map.entry(ObjectType.PLAYER_SWORD_GOOD, 2)));


    protected PlayerSword(final ZinkPanel zp, final ObjectType gameObject, boolean onGround) {
        super(zp, gameObject);
        this.onGround = onGround;

        if (!onGround){zinkPanel.sound.playSoundEffect(5);}
    }

    public void setValues(int x, int y,  EntityInput ei) {
        moreValues(x,y,ei);
    }

    @Override public void draw(Graphics2D g2){
        if (!onGround) {
            lifeSpan++;
            if (lifeSpan >= zinkPanel.getPlayer().getAttackSpeed()) {
                zinkPanel.getGameObjects().remove(this);
                return;
            }
        }

        g2.drawImage(image, pos.x, pos.y, zinkPanel.getTileSize(), zinkPanel.getTileSize(), null);
    }

    @Override public void readImage() {
        try {
            switch (gameObject){
                case PLAYER_SWORD_BAD -> {image = ImageIO.read(getClass().getResourceAsStream("./player/sword_weak.png"));}
                case PLAYER_SWORD_GOOD -> {image = ImageIO.read(getClass().getResourceAsStream("./player/sword_strong.png"));}
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override public void whenCollided(AbstractEntity entity) {
        if (onGround) {
            if (entity.getType().equals(EntityType.PLAYER)) {
                zinkPanel.getGameObjects().remove(this);
                zinkPanel.getPlayer().getInventory().add(this);
            }
            return;
        }
        if (!entity.getType().equals(EntityType.ENEMY)){return;}
        entity.takeDamage(swordDamage.get(gameObject));
    }

    @Override public void setCollisionArea() {
        this.collisionArea = new Rectangle(this.pos.x, this.pos.y,
                                           zinkPanel.getTileSize(), zinkPanel.getTileSize());
    }



}