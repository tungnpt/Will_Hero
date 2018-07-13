import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    public BufferedImage image;
    public boolean onIsland = false;
    public boolean isFalling = true;

    float gravity =1f;
    float friction = 0.99f;

    public Player() {
        super();
    }

    public Player(Vector2D position, BufferedImage image) {
        this.position.set(position);
        this.image = image;
        this.velocity = new Vector2D(5f, 5f);
        this.width = 310 / 4;
        this.height = 222 / 4;
    }

    public void run() {
        for (int i=0; i<GameObjectManager.instance.list.size(); i++){
            if(OnIsland.checkOnIsland(this,(FloatingIsland)GameObjectManager.instance.list.get(i))){
                this.isFalling = false;
            }
        }
        if (isFalling == false){
            this.velocity.y = -this.velocity.y * friction;
            isFalling = true;
        }
        else{
            this.velocity.y +=  gravity;
        }
        this.position.y += this.velocity.y;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, (int)this.width, (int)this.height, null);
    }
}
