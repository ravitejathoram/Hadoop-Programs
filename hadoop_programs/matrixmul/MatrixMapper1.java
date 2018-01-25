import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.JobConf;

class MatrixMapper1 extends Mapper<LongWritable, Text, Text, Text>
{
	public void map(LongWritable key, Text value, Context context) throws 	IOException, InterruptedException
	{
		Configuration conf = context.getConfiguration();
		int iteration=Integer.parseInt(conf.get("colB"));
		String ty=value.toString();
		String[] gh=ty.split(" ");		
		for(int j=0;j<iteration;j++)
		{
			context.write(new Text(gh[0]+","+j),new Text(value+" "+"0"));
		}
	}
}
