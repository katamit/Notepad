import java.io.File;
import javax.swing.filechooser.FileFilter;   

 class HtmlSaveFilter extends FileFilter
 { 
    public boolean accept(File f)
   {
        if (f.isDirectory())
          {
            return false;
          }

         String s = f.getName();

        return s.endsWith(".html")|| s.endsWith(".HTML");
   }

   public String getDescription() 
  {
	 return "Hyper Text Markup Language *.html";
  }

}