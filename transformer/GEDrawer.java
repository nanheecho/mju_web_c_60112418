package transformer;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import shapes.GEShape;
import shapes.GEPolygon;
import constants.GEConstants;
public class GEDrawer extends GETransformer{
	
	public GEDrawer(GEShape shape){
		super(shape);
	}
	
	public void init(Point p){
		shape.initDraw(p);
	}

	public void transfomer(Graphics2D g2D,Point p){
		g2D.setXORMode(GEConstants.BACKGROUD_COLOR);
		g2D.setStroke(dashedLineStroke); //�� ��
		shape.draw(g2D);
		shape.setCoordinate(p);
		shape.draw(g2D);
	}
	public void finalize(ArrayList<GEShape> shapeList){
		shapeList.add(shape);
	}
	public void continueDrawing(Point p){
		((GEPolygon)shape).continueDrawing(p);
	}
}
