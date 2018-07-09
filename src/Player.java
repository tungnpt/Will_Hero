import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    public BufferedImage image;

    public Player(Vector2D position, BufferedImage image) {
        this.position.set(position);
        this.image = image;
    }

    public Player() {
        super();
    }

    public void render(Graphics graphics) { graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 310/4, 222/4, null);
    }
}
