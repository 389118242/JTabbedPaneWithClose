package rung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbedPanelWithClose extends JTabbedPane{
	
	public JTabbedPanelWithClose(){
	}
	public JTabbedPanelWithClose(int tabPlacement){
		this.setTabPlacement(tabPlacement); 
	}
	public JTabbedPanelWithClose(int tabPlacement,int tabLayoutPolicy){
		this.setTabPlacement(tabPlacement); 
		this.setTabLayoutPolicy(tabLayoutPolicy);
	}

	public void addTabWithClose(String title, Component component) {
		addTab(title, component);
		int index=indexOfComponent(component);
		setTabComponentAt(index, getJPanelWithClose(index, title));
		
	}
	
	private JPanel getJPanelWithClose(int index,String text){
		JPanel jpanel=new JPanel();
		BorderLayout bl=new BorderLayout();
		bl.setHgap(9);
		jpanel.setLayout(bl);
		JLabel textJL=new JLabel(text);
		JLabel close=new JLabel("×");
		JLabel up=new JLabel("   ");
		up.setFont(new Font("楷体",Font.BOLD,1));
		jpanel.add(up, BorderLayout.NORTH);
		close.setFont(new Font("黑体", Font.BOLD, 13));
		JTabbedPane jtp=this;
		close.setBackground(Color.RED);
		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jtp.remove(index);
			}
			public void mouseEntered(MouseEvent e) {
				setJLabel(close);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setJLabel(close);
			}
			
			private void setJLabel(JLabel jlbael){
				jlbael.setOpaque(!jlbael.isOpaque());
				jlbael.setText("");
				jlbael.setText("×");
			}
		});
		jpanel.add(textJL,BorderLayout.CENTER);
		jpanel.add(close, BorderLayout.EAST);
		jpanel.setBackground(new Color(0, 0, 0, 0));//仅限于JDK7
		System.out.println(textJL.getHeight()+"   "+close.getHeight());
		return jpanel;
	}

}
