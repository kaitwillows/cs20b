// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Graphics;
// import java.awt.event.MouseEvent;
// import java.awt.event.MouseListener;

// import javax.swing.JFrame;
// import javax.swing.JPanel;

// public class GUI extends JPanel implements MouseListener {
//   private static final int SQUARE_SIZE = 50;
//   private static final int NUM_SQUARES = 8;
//   private static final int BOARD_SIZE = NUM_SQUARES * SQUARE_SIZE;

//   private int highlightX = -1;
//   private int highlightY = -1;

//   public GUI() {
//     addMouseListener(this);
//     setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
//   }

//   @Override
//   public void paintComponent(Graphics g) {
//     super.paintComponent(g);

//     for (int i = 0; i < NUM_SQUARES; i++) {
//       for (int j = 0; j < NUM_SQUARES; j++) {
//         if ((i + j) % 2 == 0) {
//           g.setColor(Color.WHITE);
//         } else {
//           g.setColor(Color.BLACK);
//         }
//         g.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);

//         if (i == highlightX && j == highlightY) {
//           g.setColor(Color.YELLOW);
//           g.drawRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
//         }
//       }
//     }
//   }

//   @Override
//   public void mouseClicked(MouseEvent e) {
//     highlightX = e.getX() / SQUARE_SIZE;
//     highlightY = e.getY() / SQUARE_SIZE;
//     System.out.println("Square clicked: (" + highlightX + ", " + highlightY + ")");
//     repaint();
//   }

//   @Override
//   public void mousePressed(MouseEvent e) {}

//   @Override
//   public void mouseReleased(MouseEvent e) {}

//   @Override
//   public void mouseEntered(MouseEvent e) {}

//   @Override
//   public void mouseExited(MouseEvent e) {}

//   public static void main(String[] args) {
//     JFrame frame = new JFrame("Chess Board");
//     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     frame.add(new GUI());
//     frame.pack();
//     frame.setVisible(true);
//   }
// }
