package se.liu.hanba478henan555;

import java.awt.*;

public class PlaceSuperObjects
{
    private ZinkPanel zinkPanel;

    public PlaceSuperObjects(ZinkPanel zp){
	this.zinkPanel = zp;
    }

    public void placeObjects(){
	zinkPanel.objects[0] = new Key();
	zinkPanel.objects[0].pos = new Point(5,5);
    }
}
