package constants;

import java.awt.Color;

public class GEConstants {

	/**
	 * @param args
	 */
	//메인프레임에서 쓸 상수 정의 //쥐이메인프레임
	public static final int width_mainframe =400;
	public static final int height_mainframe =600;
	public static final String title_mainframe ="그래픽 에디터";	
	
	//400 600으로 설정//쥐이메뉴
	public static final String TITLE_FILEMENU="파일";
	public static final String TITLE_EDITMENU="편집";
	public static final String TITLE_COLORMENU="컬러";
	
	public static enum EFileItems {새로만들기,열기,저장,다름이름으로저장,종료};
	public static enum EEditMenuItems{undo,redo,삭제,잘라내기,복사,붙이기,그룹,그룹해제};
	public static enum EColorMenuItems{SetLineColor,ClearLineColor,SetFillColor,ClearFillColor};
	
	//툴바에필요한 상수들 추가하기

	public static final String TITLE_SHAPETOOLBAR="shape tools";
	public static final int WIDTH_SHPETOOLBAR=30;
	public static final int HEIGHT_SHPETOOLBAR=200;
	public static enum EToolBarButtons{Select,Rectangle,Line,Ellipse,Polygon};
	public static final String IMG_URL="images/"; //이폴더 하위에 이미지들...
	public static final String SUFFIX_TOOLBAR_BTN=".gif";
	public static final String SUFFIX_TOOLBAR_BTN_SLT="SLT.gif";
	
	//gedrawingpanel 상속추가
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
