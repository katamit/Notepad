
 import java.io.File;
 import javax.swing.filechooser.FileFilter; 
 
 class TxtSaveFilter extends FileFilter
 { 
    public boolean accept(File f)
   {
        if (f.isDirectory())
          {
            return false;
          }

         String s = f.getName();

        return s.endsWith(".txt");
   }

   public String getDescription() 
  {
	 return "Text Document *.txt";
  }

}