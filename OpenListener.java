import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




class OpenListener implements ActionListener
{
	Design design;
	static File file;
	BufferedReader buffer;
	OpenListener(Design d)
	{
		design = d;
	}
	
	
	public void actionPerformed(ActionEvent e)
	{	
		//new NewListener(design).actionPerformed(e);
		System.out.println("open button pressed");
		JFileChooser jfc = new JFileChooser();
	
//adding file filters	
	
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Normal text file(*.txt)","txt");
		FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Hyper Text MarkUp Language(*.html)","html");
		FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Java(*.java)","java");
		FileNameExtensionFilter filter3 = new FileNameExtensionFilter("Extensible MarkUp Language(*.xml)","xml","XML");
		
		
		jfc.setFileFilter(filter1);
		
		jfc.setFileFilter(filter3);
		jfc.setFileFilter(filter);
		jfc.setFileFilter(filter2);
		
//Reading file
		int returnValue = jfc.showOpenDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION)
		{
			new NewListener(design).actionPerformed(e);
			try
			{
			
			file = jfc.getSelectedFile();
			//FileReader buffer = new FileReader(file);
			buffer = new BufferedReader(new FileReader(file));
			}
			catch(FileNotFoundException f)
			{
				System.err.println("The selected file in not found");
			}
			try
			{
			StringBuilder s = new StringBuilder();
			String s1 = "";
			while((s1 = buffer.readLine()) != null)
			{
				s.append(s1);
				s.append("\n");
				
			}
			buffer.close();
			design.textArea.append(new String(s));
			design.frame.setTitle(file.getName()+"  Notepad");
			}
			catch(IOException i)
			{
				System.err.println("Ioexception roported while reading the file");
			}
			
			
			
		}
	}
}