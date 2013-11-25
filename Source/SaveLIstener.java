/*
	This file is Listener to both save and save_As menuItems


*/


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class SaveListener implements ActionListener
{
	File outputfile;
	Design design;
	SaveListener(Design d)
	{
		design = d;
	}

	public void actionPerformed(ActionEvent e) 
	{
		
		System.out.println("save button is pressed");
		/*if(e.getSource() == design.save)
			System.out.println("save event");
		if(e.getSource() == design.save_As)
			System.out.println("save_AS event");	
	*/
	//this help in saving a opened file with the same name bypassing the file chooser
	//only when it is save using option ctrl + s or save option from file menu
		if(OpenListener.file != null && e.getSource() == design.save )
		{
			outputfile = OpenListener.file;
			String s = design.textArea.getText();
			
			try
				{
					BufferedWriter buffer = new BufferedWriter(new FileWriter(outputfile));
					buffer.write(s);
					buffer.close();
				}
				catch(FileNotFoundException f)
				{
					System.err.println("Specified file is not found");
				}
				
				catch(IOException I)
				{
					System.err.println("IOException is thrown");
				}
			
		}
		
	//The following code is for saving a new file whether using ctrl+ s or save_As option
	//it always saves a new file 
		else
		{
			
		JFileChooser jfc = new JFileChooser();

//adding file filters

		/*FileNameExtensionFilter filter = new FileNameExtensionFilter("Normal text file(*.txt)","txt");
		FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Hyper Text MarkUp Language(*.html)","html");
		FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Java(*.java)","java");


		jfc.setFileFilter(filter1);

		jfc.setFileFilter(filter);
		jfc.setFileFilter(filter2);
		
		
		
		
		*/
		jfc.addChoosableFileFilter(new TxtSaveFilter());
		jfc.addChoosableFileFilter(new JavaSaveFilter());
		jfc.addChoosableFileFilter(new HtmlSaveFilter());
		jfc.addChoosableFileFilter(new XmlSaveFilter());
		
		
//setting default file Name	
		outputfile = new File("untitled.java");
		
		 
		
		
		jfc.setSelectedFile(outputfile);
		int returnVal = jfc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
                outputfile = jfc.getSelectedFile();
				/*try
				{
				
				System.out.println("Parent"+ outputfile.getParent());
				System.out.println("absoulute path   "+outputfile.getAbsolutePath());
				System.out.println("canonicla path    "+outputfile.getCanonicalPath());
				System.out.println("path   "+outputfile.getPath());
				
				System.out.println("abs after modfi"+ outputfile.getAbsolutePath());
				}
				
				catch(IOException N){}*/
				
				
				
				String extension= jfc.getFileFilter().getDescription();
				
				outputfile = filebuilder(outputfile, extension);
				
				
				OpenListener.file = outputfile;//This marks is newly created and saved file 
				//as currently opened also
				System.out.println("The file save is   "+outputfile.getName());
				
				String s = design.textArea.getText();
				System.out.println(s);
				design.frame.setTitle(outputfile.getName()+"  Notepad");
				try
				{
					System.out.println("Try block executed");
					BufferedWriter buffer = new BufferedWriter(new FileWriter(outputfile));
					buffer.write(s);
					buffer.close();
				}
				
				catch(FileNotFoundException f)
				{
					System.err.println("Specified file is not found");
				}
				
				catch(IOException I)
				{
					System.err.println("IOException is thrown");
				}
				
		}
		}

	}
	
//This funtion gives the complete path with extension as selected in the file chooser	
	private File filebuilder(File file, String extension )
	{
		if (extension == "Hyper Text Markup Language *.html")
					return new File(file.getParent(), file.getName()+".html");
				
		if (extension == "Extensible MarkupLanguage  *.xml")
					return new File(file.getParent(), file.getName()+".xml");
					
		if (extension == "Java File *.java")
					return new File(file.getParent(), file.getName()+".java");
					
		if (extension == "Text Document *.txt")
					return new File(file.getParent(), file.getName()+".txt");
					
		return file;
	}


}