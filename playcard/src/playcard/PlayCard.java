package playcard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PlayCard extends BufferedImage {
    final public static int WIDTH = 45;
    final public static int HEIGHT = 60;

    final public static int ANGLE = HEIGHT / 10;
    
    private PlayCard() {
        super(WIDTH, HEIGHT, BufferedImage.TRANSLUCENT);
        
        Graphics g = getGraphics();
        
        g.setColor(Color.white);
        g.fillRoundRect(0, 0, WIDTH - 1, HEIGHT - 1, ANGLE, ANGLE);
        
        g.setColor(Color.darkGray);
        g.drawRoundRect(0, 0, WIDTH - 1, HEIGHT - 1, ANGLE, ANGLE);
    }
    
    final public static int INSET = HEIGHT / 12;
    
    public static PlayCard getBack(Color color) {
        PlayCard back = new PlayCard();
        
        Graphics g = back.getGraphics();
        
        g.setColor(color);
        g.fillRect(INSET, INSET, WIDTH - 2 * INSET, HEIGHT - 2 * INSET);
        
        return back;
    }
    
    final public static String SUIT = "\u2660\u2665\u2663\u2666";
    final public static Object[] RANK = {'A', 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'};
    
    final private static Color[] COLOR = {Color.black, Color.red};
    
    public static PlayCard getFace(char suit, Object rank) {
        PlayCard face = new PlayCard();
        
        Graphics g = face.getGraphics();
        
        g.setColor(COLOR[SUIT.indexOf(suit) % COLOR.length]);
        
        g.setFont(g.getFont().deriveFont(Font.BOLD, face.getHeight() / 3));
        g.drawString(String.valueOf(rank), g.getFont().getSize() / 10, (int) (0.9 * g.getFont().getSize()));
        g.drawString(String.valueOf(suit), face.getWidth() - g.getFont().getSize() / 10 - g.getFontMetrics().charWidth(suit), (int) (0.9 * g.getFont().getSize()));
        
        g.setFont(g.getFont().deriveFont(Font.PLAIN, face.getHeight() - g.getFont().getSize()));
        g.drawString(String.valueOf(suit), 1 + (face.getWidth() - g.getFontMetrics().charWidth(suit)) / 2, (int) (0.9 * face.getHeight()));
        
        return face;
    }
    
}
