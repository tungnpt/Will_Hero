import java.awt.*;

public class BoxCollider {

    public Vector2D position;
    private int width;
    private int height;

    public BoxCollider(int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2D();
    }

    public boolean checkCollision(Point point) {
        Rectangle r1 = new Rectangle((int) this.position.x, (int) this.position.y, this.width, this.height);
        return r1.contains(point);
    }
}
