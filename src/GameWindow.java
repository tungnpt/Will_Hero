import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTime = 0;

    public GameWindow() {
        this.setSize(1920, 1200);

        this.gameCanvas = new GameCanvas();

        this.add(this.gameCanvas);

        this.event();

        this.setVisible(true);
    }

    private void event() {
        this.windowEvent();
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

        }
    }
    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
}
