import java.io.IOException;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.MiniDFSCluster;


public class ShowFileStatus {

	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		 MiniDFSCluster cluster;
		 FileSystem fs;
		
		Configuration conf = new Configuration();
		if(System.getProperty("test.build.data") == null){
			System.setProperty("test.build.data", "/tmp");
		}
		cluster = new MiniDFSCluster(conf,1,true,null);
		fs = cluster.getFileSystem();
		OutputStream out = fs.create(new Path("/dir/file"));
		out.write("content".getBytes("UTF-8"));
		out.close();
		
		
		
		Path file = new Path("/dir/file");
		FileStatus stat = fs.getFileStatus(file);
		System.out.println(stat.getPath().toUri().getPath());
		
		
		
		
		if(fs != null){
			fs.close();
		}
		if(cluster != null ){
			cluster.shutdown();
		}
		
	}

}
