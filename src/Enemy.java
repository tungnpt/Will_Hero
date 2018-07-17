import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy extends GameObject {
    public BufferedImage image = this.loadImage("resources/player.png");
    public boolean onIsland = false;
    public boolean isFalling = true;
    public BoxCollider boxCollider;

    float gravity = 0.5f;
    //float friction = 0.99f;

    public Enemy() {
        super();
        this.velocity = new Vector2D(25f, 5f);
        this.width = 80;
        this.height = 60;
    }

    public Enemy(Vector2D position) {
        this.position.set(position);
        //this.image = image;
        this.velocity = new Vector2D(25f, 5f);
        this.width = 80;
        this.height = 60;
        this.boxCollider = new BoxCollider(this.width, this.height);
    }

    public void run() {
        if (KeyboardInput.instance.isSpace) {
            //this.position.subtractBy(this.velocity);
            this.position.x -= this.velocity.x;
        }

        if (isFalling == false) {
            this.velocity.y = -this.velocity.y;
            isFalling = true;
        } else {
            this.velocity.y += gravity;
        }
        this.position.y += this.velocity.y;
        this.boxCollider.position.set(this.position);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, (int) this.width, (int) this.height, null);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
