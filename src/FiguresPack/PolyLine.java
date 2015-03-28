/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FiguresPack;

import java.awt.*;

public class PolyLine extends Figures{
    
    private int xPoints[];
    private int yPoints[];
    
    public PolyLine(int xPoints[], int yPoints[]){
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }
    
    @Override
    public void paintFigure(Graphics g) {
        g.drawPolyline(xPoints, yPoints, xPoints.length);
    }
    
    
    
}
