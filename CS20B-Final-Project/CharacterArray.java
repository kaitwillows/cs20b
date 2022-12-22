// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;

// public class CharacterArray extends JFrame {
//   // Declare and initialize the character array
//   private static final char[] CHARACTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

//   public CharacterArray() {
//     // Set up the frame
//     setTitle("Character Array");
//     setSize(300, 300);
//     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     setLayout(new GridLayout(8, 8));

//     // Add a button for each character in the array
//     for (int i = 0; i < 64; i++) {
//       JButton button = new JButton(String.valueOf(CHARACTERS[i % 26]));
//       button.addMouseListener(new MouseAdapter() {
//         @Override
//         public void mouseClicked(MouseEvent e) {
//           // Print the selected character when the button is clicked
//           System.out.println("You selected character " + button.getText());
//         }
//       });
//       add(button);
//     }
//   }

//   public static void main(String[] args) {
//     // Show the frame
//     SwingUtilities.invokeLater(() -> new CharacterArray().setVisible(true));
//   }
// }
