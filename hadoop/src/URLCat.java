import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;


public class URLCat {

	static {
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		InputStream in = null;
		try{
			in = new URL(args[0]).openStream();
			IOUtils.copyBytes(in, System.out, 4096,false);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeStream(in);
		}

	}

}
