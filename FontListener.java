import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.Border;



class FontListener implements ActionListener, ListSelectionListener
{
	Design design;
	
	String font, style;
			int stylevalue = Font.PLAIN;
			int size =15;
	
	String sample = "AaBbYyZz159";
	
	JFrame frame;
	JTextField fontfield, stylefield, sizefield;
	JLabel fontlabel, stylelabel,sizelabel;
	JList fontlist, stylelist, sizelist;
	JPanel upperpanel, middlepanel,samplelowerpanel,lowerpanel;
	
	JTextArea samplearea = new JTextArea(1,5);
	
	JScrollPane fontlistpane, stylelistpane, sizelistpane;
	
	JButton ok, close;

	
	
	FontListener(Design d)
	{
		 	design = d;
			
	/*}
	private void Makingframe()
	{*/
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
		
		upperpanel = new JPanel();
		middlepanel = new JPanel();
		upperpanel.setLayout(new GridLayout(2,3,4,4));
		middlepanel.setLayout(new GridLayout(1,3,1,1));
		
		
		frame = new JFrame("Font");
		frame.setLayout(new BorderLayout());
		
		fontlabel = new JLabel("   Font:");
		stylelabel= new JLabel(" Font Style:");
		sizelabel= new JLabel(" Font Size:");
		
		fontfield = new JTextField();
		stylefield = new JTextField();
		sizefield = new JTextField();
		
		upperpanel.add(fontlabel);
		upperpanel.add(stylelabel);
		upperpanel.add(sizelabel);
		
		upperpanel.add(fontfield);
		upperpanel.add(stylefield);
		upperpanel.add(sizefield);
		
//The middle panel
		String []arr = {"Agency FB","Algerian","Arial","Arial Rounded MT","Baskerville Old Face",
						"Bauhaus 93","Bell MT","Berlin Sans FB","Bernard MT","Blackadder ITC",
						"Bodoni MT","Bodoni MT Poster","Book Antiqua","Bookman Old Style",
						"Bookshelf Symbol 7","Bradley Hand ITC","Britannic","Broadway","Brush Script MT"
						,"Calibri","Californian FB","Calisto MT","Cambria","Cambria Math","Candara",
						"Castellar",
						"Centaur","Century","Century Gothic","Century Schoolbook","Chiller","Colonna MT",
						"Comic Sans MS","Consolas","Constantia","Cooper","Copperplate Gothic"
						,"Corbel","Courier","Courier New","Curlz MT","Edwardian Script ITC"
						,"Elephant","Engravers MT","Eras ITC","Felix Titling","Fixedsys",
						"Footlight MT","Forte","Franklin Gothic","Franklin Gothic Book",
						"Freestyle Script","French Script MT","Gabriola","Gadugi","Garamond"
						,"Georgia","Gigi","Gill Sans","Gill Sans MT","Gloucester MT","Goudy Old Style",
						"Haettenschweiler","Harlow Solid","Harrington","High Tower Text","Impact",
						"Imprint MT Shadow","Informal Roman","Jokerman","Juice ITC","Kristen ITC",
						"Kunstler Script","Latin","Lucida Bright","Lucida Calligraphy",
						"Lucida Console","Lucida Fax","Lucida Handwriting","Lucida Sans","Lucida Sans Typewriter"
						,"Lucida Sans Unicode","Magneto","Maiandra GD","Matura MT Script Capitals",
						"Microsoft JhengHei UI","Microsoft Sans Serif","Microsoft YaHei UI","Mistral","Modern",
						"Modern No. 20","Monotype Corsiva","MS Reference Sans Serif","MS Reference Specialty"
						,"MS Sans Serif","MS Serif","MT Extra","Niagara Engraved","Niagara Solid","Niagara Solid",
						"Nirmala UI","OCR A","Old English Text MT","Onyx","Palace Script MT","Palatino Linotype",
						"Papyrus","Parchment","Perpetua","Perpetua Titling MT","Playbill","Poor Richard","Pristina"
						,"Rage","Ravie","Rockwell","Roman","Script","Script MT","Segoe Print","Segoe Script"
						,"Segoe UI","Segoe UI Symbol","Showcard Gothic","Small Fonts","Snap ITC","Stencil"
						,"Symbol","System","Tahoma","Tempus Sans ITC","Terminal","Times New Roman","Trebuchet MS"
						,"Tw Cen MT","Verdana","Viner Hand ITC","Vivaldi","Vladimir Script","Webdings","Wingdings"
						,"Wingdings 2","Wingdings 3"};
		String []arr1 = {"Bold","Italic","Plain"};
		Integer arr2[ ] = {6,8,10,11,12,14,16,18,20,22,24,26,28,36,48,72};
		
		
		fontlist = new JList(arr);
		fontlist.setFont(new Font("Serif",Font.PLAIN,15));
		fontlist.setVisibleRowCount(4);
		fontlist.addListSelectionListener(this);
		
		
		stylelist= new JList(arr1);
		stylelist.setFont(new Font("Serif",Font.PLAIN,15));
		stylelist.setVisibleRowCount(4);
		stylelist.addListSelectionListener(this);
		
		
		sizelist = new JList(arr2);
		sizelist.setFont(new Font("Serif",Font.PLAIN,15));
		sizelist.setVisibleRowCount(4);
		sizelist.addListSelectionListener(this);
		
		fontlistpane = new JScrollPane(fontlist);
		stylelistpane = new JScrollPane(stylelist);
		sizelistpane = new JScrollPane(sizelist);
		
		
		middlepanel.add(fontlistpane);
		middlepanel.add(stylelistpane);
		middlepanel.add(sizelistpane);
		
		
//Lower Area
		Border sampleborder = BorderFactory.createTitledBorder("Sample");
		ok = new JButton("Ok");
		close = new JButton("Close");
		ok.addActionListener(new SubFontListener(this));
			close.addActionListener(new SubFontListener(this));
		
		
		
		samplelowerpanel = new JPanel();
		lowerpanel = new JPanel();
		lowerpanel.setLayout(new FlowLayout());
		samplelowerpanel.add(samplearea);
		samplelowerpanel.setBorder(sampleborder);
		
		lowerpanel.add(samplelowerpanel);
		lowerpanel.add(ok);
		lowerpanel.add(close);
		
		
		frame.add(upperpanel, BorderLayout.NORTH);
		frame.add(middlepanel,BorderLayout.CENTER);
		frame.add(lowerpanel, BorderLayout.SOUTH);
		frame.setSize(850,300);
		//frame.pack();
		frame.setLocation(100,100);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
		
		
		
	}
	
