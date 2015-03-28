package FactoriesPack;

import FiguresPack.Figures;
import FiguresPack.Line;

public class LinesFactory implements FiguresFactory {

    public LinesFactory(){
        
    }

    @Override
    public Figures getFigure(int[] opt)
    {
            return new Line(opt[0], opt[1], opt[2], opt[3]);
    }

}
