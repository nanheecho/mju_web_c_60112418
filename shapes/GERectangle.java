package shapes;
import java.awt.Point;
import java.awt.Rectangle;
///////////^^^^^^^^^^^^^
public class GERectangle extends GEShape{
	//private Point startP;
	private Rectangle rectangle;	
	
	public GERectangle(){
		super(new Rectangle());//shape�� implements�ϰ�����
		//rectangle = new Rectangle();
	}	
	public void initDraw(Point startp){ //staetp�� �ʱ�ȭ�ϴ� ��
		this.startP= startp;
		
	}
	public void setCoordinate(Point currentP){
		Rectangle tempRectangle = (Rectangle)myShape;
		tempRectangle.setFrameFromDiagonal(startP.x,startP.y,currentP.x , currentP.y); //setframe~�̰Ŵ� ���⿬����ص���
		
		if(anchorList!=null){
			anchorList.setPosition(myShape.getBounds());
		}
	}
	public GEShape clone(){
		return new GERectangle();
	}
}
