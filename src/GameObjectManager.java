
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    public ArrayList<GameObject> list = new ArrayList<>();
    private ArrayList<GameObject> tempList = new ArrayList<>();

    public int biggestPositionX = 0;

    private Random random;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        FloatingIsland floatingIsland = new FloatingIsland(new Vector2D(200,600),
                this.loadImage("resources/Island1.png"),
                700,
                400);
        floatingIsland.enemies.clear();
        list.add(floatingIsland);
        floatingIsland = new FloatingIsland(new Vector2D(1100,600),
                this.loadImage("resources/Island2.png"),
                800,
                400);
        list.add(floatingIsland);
        floatingIsland = new FloatingIsland(new Vector2D(2100,600),
                this.loadImage("resources/Island3.png"),
                1200,
                400);
        list.add(floatingIsland);
        floatingIsland = new FloatingIsland(new Vector2D(3500,600),
                this.loadImage("resources/Island4.png"),
                1200,
                400);
        list.add(floatingIsland);
    }

    public void add(GameObject gameObject) {
        this.list.add(gameObject);
    }

    public void runAll() {
        //if (KeyboardInput.instance.isSpace) {
            this.biggestPositionX = (int) this.list.get(0).position.x + this.list.get(0).width;
            for (int i=0; i<list.size(); i++){
                if ((int)this.list.get(i).position.x + this.list.get(i).width > this.biggestPositionX){
                    this.biggestPositionX = (int)this.list.get(i).position.x + this.list.get(i).width;
                }
            }
            this.list
                    .stream()
                    .forEach(gameObject -> gameObject.run());
//            this.list.addAll(this.tempList);
//            this.tempList.clear();
            System.out.println(this.list.size());
        //}
    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream()
                .forEach(gameObject -> gameObject.render(graphics));
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
