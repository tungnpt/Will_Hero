
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private ArrayList<GameObject> list = new ArrayList<>();
    private ArrayList<GameObject> tempList = new ArrayList<>();

    private Random random;

    private GameObjectManager() {
//        this.list = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {
        this.list
                .stream()
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream()
                .forEach(gameObject -> gameObject.render(graphics));
    }
    public FloatingIsland getTheLastIsland(){
        for(int i=this.list.size()-1; i>=0; i--){
            if(this.list.get(i) instanceof FloatingIsland){
                return (FloatingIsland)this.list.get(i);
            }
        }
        return new FloatingIsland(new Vector2D(1920,600),
                this.loadImage("resources/Island1.png"),
                random.nextInt(100)+500,
                400
        );
    }
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

}
