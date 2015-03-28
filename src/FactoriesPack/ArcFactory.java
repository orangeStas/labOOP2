package FactoriesPack;

import FiguresPack.Figures;

/**
 * Created by OrangeUser on 3/22/2015.
 */
public class ArcFactory implements FiguresFactory {
    @Override
    public Figures getFigure(int[] opt) {
        return new Arc(opt[0], opt[1], opt[2], opt[3], opt[4], opt[5]);
    }
}
