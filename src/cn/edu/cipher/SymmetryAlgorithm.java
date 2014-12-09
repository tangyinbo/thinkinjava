package cn.edu.cipher;

import java.io.IOException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class SymmetryAlgorithm {
	
	private static char[] digits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	private static String hexStr =  "0123456789ABCDEF";   
	private Key myKey;
	{
		try {
			Cipher cipher = Cipher.getInstance("AES");
			SecretKey key = KeyGenerator.getInstance("AES").generateKey();
			// 初始化加密算法的密钥
			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] bts = cipher.doFinal("我是中国人".getBytes());
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 生成加密钥匙
	}
	
	
	
	public static void main(String[] args) throws IOException {
		String s ="我是中国人";
		String y = BinaryToHexString(s.getBytes());
		System.out.println(y);
		byte[] bts =HexStringToBinary(y);
		System.out.println(new String(bts));
	}
	
	
	
	
   /**  
    *   
    * @param bytes  
    * @return 将二进制转换为十六进制字符输出  
    */  
   public static String BinaryToHexString(byte[] bytes){   
          
       String result = "";   
       String hex = "";   
       for(int i=0;i<bytes.length;i++){   
           //字节高4位   
           hex = String.valueOf(hexStr.charAt((bytes[i]&0xF0)>>4));   
           //字节低4位   
           hex += String.valueOf(hexStr.charAt(bytes[i]&0x0F));   
           result +=hex;   
       }   
       return result;   
   }  
   
   
   
   public static byte[] HexStringToBinary(String s){
   	char[] chars = s.toCharArray();
   	byte[] bts = new byte[chars.length/2];
   	for(int i=0;i<chars.length;i++){
   		bts[i/2] = (byte) (charToByte(chars[i])<<4|charToByte(chars[++i]));
   	}
   	return bts;
   	
   }
   
   public static byte charToByte(char c){
   	return (byte) hexStr.indexOf(c);
   }

}
