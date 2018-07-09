import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    public BufferedImage image;
    public boolean onIsland = false;
    //public BoxCollider boxCollider;
    public Vector2D templeVelocity = new Vector2D();
    public float width;
    public float height;


    public Player(Vector2D position, BufferedImage image) {
        this.position.set(position);
        this.image = image;
        this.velocity = new Vector2D(15f, 15f);
        //this.boxCollider = new BoxCollider(310 / 4, 222 / 4);
        this.width = 310 / 4f;
        this.height = 222 / 4f;
    }

    public Player() {
        super();
    }

//    public void run(FloatingIsland floatingIsland) {
//        if (boxCollider.checkCollision(new Point(floatingIsland.position.x + this.velocity.y, this.)))
//    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, (int)this.width, (int)this.height, null);
    }
}
