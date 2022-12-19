import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



class GUI {
  public static int x;
  public static int y;
  public static boolean whiteSquare = true;

  public static void main(String[] args) {
    JFrame board = new JFrame("test");
    board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    board.setSize(512, 512);
    board.setVisible(true);

    ImagePanel painter = new ImagePanel();

    boolean whiteSquare = true;
    x = 0;
    y = 0;
    board.add(painter);


    // set variables
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        x = i * 64;
        y = j * 64;
        // board.add(painter);
        if (whiteSquare) { // flip flop

          whiteSquare = false;
        } else {

          whiteSquare = true;
        }
      }
    } 



  }
}

class ImagePanel extends JPanel {
  private Image whiteImage;
  private Image blackImage;
  public ImagePanel() {
    try {
      whiteImage = ImageIO.read(new File("./white-square.png"));
      blackImage = ImageIO.read(new File("./black-square.png"));
    } catch (IOException ex) {
      System.out.println("error at GUI:~29");
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (GUI.whiteSquare) {
      g.drawImage(whiteImage, GUI.x, GUI.y, this);
    } else {
      g.drawImage(blackImage, GUI.x, GUI.y, this);
    }
  }
}
