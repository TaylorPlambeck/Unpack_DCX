
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// This is used to automatically unpack the .DCX files
		String location=System.getProperty("user.dir");
		System.out.println("\nSearching for DCX files in: "+location); // location of JAR
		String fileDirectory =location;
		File dir = new File(fileDirectory);
		String fileName="";
		String command="";
		List<String> list = Arrays.asList(dir.list(
		   new FilenameFilter() {
		      @Override public boolean accept(File dir, String name) {
		         return name.endsWith(".dcx");
		      }
		   }
		));
		System.out.println(list); //output list
		System.out.println("\nNumber of files found: "+list.size()+"\n");
		
		fileName=list.get(0);
		command="BinderTool "+fileName;
		
		
		for(int i =1; i<list.size(); i++) {
		    try {
		    	//command="BinderTool ";
		    	fileName=list.get(i);   		
		    	//command+=fileName;
		    	
		    	command+=" && BinderTool "+fileName;

		    } 
		    catch (Exception e) {
		        e.printStackTrace();
		    }
    	} //end loop
		
		try {
			Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start","cmd.exe","/K",command});
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("...Done!\n");
	} //end of main
} // END OF MAIN class  -----


// Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start","cmd.exe","/c","BinderTool c0000.anibnd.dcx"});
// above was used before i figured out. just keeping it handy



//ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","start","cmd.exe","/c",command);
//pb=pb.directory(new File(fileDirectory));
//pb.start();

// before we do the cmd.exe we need to package up bindertool in the jar and extract it

//boolean copying=true;
//
//
////gets program.exe from inside the JAR file as an input stream
//InputStream is, is1,is2,is3,is4,is5;
//try {
//	is = Main.class.getResource("BinderTool.exe").openStream();
//	is1 = Main.class.getResource("BinderTool.Core.dll").openStream();
////	is = Main.class.getResource("BinderTool.exe").openStream();
////	is = Main.class.getResource("BinderTool.exe").openStream();
////	is = Main.class.getResource("BinderTool.exe").openStream();
////	is = Main.class.getResource("BinderTool.exe").openStream();
//	
//	//sets the output stream to a system folder
//	OutputStream os = new FileOutputStream("BinderTool.exe");
//	OutputStream os1 = new FileOutputStream("BinderTool.Core.dll");
////	os = new FileOutputStream("BinderTool.exe");
////	os = new FileOutputStream("BinderTool.exe");
////	os = new FileOutputStream("BinderTool.exe");
////	os = new FileOutputStream("BinderTool.exe");
//	
//
//	//2048 here is just my preference
//	byte[] b = new byte[2048];
//	int length;
//
//	while ((length = is.read(b)) != -1) {
//	    os.write(b, 0, length);
//	    os1.write(b, 0, length);
//	}
//	
//	copying=false;
//	is.close();
//	os.close();
//	is1.close();
//	os1.close();
//	
//} catch (IOException | InterruptedException e1) {
//	// TODO Auto-generated catch block
//	e1.printStackTrace();
//}
//
//while(copying) {
//	System.out.println("...copy\n");
//}

