package constants;

import java.awt.Color;

public class GEConstants {

	/**
	 * @param args
	 */
	//���������ӿ��� �� ��� ���� //���̸���������
	public static final int width_mainframe =400;
	public static final int height_mainframe =600;
	public static final String title_mainframe ="�׷��� ������";	
	
	//400 600���� ����//���̸޴�
	public static final String TITLE_FILEMENU="����";
	public static final String TITLE_EDITMENU="����";
	public static final String TITLE_COLORMENU="�÷�";
	
	public static enum EFileItems {���θ����,����,����,�ٸ��̸���������,����};
	public static enum EEditMenuItems{undo,redo,����,�߶󳻱�,����,���̱�,�׷�,�׷�����};
	public static enum EColorMenuItems{SetLineColor,ClearLineColor,SetFillColor,ClearFillColor};
	
	//���ٿ��ʿ��� ����� �߰��ϱ�

	public static final String TITLE_SHAPETOOLBAR="shape tools";
	public static final int WIDTH_SHPETOOLBAR=30;
	public static final int HEIGHT_SHPETOOLBAR=200;
	public static enum EToolBarButtons{Select,Rectangle,Line,Ellipse,Polygon};
	public static final String IMG_URL="images/"; //������ ������ �̹�����...
	public static final String SUFFIX_TOOLBAR_BTN=".gif";
	public static final String SUFFIX_TOOLBAR_BTN_SLT="SLT.gif";
	
	//gedrawingpanel ����߰�
	public static final Color FORGROUD_COLOR = Color.BLACK;
	public static final Color BACKGROUD_COLOR = Color.WHITE;
	public static enum EState{Idle,TwoPointsDrawing,NPointsDrawing}
	public final static Color COLOR_LINE_DEFAULT=Color.BLACK;
	public final static Color COLOR_FILL_DEFAULT=Color.WHITE;
	
	//GEANCHORLIST
	public static final int ANCHOR_W=6;
	public static final int ANCHOR_H=6;
	public static final int RR_OFFSET=40;
	public static final Color ANCHOR_LINECOLOR=Color.BLACK;
	public static final Color ANCHOR_FILLCOLOR=Color.WHITE;
	public static enum EAnchorTypes{NW,NN,NE,WW,EE,SW,SS,SE,RR,NONE}
	
	//GEMENUCOLOR
	public static final String FILLCOLOR_TITLE="selected fill color";
	public static final String LINECOLOR_TITLE="selected line color";
	//getransformer
	public final static int DEFAULT_DASH_OFFSET=4;
	public final static int DEFAULT_DASHDLINE_WIDTH=1;
	

}
