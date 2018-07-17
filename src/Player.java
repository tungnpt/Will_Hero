import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    public BufferedImage image;
    public boolean onIsland = false;
    public boolean isFalling = true;

    public BoxCollider boxCollider;

    float gravity =0.5f;
    //float friction = 0.99f;

    public Player() {
        super();
    }

    public Player(Vector2D position, BufferedImage image) {
        this.position.set(position);
        this.image = image;
        this.velocity = new Vector2D(5f, 5f);
        this.width = 310 / 4;
        this.height = 222 / 4;

        this.boxCollider = new BoxCollider(this.width, this.height);
    }

    public void run() {
        for (int i=0; i<GameObjectManager.instance.list.size(); i++){
//            if(OnIsland.checkOnIsland(this,(FloatingIsland)GameObjectManager.instance.list.get(i))){
//////                this.isFalling = false;
//            }
            if(this.boxCollider.checkCollision(((FloatingIsland) GameObjectManager.instance.list.get(i)).boxCollider)){
                this.isFalling = false;
        }
        }
        if (!isFalling){
                this.velocity.y = -this.velocity.y;
                isFalling = true;
        }
        else{
            this.velocity.y +=  gravity;
        }
        this.position.y += this.velocity.y;
        this.boxCollider.position.set(this.position);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, (int)this.width, (int)this.height, null);
    }
}
