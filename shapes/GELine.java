package shapes;
import java.awt.Point;
import java.awt.geom.Line2D;;

public class GELine extends GEShape{

	public GELine(){
		super(new Line2D.Double());
	}	
	
	public void initDraw(Point startp){ //startpoint 받는 부분
		this.startP= startp;
	}
	public void setCoordinate(Point currentP){
		Line2D tempLine=(Line2D)myShape;
		tempLine.setLine(startP.x, startP.y,currentP.x, currentP.y);
	}
	public GEShape clone(){
		return new GELine();
	}
	
}
