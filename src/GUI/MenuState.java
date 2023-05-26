package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Map.Background;
import main.GamePanel;

public class MenuState extends GUI_Manager {

    public MenuState(GamePanel gp) {
        super(gp);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(new Color(157, 120, 100));
        g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
        x = 0;
        y = GamePanel.tilesize;
        Background background1 = new Background("/menu/menu_squidgame.png");
        g2.drawImage(background1.getImage(), x, y, GamePanel.tilesize * 16,
                GamePanel.tilesize * 4, null);

        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 4) / 2;
        y += GamePanel.tilesize + 160;
        Background background3 = new Background("/Boss/boss_chinhdien.png");
        g2.drawImage(background3.getImage(), x, y, GamePanel.tilesize * 4, GamePanel.tilesize * 4, null);

        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 6) / 2;
        y = 460;
        Background background4 = new Background("/Object_guard/npc-round.png");
        g2.drawImage(background4.getImage(), x, y, GamePanel.tilesize + 20, GamePanel.tilesize + 20, null);

        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 9) / 2;
        y = 460;
        Background background5 = new Background("/Object_guard/npc-square.png");
        g2.drawImage(background5.getImage(), x, y, GamePanel.tilesize + 20, GamePanel.tilesize + 20, null);

        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 12) / 2;
        y = 460;
        Background background6 = new Background("/Object_guard/npc-triangle.png");
        g2.drawImage(background6.getImage(), x, y, GamePanel.tilesize + 20, GamePanel.tilesize + 20, null);

        Background background7 = new Background("/Object_guard/npc-round.png");
        g2.drawImage(background7.getImage(), 450, 460, GamePanel.tilesize + 20, GamePanel.tilesize + 20, null);

        Background background8 = new Background("/Object_guard/npc-square.png");
        g2.drawImage(background8.getImage(), 520, 460, GamePanel.tilesize + 20, GamePanel.tilesize + 20, null);

        Background background9 = new Background("/Object_guard/npc-triangle.png");
        g2.drawImage(background9.getImage(), 590, 460, GamePanel.tilesize + 20, GamePanel.tilesize + 20, null);

        Background background10 = new Background("/player/player_standd.png");
        g2.drawImage(background10.getImage(), 335, 460, GamePanel.tilesize * 2, GamePanel.tilesize * 2, null);

        Background background11 = new Background("/NPC_blue/npc_blue_down1.png");
        g2.drawImage(background11.getImage(), 310, 560, GamePanel.tilesize + 25, GamePanel.tilesize + 25, null);

        Background background12 = new Background("/NPC_xanh/npc_girl_down1.png");
        g2.drawImage(background12.getImage(), 380, 560, GamePanel.tilesize + 25, GamePanel.tilesize + 25, null);

        Background background13 = new Background("/NPC_trang/npc_trang_down1.png");
        g2.drawImage(background13.getImage(), 240, 560, GamePanel.tilesize + 25, GamePanel.tilesize + 25, null);

        Background background14 = new Background("/NPC_nau/npc_nau_down1.png");
        g2.drawImage(background14.getImage(), 450, 560, GamePanel.tilesize + 25, GamePanel.tilesize + 25, null);

        Background background15 = new Background("/NPC_trang/npc_trang_down1.png");
        g2.drawImage(background15.getImage(), 520, 560, GamePanel.tilesize + 25, GamePanel.tilesize + 25, null);

        Background background16 = new Background("/NPC_nau/npc_nau_down1.png");
        g2.drawImage(background16.getImage(), 170, 560, GamePanel.tilesize + 25, GamePanel.tilesize + 25, null);

        Background background17 = new Background("/NPC_blue/npc_blue_down1.png");
        g2.drawImage(background17.getImage(), 590, 560, GamePanel.tilesize + 25, GamePanel.tilesize + 25, null);

        Background background18 = new Background("/NPC_xanh/npc_girl_down1.png");
        g2.drawImage(background18.getImage(), 100, 560, GamePanel.tilesize + 25, GamePanel.tilesize + 25, null);

        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 6) / 2;
        y += GamePanel.tilesize * 3;
        Background button = new Background("/menu/menuStart.png");
        g2.drawImage(button.getImage(), x, y, GamePanel.tilesize * 7, GamePanel.tilesize * 7, null);

        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 70F));
        g2.setColor(new Color(122, 0, 0));

        if (gp.keyH.commandNum == 0) {
            g2.drawString(">", 185, 740);
        }
        if (gp.keyH.commandNum == 1) {
            g2.drawString(">", 213, 850);
        }
    }
}