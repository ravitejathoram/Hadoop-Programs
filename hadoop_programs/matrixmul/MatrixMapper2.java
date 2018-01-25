import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.conf.Configuration;

class MatrixMapper2 extends Mapper<LongWritable, Text, Text, Text>
{
	public void map(LongWritable key, Text value, Context context) throws 	IOException, InterruptedException
	{
		Configuration conf = context.getConfiguration();
		int iteration=Integer.parseInt(conf.get("rowA"));	
		String ty=value.toString();
		String[] gh=ty.split(" ");		
		for(int j=0;j<iteration;j++)
		{
			context.write(new Text(j+","+gh[1]),new Text(value+" "+"1"));
		}
	}
}
