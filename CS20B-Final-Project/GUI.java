import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class GUI {
  public static int x;
  public static int y;
  public static void main(String[] args) {
    JFrame board = new JFrame("test");
    board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    board.setSize(512, 512);
    

    ImagePanel panel = new ImagePanel();
    x = 0;
    board.add(panel);
    board.setVisible(true);

    x = 99;
    // try {
    //   TimeUnit.MILLISECONDS.sleep(500);
    // } 
    // catch(InterruptedException e) {}
    // x = 400;

    // for (int i = 0; i < 512; i++) {
    //   System.out.println(i);
    //   x = i;
    //   System.out.println(x);
    //   System.out.println(" ");

    //   try {
    //     TimeUnit.MILLISECONDS.sleep(500);
    //   } 
    //   catch(InterruptedException e) {}

    // }
  }
}

class ImagePanel extends JPanel {
  private Image image;

  public ImagePanel() {
    try {
      image = ImageIO.read(new File("./black-square.png"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, GUI.x, GUI.y, this);
  }
}
