package modifyfirst;

import java.awt.*;

public class Cell {
    public static final int SIZE = 120; // cell width/height (square)
    public static final int PADDING = SIZE / 5;
    public static final int SEED_SIZE = SIZE - PADDING * 2;
    public static final int SEED_STROKE_WIDTH = 8;

    public Seed content; // Content of this cell (CROSS, NOUGHT, or NO_SEED)
    public int row, col; // Row and column of this cell

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        content = Seed.NO_SEED;
    }

    public void newGame() {
        content = Seed.NO_SEED;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set the thickness for the cell borders
        float lineThickness = 4.0f; // Adjust this value for thicker or thinner lines
        g2d.setStroke(new BasicStroke(lineThickness)); // Set stroke thickness

        // Draw the cell border in black
        g2d.setColor(Color.BLACK);
        int x = col * SIZE;
        int y = row * SIZE;
        g2d.drawRect(x, y, SIZE, SIZE);

        // Draw the content (CROSS or NOUGHT)
        g2d.setStroke(new BasicStroke(SEED_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        int x1 = x + PADDING;
        int y1 = y + PADDING;

        if (content == Seed.CROSS) {
            g2d.setColor(GameMain.COLOR_CROSS);
            int x2 = x + SIZE - PADDING;
            int y2 = y + SIZE - PADDING;
            g2d.drawLine(x1, y1, x2, y2);
            g2d.drawLine(x2, y1, x1, y2);
        } else if (content == Seed.NOUGHT) {
            g2d.setColor(GameMain.COLOR_NOUGHT);
            g2d.drawOval(x1, y1, SEED_SIZE, SEED_SIZE);
        }
    }
}