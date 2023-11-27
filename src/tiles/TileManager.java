package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

    GamePanel gp;
    Tile[] tile;

    // constructor:
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10]; // number of different types of tiles
        getTileImage();
    }

    public void getTileImage() {

        try {

            // grass1
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
            // wall
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            // water1
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //__________________________________________________________________________________________________________________
    // DRAWING TILES
    public void draw(Graphics2D g2) {
        // Hardcoding tiles:
        // Top five tiles from left to right
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 144, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 192, 0, gp.tileSize, gp.tileSize, null);
        // Second top row from left to right
        g2.drawImage(tile[0].image, 0, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 48, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 144, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 192, 48, gp.tileSize, gp.tileSize, null);
        // Third row etc.
        g2.drawImage(tile[1].image, 0, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 48, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 144, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 192, 96, gp.tileSize, gp.tileSize, null);
        // Fourth
        g2.drawImage(tile[0].image, 0, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 48, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 144, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 192, 144, gp.tileSize, gp.tileSize, null);

        // Automated tiledrawing:
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
        g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null); // grass tiles everywhere
        col++;
        x += gp.tileSize;

        if (col == gp.maxScreenCol) {
            col = 0;
            x = 0;
            row++;
            y += gp.tileSize;
        }
        }

    }

    //__________________________________________________________________________________________________________________

}
