package project2;
import java.io.*;

public class Parse {

	public static void main(String[] args) throws FileNotFoundException {
		String inputFile;
		Decoder decode = new Decoder();
		try {
		inputFile = args[0];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Please enter a binary file to parse");
			return;
		}
		
		int byte_read = 0;
		try {
			InputStream inputStream = new FileInputStream("assignment1.machine");
			while(inputStream.available() > 0)
			{
				byte_read = inputStream.read();
				String binary = String.format("%"+8+"s",Integer.toBinaryString(byte_read))
					.replaceAll(" ", "0");
				
				byte_read = inputStream.read();
				binary += String.format("%"+8+"s",Integer.toBinaryString(byte_read))
					.replaceAll(" ", "0");
				
				byte_read += inputStream.read();
				binary += String.format("%"+8+"s",Integer.toBinaryString(byte_read))
					.replaceAll(" ", "0");
				
				byte_read = inputStream.read();
				binary += String.format("%"+8+"s",Integer.toBinaryString(byte_read))
					.replaceAll(" ", "0");
				inputStream.skip(4);
				decode.getInstuction(binary);
				break;
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
