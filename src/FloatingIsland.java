import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FloatingIsland extends GameObject {
    public BufferedImage image;
    Random random = new Random();

    public FloatingIsland() {
        super();
        this.position = new Vector2D();
        this.velocity = new Vector2D(50f, 0);
    }

    public FloatingIsland(Vector2D position, BufferedImage image, int width, int height) {
        this.position.set(position);
        this.image = image;
        this.width = width;
        this.height = height;
        ;
        this.velocity = new Vector2D(25f, 0);
    }

    public void set(FloatingIsland FI) {
        this.position = FI.position;
        this.image = FI.image;
        this.width = FI.width;
        this.height = FI.height;
        this.velocity = new Vector2D(100f, 0);
    }

    public void run() {
        if (KeyboardInput.instance.isSpace) {
            this.backToScreen();
            this.position.subtractBy(this.velocity);
        }
    }

    public void backToScreen() {
        if (this.position.x + this.width <= 0) {
            int num = random.nextInt(200) + 200;
            this.position.x = GameObjectManager.instance.biggestPositionX + num;
            this.position.y = random.nextInt(100) + 500;
            this.width = random.nextInt(700) +  500;
            this.height = random.nextInt(100)+400;
            String temp = Integer.toString(random.nextInt(4)+1);
            String path = "resources/Island" + temp + ".png";
            this.image = loadImage(path);
        }
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, this.width, this.height, null);
    }
}
