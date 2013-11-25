
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class Design
{
	JFrame frame;
	JLabel label;
	
	//BorderLayout  border;
	
	//JPanel upperPanel;
	//JSeparator upperLabel;
	JMenuBar menubar;
	JMenu file,edit,format,view, compile, run, help;
	
	
	JMenuItem newfile, open, save, save_As, exit;
	JMenuItem undo, cut, copy, paste, find, select_all;
	
	
	JMenuItem wordwrap, font;
	JMenuItem viewHelp, aboutNotepad;
	
	
	
	JScrollPane scrollPane;
	JTextArea textArea;
	
	
	String fonttype = "Times New Roman";
	int fontstyle = Font.LAYOUT_LEFT_TO_RIGHT;
	int fontsize = 18;
	protected Design()
	{
//setting the look and feel
try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }	
	
	
//Here definition of items is performed	

		menubar = new JMenuBar();
	
	//file menu	
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		
		
	//Menu items of file
		newfile = new JMenuItem("New                              ",KeyEvent.VK_N);
		newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK));
		
		open = new JMenuItem("Open                     ",KeyEvent.VK_O);
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK));		
		
		save = new JMenuItem("Save                       ",KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));
		
		save_As = new JMenuItem("Save_As                 ");
		//newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));
		
		
		exit = new JMenuItem("Exit      ",KeyEvent.VK_F4);
		//New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));
		
		file.add(newfile);
		file.add(open);
		file.add(save);
		file.add(save_As);
		file.add(exit);
		
	//Listener to file menu items
		// 1.  Listener of new
		
		//NewListener new1 = new NewListener(this);
		//newfile.addActionListener(new1);
		/*newfile.addActionListener(new ActionListener()
					{
							public void actionPerformed(ActionEvent e)
				{
		System.out.println("New file button pressed");
	
		frame.remove(scrollPane);
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial Narrow",Font.PLAIN,18));
		scrollPane = new JScrollPane(textArea);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
			}
					});*/
		
		
	//edit menu
		edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
	//Menu item of Edit
		
		undo = new JMenuItem("Undo                              ",KeyEvent.VK_Z);
		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,Event.CTRL_MASK));
		
		cut = new JMenuItem("Cut                             ",KeyEvent.VK_X);
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.CTRL_MASK));
		
		copy = new JMenuItem("Copy                             ",KeyEvent.VK_C);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,Event.CTRL_MASK));
		
		
		paste = new JMenuItem("Paste                             ",KeyEvent.VK_V);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,Event.CTRL_MASK));
		
		find = new JMenuItem("Find...                             ",KeyEvent.VK_F);
		find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,Event.CTRL_MASK));
		
		select_all = new JMenuItem("Select All                        ",KeyEvent.VK_A);
		select_all.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,Event.CTRL_MASK));
		
		edit.add(undo);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(find);
		edit.add(select_all);
	
	//format menu
		format = new JMenu("Format");
		format.setMnemonic(KeyEvent.VK_O);

	//Menu items of format menu
		wordwrap = new JMenuItem("Word wrap");
		font = new JMenuItem("Font");
		
		
		format.add(wordwrap);
		format.add(font);		
	
	//view menu
		view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_V);
		
	
	//help menu
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		
	//Menu Items of help
		viewHelp = new JMenuItem("       View Help                          ");
		aboutNotepad = new JMenuItem("       About MyNotepad");
		
		
		help.add(viewHelp);
		help.add(aboutNotepad);
	
	
	//compile menu
		compile = new JMenu("Compile");
		compile.setMnemonic(KeyEvent.VK_C);
		
	
	//run menu
		run = new JMenu("Run   ");
		run.setMnemonic(KeyEvent.VK_R);
		//run.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,Event.CTRL_MASK));
		
	//adding menus to the menuBar
		menubar.add(file);
		menubar.add(edit);
		menubar.add(format);
		menubar.add(view);
		menubar.add(compile);
		menubar.add(run);
		menubar.add(help);
		
		
//Centre part of notepad
		textArea = new JTextArea();
		textArea.setFont(new Font(fonttype,fontstyle,fontsize));
		scrollPane = new JScrollPane(textArea);
		
		
		//upperPanel = new JPanel(new FlowLayout());
		//upperLabel = new JSeparator(SwingConstants.HORIZONTAL);

//Lower items of the notepd



//Declaration of the frame
		frame = new JFrame("MyNotepad");
		frame.setSize(800,550);
		frame.setLayout(new BorderLayout());
//Here items are added to frame
		frame.add(menubar, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		
		

		
//Ending the Frame		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jf.add(p2,BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setLocation(150,100);
		//jf.pack();		
	}
	/*public static void main(String ... ar)
	{
		new Design();
	}*/
}