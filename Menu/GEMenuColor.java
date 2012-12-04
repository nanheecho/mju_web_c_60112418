package Menu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.EColorMenuItems;
import constants.GEConstants.EFileItems;
public class GEMenuColor extends JMenu {
	public GEMenuColor(String label){
		super(label);
		for(EColorMenuItems btn : EColorMenuItems.values()){
			JMenuItem menuItem=new JMenuItem(btn.toString());
			this.add(menuItem);
		}
	}
}
