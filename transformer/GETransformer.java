package transformer;
import java.awt.Graphics2D;
import java.awt.Point;
import shapes.GEShape;

public abstract class GETransformer {
	
	protected GEShape shape;
	
	public GETransformer(GEShape shape){
		this.shape=shape;
	}
	
	abstract public void transfomer(Graphics2D g2D,Point p);
}
