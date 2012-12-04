package shapes;
import java.awt.Point;
import java.awt.Rectangle;
///////////^^^^^^^^^^^^^
public class GERectangle extends GEShape{
	//private Point startP;
	private Rectangle rectangle;	
	
	public GERectangle(){
		super(new Rectangle());//shape을 implements하고잇음
		//rectangle = new Rectangle();
	}	
	public void initDraw(Point startp){ //staetp를 초기화하는 것
		this.startP= startp;
		
	}
	public void setCoordinate(Point currentP){
		Rectangle tempRectangle = (Rectangle)myShape;
		tempRectangle.setFrameFromDiagonal(startP.x,startP.y,currentP.x , currentP.y); //setframe~이거는 빼기연산안해도됨
		
		//rectangle.setFrame(startP.x,startP.y,currentP.x-startP.x , currentP.y-startP.y);
	}
	public GEShape clone(){
		return new GERectangle();
	}
}
