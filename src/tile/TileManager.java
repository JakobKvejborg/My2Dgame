package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];


    // constructor:
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10]; // number of different types of tiles
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/world01.txt");
    }

    public void getTileImage() {

        try {

            // grass1
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tilesImages/grass01.png"));
            // wall
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tilesImages/wall.png"));
            tile[1].collision = true; // decides whether the tile has collision or not
            // water1
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tilesImages/water01.png"));
            tile[2].collision = true;
            // earth
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tilesImages/earth.png"));
            // tree
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tilesImages/tree.png"));
            tile[4].collision = true;
            // grass0
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tilesImages/grass00.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" "); //maybe String.split(" "); maybe String.split(String);

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++; // maybe set row = 0;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }

    //__________________________________________________________________________________________________________________
    // DRAWING TILES
    public void draw(Graphics2D g2) {
        // Hardcoding tiles:
        // Top five tiles from left to right - this works when the below "while" loop is not active
//        g2.drawImage(tile[1].image, 0, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 96, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 144, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 0, gp.tileSize, gp.tileSize, null);
//        // Second top row from left to right
//        g2.drawImage(tile[0].image, 0, 48, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 48, 48, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 48, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[2].image, 144, 48, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 192, 48, gp.tileSize, gp.tileSize, null);
//        // Third row etc.
//        g2.drawImage(tile[1].image, 0, 96, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 48, 96, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 96, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 144, 96, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 96, gp.tileSize, gp.tileSize, null);
//        // Fourth
//        g2.drawImage(tile[0].image, 0, 144, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 48, 144, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 144, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 144, 144, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 192, 144, gp.tileSize, gp.tileSize, null);

        // Automated tiledrawing:
        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow]; // NOTICE these two are only working if switched around for some reason

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            // Rendering:
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            worldCol++;


            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }

    }

    //__________________________________________________________________________________________________________________

}
