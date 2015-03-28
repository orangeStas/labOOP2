
import FiguresPack.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.JFrame;


public class DrawingFrame extends JFrame{
    
    private FigureList list;
    
    public DrawingFrame(FigureList list){
        super("Figures");
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        this.list = list;
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        list.draw(g);
    }
    
}
