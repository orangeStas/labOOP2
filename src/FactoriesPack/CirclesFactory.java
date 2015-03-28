package FactoriesPack;

import FiguresPack.Circle;
import FiguresPack.Figures;

/**
 *
 * @author OrangeUser
 */
public class CirclesFactory implements FiguresFactory {

    @Override
    public Figures getFigure(int[] opt) {
        return new Circle(opt[0], opt[1], opt[2], opt[3]);
    }

}
