// ctrl + alt + l = format

package main;

import javax.swing.*;

public class GamePanel extends JPanel {

    final int originalTitleSize = 16; // 16x16 title pixlels
    final int scale = 3;

    final int tileSize = originalTitleSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWitdth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;


}
