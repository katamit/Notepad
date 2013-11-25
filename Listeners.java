
class Listeners extends Design

{
	Listeners()
	{
	
		
		
	//Listener to file menu items
		// 1.  Listener of new
		
		//NewListener new1 = new NewListener(this);
		newfile.addActionListener(new NewListener(this));
		
		// 2. listener to open menuitem
		open.addActionListener(new OpenListener(this));
		
		// 3. Listener to save menuItem
		save.addActionListener(new SaveListener(this));
		
		//4. Listener to saveAS
			save_As.addActionListener(new SaveListener(this));
			
			
	//Listener to format meut items
	
		// 1. Listener to wordwrap
		
		//2. Listener to font
			font.addActionListener(new FontListener(this));
	}
	
	public static void main(String ... ar)
	{
		new Listeners();
	}
}