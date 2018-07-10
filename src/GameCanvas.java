import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;

    Background background = new Background();
    Player player = new Player();
    FloatingIsland floatingIsland = new FloatingIsland();

    public GameCanvas() {
        this.setSize(1920, 1200);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1920, 1200, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background(
                this.loadImage("resources/background.jpg")
        );
        this.player = new Player(new Vector2D(300,200), this.loadImage("resources/player.png"));
        this.floatingIsland = new FloatingIsland(new Vector2D(200,600),
                this.loadImage("resources/Island3.png"),
                600,
                400);
        //GameObjectManager.instance.add(new CreateIsland());
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void runAll(){
        if(OnIsland.checkOnIsland(player,floatingIsland)){
            //player.onIsland = true;
            player.isFalling = false;
        }
        this.player.run(floatingIsland);
        this.floatingIsland.run();
        //GameObjectManager.instance.runAll();
    }

    public void renderAll() {
        this.background.render(graphics);
        this.floatingIsland.render(graphics);
        //GameObjectManager.instance.renderAll(graphics);
        this.player.render(graphics);
        this.repaint();
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
