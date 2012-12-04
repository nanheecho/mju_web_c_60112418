package frames;
import javax.swing.JPanel;

import java.awt.Graphics;//paintComponet
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;//shapeList
import javax.swing.event.MouseInputAdapter;
import shapes.GEPolygon;
import shapes.GEShape;
import transformer.GEDrawer;
import transformer.GETransformer;
import constants.GEConstants;
import constants.GEConstants.EState;
import java.awt.Color;
/////////^^^^^^
public class GEDrawingPanel extends JPanel {
	private MouseDrawingHandler drawingHandler;
	private GEShape currentShape,selectedShape;
	private ArrayList<GEShape> shapeList;  //************
	private EState currentState;
	private GETransformer transformer;
	private Color lineColor, fillColor;
	
	public GEDrawingPanel(){
		super();
		currentState=EState.Idle;
		shapeList= new ArrayList<GEShape>();
		drawingHandler = new MouseDrawingHandler();
		addMouseListener(drawingHandler);
		addMouseMotionListener(drawingHandler);
		this.setForeground(GEConstants.FORGROUD_COLOR);
		this.setBackground(GEConstants.BACKGROUD_COLOR);
		
		initializeGraphicsAttribute();
	}
	private void initializeGraphicsAttribute(){
			lineColor= GEConstants.COLOR_LINE_DEFAULT;
			fillColor= GEConstants.COLOR_FILL_DEFAULT;
	}
	public void setLineColor(Color lineColor){
		if(selectedSetColor(true,lineColor)){
			return;
		}
		this.lineColor=lineColor;
	}
	public void setFillColor(Color fillColor){
		if(selectedSetColor(true,fillColor)){
			return;
		}
		this.fillColor=fillColor;
	}
	public boolean selectedSetColor(boolean flag, Color color){
		if(selectedShape!=null){
			if(flag){
			selectedShape.setLineColor(color);
			}else{
				selectedShape.setFillColor(color);
			}
			repaint();
			return true;
		}
		return false;
	}
	
	public void setCurrentShape(GEShape currentShape){
		this.currentShape=currentShape;
	}
	/**********/
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2D=(Graphics2D)g;           
		for(GEShape shape:shapeList){
			shape.draw(g2D);
		}
	}
	/**********/
	
	private void initDraw(Point startP){
		currentShape = currentShape.clone();
		currentShape.setLineColor(lineColor);
		currentShape.setFillColor(fillColor);
		transformer=new GEDrawer(currentShape);
		((GEDrawer)transformer).init(startP);
	}
	
	private void continueDrawing(Point p){
		((GEDrawer)transformer).continueDrawing(p);
	}
	private GEShape onShape(Point p){
		for(int i=shapeList.size();i>0;i--){
			GEShape shape=shapeList.get(i-1);
			if(shape.onShape(p)){
				return(shape);
			}
		}
		return null;
	}
	
	private void clearSeletedShapes(){
		for(GEShape shape:shapeList){
			shape.setSelected(false);
		}
	}
	
	private class MouseDrawingHandler extends MouseInputAdapter{
		public void mousePressed(MouseEvent e){
			if(currentState==EState.Idle){
				if(currentShape!=null){
					clearSeletedShapes();
					selectedShape=null;/////////////////////////////////###
					initDraw(e.getPoint());
					if(currentShape instanceof GEPolygon){
						currentState=EState.NPointsDrawing;
					}else{
						currentState=EState.TwoPointsDrawing;
						}
					}else{
						selectedShape=onShape(e.getPoint());
						if(selectedShape!=null){
							clearSeletedShapes();
							selectedShape.setSelected(true);
						}
					}					
			}
		}
		
		public void mouseMoved(MouseEvent e){
			if(currentState==EState.NPointsDrawing){
				((GEDrawer)transformer).transfomer(/////////////////###
						(Graphics2D)getGraphics(),e.getPoint());
			}
		}
		
		public void mouseDragged(MouseEvent e){
			if(currentState!=EState.Idle){
				transformer.transfomer(
						(Graphics2D)getGraphics(),e.getPoint());
			}
		}
		
		public void mouseReleased(MouseEvent e){
			if(currentState==EState.TwoPointsDrawing){
				((GEDrawer)transformer).finalize(shapeList);
				currentState=EState.Idle;
			}else if(currentState==EState.NPointsDrawing){
				return;
			}
			repaint();
		}
		public void mouseClicked(MouseEvent e){
			if(e.getButton()==MouseEvent.BUTTON1){
				if(currentState==EState.NPointsDrawing){
					if(e.getClickCount()==1){
						continueDrawing(e.getPoint());
					}else if(e.getClickCount()==2){
					((GEDrawer)transformer).finalize(shapeList);
					currentState=EState.Idle;
					repaint();
					}
				}
				
			}
		}
		
	}
}
