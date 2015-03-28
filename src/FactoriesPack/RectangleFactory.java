package FactoriesPack;

import FiguresPack.Figures;
import FiguresPack.Rectangle;

/**
 * Created by OrangeUser on 3/22/2015.
 */
public class RectangleFactory implements FiguresFactory {
    @Override
    public Figures getFigure(int[] opt) {
        return new Rectangle(opt[0], opt[1], opt[2], opt[3]);
    }
}
