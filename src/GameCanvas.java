import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;

    Background background = new Background();
    Player player = new Player();

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
        this.player = new Player(new Vector2D(500,500), this.loadImage("resources/player.png"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
//        this.graphics.setColor(Color.BLACK);
//        this.graphics.fillRect(0, 0, 1920, 1200);

        this.background.render(graphics);
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
