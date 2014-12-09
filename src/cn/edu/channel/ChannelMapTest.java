package cn.edu.channel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


public class ChannelMapTest {
	public static void main(String[] args) throws Exception {
		System.out.println((int)'a');
	}

	private static void bytemapper() throws FileNotFoundException, IOException, UnsupportedEncodingException {
		String fileName ="H:/temp/aa.txt";
		long fielSize = new File(fileName).length();
		int bufferSize=1024;
		MappedByteBuffer[] buffers = new MappedByteBuffer[Integer.valueOf((fielSize/bufferSize+1)+"")];
		
		
		long remaining = fielSize;
		
		
		for(int i=0;i<buffers.length;i++){
			RandomAccessFile file = null;
			
			file = new RandomAccessFile(fileName, "r");
			byte[] bts = new byte[1024];
			buffers[i]=file.getChannel().map(FileChannel.MapMode.READ_ONLY, i*bufferSize, Math.min(remaining,bufferSize));
			//buffers[i].flip();
			buffers[i].get(bts);
			System.out.println(new String(bts,"gbk"));
			remaining-=bufferSize;
			if(remaining<=0)break;
		}
	}
}
