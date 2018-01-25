import java.util.*;
import java.io.*;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class MatrixDriver extends Configured implements Tool
{
	public int run(String args[]) throws Exception
	{
		Configuration conf = this.getConf();
		conf.set("rowA",args[3]);
		conf.set("colA",args[4]);
		conf.set("rowB",args[5]);
		conf.set("colB",args[6]);
		Job job = Job.getInstance(conf,"xyz");		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		job.setMapOutputKeyClass(Text.class);	
		job.setMapOutputValueClass(Text.class);
		job.setMapperClass(MatrixMapper1.class);
		job.setMapperClass(MatrixMapper2.class);
		job.setReducerClass(MatrixReducer.class);
		MultipleInputs.addInputPath(job, new 	Path(args[0]),TextInputFormat.class,MatrixMapper1.class);
		MultipleInputs.addInputPath(job, new Path(args[1]),TextInputFormat.class,MatrixMapper2.class);		
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		job.setJarByClass(MatrixDriver.class);
		return job.waitForCompletion(true) ? 0 : 1;
	}
	public static void main(String args[]) throws Exception
	{
		int res= ToolRunner.run(new Configuration(), new MatrixDriver(), args);
        	System.exit(res);
	}
}