		public void valueChanged(ListSelectionEvent event)
		{
		//works list of fonts	
			if(event.getSource() == fontlist)
			{
				font = fontlist.getSelectedValue().toString();
				fontfield.setText(font);
				stylelist.setFont(new Font(font,Font.PLAIN,15));
				samplearea.setFont(new Font(font,stylevalue,size));
				samplearea.setText(sample);
				
			}
		
		//works list of font style
		
			if(event.getSource() == stylelist)
			{
				style = stylelist.getSelectedValue().toString();
				
				stylevalue = StyleValue(style);
				
				
				stylefield.setFont(new Font(font,stylevalue,15));
				stylefield.setText(style);
				samplearea.setFont(new Font(font,stylevalue,size));
				samplearea.setText(sample);
			}
			
		//works list of font size
			
			if(event.getSource() == sizelist)
			{
				Integer int1 =  (Integer)(sizelist.getSelectedValue());
				size = int1.intValue();
				sizefield.setText(sizelist.getSelectedValue().toString());
				
				samplearea.setFont(new Font(font,stylevalue,size));
				samplearea.setText(sample);
				
			}
		}
		
	//The funtion return the Integer value in repected to value selected in font style list
		private int StyleValue(String style)
		{
			if(style == "Bold")
					{
						return Font.BOLD;
					}
			else if(style == "Italic")
					{
						return Font.ITALIC;
					}
			else
					{
						return  Font.PLAIN;
					}
		}
	
		public void Option()
		{
			JOptionPane  jp = new JOptionPane();
			jp.createInternalFrame(frame,"Font");
		}
		
		public void actionPerformed(ActionEvent e)
		{
			/*if(e.getSource() == design.font)
			{*/
				design.frame.setEnabled(false);
			frame.setVisible(true);
			//frame.setEnabled(true);
				//Makingframe();
			/*}
			if(e.getSource() == ok)
			{
				design.fonttype = font;
				design.fontstyle = stylevalue;
				design.fontsize = size;
				
				frame.setVisible(false);
				design.frame.setEnabled(true);
			}
			
			else
			{
				frame.setVisible(false);
				design.frame.setEnabled(false);
			}*/
		}
		/*public static void main(String ... ar)
		{
			new FontListener().Makingframe();
		}*/

}


class SubFontListener implements ActionListener


{
	FontListener font;
	SubFontListener(FontListener f)
	{
		font = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == font.ok)
			{
				font.design.fonttype = font.font;
				font.design.fontstyle = font.stylevalue;
				font.design.fontsize = font.size;
				
				font.frame.setVisible(false);
				font.design.frame.setEnabled(true);
				font.design.textArea.setFont(new Font(font.font,font.stylevalue,font.size));
			}
			
			else
			{
				font.frame.setVisible(false);
				font.design.frame.setEnabled(true);
			}
	}
}