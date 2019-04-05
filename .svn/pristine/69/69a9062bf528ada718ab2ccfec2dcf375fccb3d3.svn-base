package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import app.MyApp;
import model.Dokument;

public class Serialization {

	public static void saveDokument(Dokument dok,File path) throws FileNotFoundException, IOException{
		FileOutputStream fos=new FileOutputStream(path);
		ObjectOutputStream os = new ObjectOutputStream(fos);
		try {
			os.writeObject(dok);
			
			os.flush();
		}
		
		catch (Exception e) {
		}
		
		finally {
			os.close();
		}
	}
	
	public static Dokument openDokument(File path) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fos=new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fos);
		Dokument dok=new Dokument("Dokument");
		try {
			dok=(Dokument) ois.readObject();
			return dok;
		}catch(Exception e){}
	    finally {
			ois.close();
		}
		return dok;
	}
	public static void SaveSlobodneElemente()throws FileNotFoundException, IOException{
		
		
		File novFile=new File("slobodni_elementi"+".col");
		new File("slobodni_elementi"+".col").mkdirs();
		for(Dokument dok : MyApp.getInstance().getSlobodniDokumenti()){
			try {
				File ff=new File("slobodni_elementi"+".col"+"\\"+dok.getName()+".dok");
				Serialization.saveDokument(dok,ff);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	}
	public static void OpenSlobodneElemente()throws FileNotFoundException, IOException, ClassNotFoundException{
		File f2=new File("slobodni_elementi"+".col");
		
		File[] listOfFiles=f2.listFiles();
		 try {
			 for(int i=0;i<listOfFiles.length; i++){
					String ime=listOfFiles[i].getName();
					Dokument d=Serialization.openDokument(new File(f2.toString()+"\\"+ime));
					MyApp.getInstance().getSlobodniDokumenti().add(d);
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
			

		
		
		
	}

}