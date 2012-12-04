package frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import Menu.GEMenuBar;
import constants.GEConstants;

///////import �߰�! ���̸޴����߰������ϱ�
public class GEMainFrame extends JFrame{ //���������� ��ӹޱ�

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
			shapeToolbar.init(drawingpanel);  //��ư�� ������ ������гο��� �׵��� �˷���
			
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setSize(GEConstants.width_mainframe,GEConstants.height_mainframe);
			setVisible(true);
		}
	
}