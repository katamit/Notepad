import java.io.File;
import javax.swing.filechooser.FileFilter;   

 class JavaSaveFilter extends FileFilter
 { 
    public boolean accept(File f)
   {
        if (f.isDirectory())
          {
            return false;
          }

         String s = f.getName();

        return s.endsWith(".java");
   }

   public String getDescription() 
  {
	 return "Java File *.java";
  }

}