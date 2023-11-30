package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY; // we are using 2 different x and y
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2; // the images in player folder
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea; // This is the middle of the char, makes sure it doesn't collide with tiles
    public boolean collisionOn = false;

}
