import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
public class WordCount
{
	public static void main(String arg[])throws Exception
	{
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf,"xyz");
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		job.setMapperClass(WordMapper.class);
		job.setReducerClass(WordReducer.class);
		FileInputFormat.setInputPaths(job,new Path(arg[0]));
		FileOutputFormat.setOutputPath(job,new Path(arg[1]));
		job.setJarByClass(WordCount.class);
		job.waitForCompletion(true);
	}
}
