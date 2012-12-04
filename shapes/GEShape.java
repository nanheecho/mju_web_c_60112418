package shapes;
import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.Shape;//////////////////////////////////////^^
import java.awt.Rectangle;
import utils.GEAnchorList;
import constants.GEConstants.EAnchorTypes;
import java.awt.Color;

import java.awt.geom.AffineTransform;
	

	public abstract class GEShape { //추상클래스로 만들기
	
	protected Shape myShape;
	protected Point startP;
	protected boolean selected;
	protected GEAnchorList anchorList;
	protected EAnchorTypes selectedAnchor;
	protected Color lineColor,fillColor;
	
	protected AffineTransform affineTransform;
	
	public GEShape(Shape shape){ //	생성자
		this.myShape=shape;
		
		affineTransform= new AffineTransform();
		
		anchorList=null;
		selected=false;
	}	
	
	public void setLineColor(Color lineColor){
	this.lineColor=lineColor;	
	}	
	
	public void setFillColor(Color fillColor){		
		this.fillColor=fillColor;	
	}	
	
	public GEAnchorList getAnchorList(){
		return anchorList;
	}

	public void setAnchorList(GEAnchorList anchorList){
		this.anchorList= anchorList;
	}
	
	public void draw(Graphics2D g2D){
		//g2D.draw(myShape);
		if(this.fillColor!= null){
			g2D.setColor(this.fillColor);
			g2D.fill(myShape);
		}
		if(this.lineColor!=null){
			g2D.setColor(this.lineColor);
			g2D.draw(myShape);
		}
		if(selected){
			this.getAnchorList().setPosition(myShape.getBounds());
			this.getAnchorList().draw(g2D);
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
	
	public void moveCoordinate(Point moveP){
		affineTransform.setToTranslation(moveP.getX(), moveP.getY());
		myShape = affineTransform.createTransformedShape(myShape);
	}
	
	abstract public void initDraw(Point startP);
	abstract public void setCoordinate(Point curretP);
	abstract public GEShape clone(); 
}
