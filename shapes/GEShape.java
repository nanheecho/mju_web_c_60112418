package shapes;
import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.Shape;//////////////////////////////////////^^
import java.awt.Rectangle;
import utils.GEAnchorList;
import constants.GEConstants.EAnchorTypes;

public abstract class GEShape { //추상클래스로 만들기
	
	protected Shape myShape;
	protected Point startP;
	//1120
	protected boolean selected;
	protected GEAnchorList anchorList;
	protected EAnchorTypes selectedAnchor;
	
	public GEShape(Shape shape){ //	생성자
		this.myShape=shape;
		anchorList=null;
		selected=false;
	}	
	public void draw(Graphics2D g2D){
		g2D.draw(myShape);
		if(selected){
			anchorList.draw(g2D);
		}
	}
	public void setSelected(boolean selected){
		this.selected=selected;
		if(selected){
			anchorList=new GEAnchorList();
			anchorList.setPosition(myShape.getBounds());
		}else{
			anchorList=null;
		}
	}
	public boolean onShape(Point p){
		if(anchorList!=null){
			selectedAnchor=anchorList.onAnchors(p);
			if(selectedAnchor!=EAnchorTypes.NONE)
				return true;
		}
		return myShape.intersects(new Rectangle(p.x,p.y,2,2));
	}
	abstract public void initDraw(Point startP);
	abstract public void setCoordinate(Point curretP);
	abstract public GEShape clone(); 
}
