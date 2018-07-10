import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CreateIsland extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    private Vector2D previousIslandPosition;

    public CreateIsland() {
        //this.frameCounter = new FrameCounter(30);
        this.random = new Random();
        this.previousIslandPosition = new Vector2D();
    }

    public void run() {
        int temp = random.nextInt(3)+1;
        this.previousIslandPosition.set(GameObjectManager.instance.getTheLastIsland().position);
        //FloatingIsland floatingIsland = new FloatingIsland();
//        floatingIsland.position.set(this.previousIslandPosition.x + this.random.nextInt(100) + 200,
//                this.random.nextInt(100) + 500
//        );
        FloatingIsland floatingIsland = new FloatingIsland(previousIslandPosition,
                this.loadImage("resources/Island" + temp +" .png"),
                random.nextInt(100)+500,
                400
        );
        GameObjectManager.instance.add(floatingIsland);
    }
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
