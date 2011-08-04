import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;


public class FileSystemCat {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		 String uri = args[0];
		 Configuration conf = new Configuration();
		 FileSystem fs = FileSystem.get(URI.create(uri),conf);
		 //InputStream in = null;
		 FSDataInputStream in = null;
		 try{
			 in = fs.open(new Path(uri));
			 IOUtils.copyBytes(in, System.out, 4096,false);
			 in.seek(0);
			 IOUtils.copyBytes(in, System.out, 4096,false);
		 }finally{
			 IOUtils.closeStream(in);
		 }

	}

}
