package project2;
import java.io.*;
import java.util.ArrayList;

public class Parse {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> assemblyCode = new ArrayList<>();
		String inputFile;
		Decoder dec = new Decoder();
		try {
		inputFile = args[0];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Please enter a binary file to parse");
			return;
		}
		
		int byte_read = 0;
		try {
			InputStream inputStream = new FileInputStream(inputFile);
			while(inputStream.available() > 0)
			{
				byte_read = inputStream.read();
				String binary = String.format("%"+8+"s",Integer.toBinaryString(byte_read))
					.replaceAll(" ", "0");
				
				byte_read = inputStream.read();
				binary += String.format("%"+8+"s",Integer.toBinaryString(byte_read))
					.replaceAll(" ", "0");
				
				byte_read = inputStream.read();
				binary += String.format("%"+8+"s",Integer.toBinaryString(byte_read))
					.replaceAll(" ", "0");
				
				byte_read = inputStream.read();
				binary += String.format("%"+8+"s",Integer.toBinaryString(byte_read))
					.replaceAll(" ", "0");
				dec.decode(binary);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	    assemblyCode = dec.getAssembly();
		for(int i = 0; i < assemblyCode.size(); i++)
		{
			System.out.println(assemblyCode.get(i));
		}
	}
	
}
