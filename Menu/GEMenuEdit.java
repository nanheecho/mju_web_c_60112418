package Menu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.EEditMenuItems;
import constants.GEConstants.EFileItems;
public class GEMenuEdit extends JMenu {
	public GEMenuEdit(String label){
		super(label);
		for(EEditMenuItems btn : EEditMenuItems.values()){
			JMenuItem menuItem=new JMenuItem(btn.toString());
			this.add(menuItem);
		}
	}
}
