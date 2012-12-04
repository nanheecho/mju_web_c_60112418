package frames;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import constants.GEConstants;
import shapes.GEShape;
import java.awt.Graphics;//paintComponet
import java.util.ArrayList;//shapeList


/////////^^^^^^
public class GEDrawingPanel extends JPanel {
	private MouseDrawingHandler drawingHandler;
	private GEShape currentShape;
	private ArrayList<GEShape> shapeList;  //************

	//private EState currentState;
	public GEDrawingPanel(){
		super();
		shapeList= new ArrayList<GEShape>();
		drawingHandler = new MouseDrawingHandler();
		addMouseListener(drawingHandler);
		addMouseMotionListener(drawingHandler);
		this.setForeground(GEConstants.FORGROUD_COLOR);
		this.setBackground(GEConstants.BACKGROUD_COLOR);
		
	}
	/**********/
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2D=(Graphics2D)g;           //????????????????????????????
		for(GEShape shape:shapeList)
			shape.draw(g2D);
	}
	/**********/
	
	public void setCurrentShape(GEShape currentShape){
		this.currentShape=currentShape;
	}
	
	private void initDraw(Point startP){
		currentShape = currentShape.clone();
		currentShape.initDraw(startP);			//다형성!!
	}
	private void animateDraw(Point currentP){
		Graphics2D g2D= ( Graphics2D)getGraphics();
		g2D.setXORMode(g2D.getBackground()); //잔상 지우기
		
		currentShape.draw(g2D);
		currentShape.setCoordinate(currentP);
		currentShape.draw(g2D);
	}
	private void finishDraw(GEShape shape){
		shapeList.add(shape);
	}
	
	//컨티뉴드로윙이라는 함수 추가.1120
	
	private class MouseDrawingHandler extends MouseInputAdapter{
		public void mousePressed(MouseEvent e){
			initDraw(e.getPoint());
			//추가1 120
			/*if
				if
				else*/
		}
		public void mouseDragged(MouseEvent e){
		// if(currentState!=EState.Idle){1120
			animateDraw(e.getPoint());
		}
		
		public void mouseReleased(MouseEvent e){
			//if(currentState==EState.TwoPintsDrawing1120
			finishDraw(currentShape);
		}
		//무브드if currentState==estate.npointsdrawing,클릭드함수(클릭1한번인지2번인지) 추가 1120
	}
}
