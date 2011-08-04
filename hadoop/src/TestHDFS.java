import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.hadoop.io.IOUtils;


public class TestHDFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStream in = null;
		try{
			in = new URL("htfs://localhost/user/ubuntu/output/part-00000").openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			IOUtils.closeStream(in);
		}

	}

}
