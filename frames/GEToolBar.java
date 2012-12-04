package frames;

import javax.swing.AbstractButton;
import javax.swing.JToolBar;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import constants.GEConstants;
import constants.GEConstants.EToolBarButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import shapes.GEEllipse;
import shapes.GERectangle;
import shapes.GELine;
import shapes.GEPolygon;

public class GEToolBar extends JToolBar {
	private GEDrawingPanel drawingPanel;
	private GEToolBarHandler shapeToolBarHandler; //위 2개가 추가된 이유!!!!!!중요!
	
	private ButtonGroup buttonGroup;
	public GEToolBar(String label){
		super(label);
		buttonGroup = new ButtonGroup();
		JRadioButton rButton=null;
		
		shapeToolBarHandler = new GEToolBarHandler();////
		for(EToolBarButtons btn: EToolBarButtons.values()){
			rButton = new JRadioButton();
			rButton.setIcon(new ImageIcon(GEConstants.IMG_URL +btn.toString()+GEConstants.SUFFIX_TOOLBAR_BTN));
			rButton.setSelectedIcon(new ImageIcon(GEConstants.IMG_URL +btn.toString()+GEConstants.SUFFIX_TOOLBAR_BTN_SLT));
			rButton.addActionListener(shapeToolBarHandler); //envethandler랑 연결후 버튼 붙이기   
			rButton.setActionCommand(btn.toString()); //이름 지정해주기
			this.add(rButton);
			buttonGroup.add(rButton);
			
		}
	}
	public void init(GEDrawingPanel dp){
		drawingPanel = dp;
		setSize(GEConstants.WIDTH_SHPETOOLBAR,GEConstants.HEIGHT_SHPETOOLBAR);
		clickDefaultButton();
	}
	
	private void clickDefaultButton(){
		JRadioButton rButton= (JRadioButton)this.getComponent(EToolBarButtons.Rectangle.ordinal());
		rButton.doClick();
	}
	private class GEToolBarHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JRadioButton button = (JRadioButton)e.getSource();
			if(button.getActionCommand().equals(EToolBarButtons.Rectangle.name())){
				drawingPanel.setCurrentShape(new GERectangle());
			}else if(button.getActionCommand().equals(EToolBarButtons.Ellipse.name())){
				drawingPanel.setCurrentShape(new GEEllipse());
			}else if(button.getActionCommand().equals(EToolBarButtons.Line.name())){
				drawingPanel.setCurrentShape(new GELine());
	//1120
			}else if(button.getActionCommand().equals(EToolBarButtons.Polygon.name())){
				drawingPanel.setCurrentShape(new GEPolygon());
			}else if(button.getActionCommand().equals(EToolBarButtons.Select.toString())){
				drawingPanel.setCurrentShape(null);
			}
		}
	}

}
