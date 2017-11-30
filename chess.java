package connect;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class chess {

    public final JPanel gui = new JPanel(new BorderLayout(3, 3));
    public JButton[][] boardSquares = new JButton[8][8];
    public JPanel chessBoard;
    public final JLabel message = new JLabel(
            "chess?");
    public static final String COLS = "ABCDEFGH";

    chess() {
        initializeGui();
    }

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New")); //add function

        chessBoard = new JPanel(new GridLayout(0, 9));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);

        // create the chess board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < boardSquares.length; i++) {
            for (int j= 0; j < boardSquares[i].length; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // 64x64 tile creation
                ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.RED);
                } else {
                    b.setBackground(Color.BLACK);
                }
                boardSquares[j][i] = b;
            }
        }

        //fill the tiles
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int i = 0; i < 8; i++) {
        	chessBoard.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                    	chessBoard.add(new JLabel("" + (i + 1),
                                SwingConstants.CENTER));
                    default:
                    	chessBoard.add(boardSquares[j][i]);
                }
            }
        }
    }

public final JComponent getChessBoard() {
	return chessBoard;
}
    public final JComponent getGui() {
    return gui;
}

public static void main(String[] args) {
	Runnable r = new Runnable() {
            @Override
public void run() {
    chess chessBoard =new chess();
    JFrame f = new JFrame("Chess");
    f.add(chessBoard.getGui());
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setLocationByPlatform(true);
    f.pack();    f.setMinimumSize(f.getSize());
    f.setVisible(true);
            }
        };
    SwingUtilities.invokeLater(r);
    }
}