package transformer;

import java.awt.Point;
import constants.GEConstants;
import java.awt.Graphics2D;
import shapes.GEShape;


public class GEMover extends GETransformer{
	public GEMover(GEShape shape){
		super(shape);
		previousP = new Point();
	}
	
	public void init(Point p){
		previousP=p;
	}
	
	public void transfomer(Graphics2D g2D,Point p){
		Point tempP = new Point(p.x - previousP.x, p.y - previousP.y);
		g2D.setXORMode(GEConstants.BACKGROUD_COLOR);
		g2D.setStroke(dashedLineStroke);
		shape.draw(g2D);
		shape.moveCoordinate(tempP);
		shape.draw(g2D);
		previousP = p;
	}
}
