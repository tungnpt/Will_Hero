import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    public BufferedImage image;
    public boolean onIsland = false;
    //public Vector2D templeVelocity = new Vector2D();    tạm thời chưa dùng đến

    public Player() {
        super();
    }

    public Player(Vector2D position, BufferedImage image) {
        this.position.set(position);
        this.image = image;
        this.velocity = new Vector2D(15, 15f);
        this.width = 310 / 4;
        this.height = 222 / 4;
    }

    public void run(FloatingIsland floatingIsland){
        if (KeyboardInput.instance.isRight) {
            this.position.x += this.velocity.x;
            this.onIsland=false;
        }
        if (KeyboardInput.instance.isLeft) {
            this.position.x -= this.velocity.x;
            this.onIsland=false;
        }
        if (KeyboardInput.instance.isUp) {
            this.position.y -= this.velocity.y;
            this.onIsland=false;
        }
        if (KeyboardInput.instance.isDown) {
            //this.position.y += this.velocity.y;
            if(this.onIsland==false){
                this.position.y += this.velocity.y;
            }else{
                int velo = (int)floatingIsland.position.y-(int)this.position.y-(int)this.height;
                this.position.y += velo;
                this.onIsland=false;
            }
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, (int)this.width, (int)this.height, null);
    }
}
