package frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import Menu.GEMenuBar;
import constants.GEConstants;

///////import 추가! 쥐이메뉴바추가햇으니까
public class GEMainFrame extends JFrame{ //제이프래임 상속받기

		private static GEMainFrame uniaueMainFrame= new GEMainFrame(GEConstants.title_mainframe);
		private GEDrawingPanel drawingpanel;
		private GEMenuBar menuBar;
		private GEToolBar shapeToolbar; //##
		
		
		private GEMainFrame(String title){
			super(title);
			drawingpanel=new GEDrawingPanel();
			add(drawingpanel);
			
			menuBar=new GEMenuBar();
			setJMenuBar(menuBar);
			
			shapeToolbar = new GEToolBar(GEConstants.TITLE_SHAPETOOLBAR); //##
			add(BorderLayout.NORTH, shapeToolbar); //##
		}
		
		
	
		public static GEMainFrame getInstance(){
			return uniaueMainFrame;
		 
		}

		public  void init(){
			shapeToolbar.init(drawingpanel);  //버튼이 눌리면 드로잉패널에게 그도형 알려줌
			
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setSize(GEConstants.width_mainframe,GEConstants.height_mainframe);
			setVisible(true);
		}
	
}