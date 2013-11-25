
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.BorderLayout;


class NewListener implements ActionListener
{
	Design design;

	NewListener(Design d)
	{
		design = d;		
		
		
	}
	/*public void actionPerformed(ActionEvent e)
	{
		System.out.println("New file button pressed");
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("java","class");
		
		chooser.setFileFilter(fnef);
		text = new JTextArea();
		scrollPane = new JScrollPane(text);
		frame.add(scrollPane);
	}*/
	public void actionPerformed(ActionEvent e)
				{
		System.out.println("New file button pressed");
		OpenListener.file = null;
		design.frame.setTitle("My"+"  Notepad");
	
		design.frame.remove(design.scrollPane);
		design.textArea = new JTextArea();
		design.textArea.setFont(new Font(design.fonttype,design.fontstyle,design.fontsize));
		design.scrollPane = new JScrollPane(design.textArea);
		design.frame.add(design.scrollPane, BorderLayout.CENTER);
		design.frame.setVisible(true);
			}
					
}