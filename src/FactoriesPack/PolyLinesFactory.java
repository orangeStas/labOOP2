package FactoriesPack;

import FiguresPack.Figures;
import FiguresPack.PolyLine;

/**
 * Created by OrangeUser on 3/22/2015.
 */
public class PolyLinesFactory implements FiguresFactory {
    @Override
    public Figures getFigure(int[] opt) {
        int[] arrXs = new int[opt.length/2];
        int[] arrYs = new int[opt.length/2];

        int j=0;
        for (int i = 0 ; i< opt.length; i++){
            if (i+1 <= opt.length/2)
                arrXs[i] = opt[i];
            else {
                arrYs[j] = opt[i];
                j++;
            }
        }

        return new PolyLine(arrXs, arrYs);
    }
}
