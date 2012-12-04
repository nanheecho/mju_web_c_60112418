package Menu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import constants.GEConstants.EFileItems;
public class GEMenuFile extends JMenu {
	public GEMenuFile(String label){
		super(label);
		for(EFileItems btn : EFileItems.values()){//EFileMenuItems
			JMenuItem menuItem=new JMenuItem(btn.toString());
			this.add(menuItem);
		}
	}
}
