package rung;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class myTestMain {

	public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setBounds(500, 300, 900, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPanelWithClose jt=new JTabbedPanelWithClose();
		jf.add(jt);
		jt.addTabWithClose("这是标题", new JLabel("您好，朋友！"));
		jf.setVisible(true);
	}

}
