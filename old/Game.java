import java.io.*;
import java.util.*;

public class Game { // this class is responcible for loading and saving games
    String gameID;
    String rawBoard;
    char[][] board = {
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
    };
    public Game(String gameID) {
        this.gameID = gameID;
    }

    public String loadBoard() {
        try {
            File file = new File(gameID + ".txt");
            Scanner scanner = new Scanner(file);
            rawBoard = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.exit(1);
        }

        char readChar = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = rawBoard.charAt(readChar);
                readChar++;
            }
        }
        return rawBoard;
    }

    public void saveBoard(char[][] saveBoard, String saveID) {
        File saveFile = new File(saveID + ".txt");
        // Scanner saveScanner = new Scanner(saveID + ".txt");
        if (saveFile.exists()) { // resets file
            saveFile.delete();
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                System.exit(1);
            }
        }
        rawBoard = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                rawBoard = rawBoard + saveBoard[i][j];
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(saveID + ".txt");
            fileWriter.write(rawBoard);
            fileWriter.close();
        } catch (IOException e) {
            System.exit(1);
        }
    }
}
