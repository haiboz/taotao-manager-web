package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.FormatFlagsConversionMismatchException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.util.FTPUtil;

/**
 * FTP上传文件测试
 * @author 浮生若梦
 * 2016年9月29日 下午9:58:34
 */
public class FTPTest {
	@Test
	public void testFTPClient() throws SocketException, IOException{
		//创建一个FTPClient对象
		FTPClient ftpClient = new FTPClient(); 
		//创建FTP连接。端口默认21
		ftpClient.connect("192.168.254.129",21);
		//登陆FTP服务器
		ftpClient.login("ftpuser", "ftpuser");
		//读取本地文件
		FileInputStream in = new FileInputStream(new File("C:\\Users\\yscq\\Desktop\\qq.jpg"));
		//设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		//修改上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//二进制
		//上传文件 
		//第一个参数：服务器文档名
		//第二个参数：上传文档的inputStream
		ftpClient.storeFile("test.jpg", in);
		//关闭连接
		ftpClient.logout();
	}
	
	/**
	 * 测试工具类
	 * @throws FileNotFoundException
	 */
	@Test
	public void testFTPUtil() throws FileNotFoundException{
		
		FileInputStream in = new FileInputStream(new File("C:\\Users\\yscq\\Desktop\\qq.jpg"));
		boolean flag = FTPUtil.uploadFile("192.168.254.129", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images",
				"/2016/09/29","hello.jpg", in);
		if(flag){
			System.out.println("上传成功");
		}else{
			System.out.println("上传失败");
		}
	}
	

}
