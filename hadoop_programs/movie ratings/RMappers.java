import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class RMapper extends Mapper<LongWritable, Text, Text, LongWritable>
{
	int i;	
	public void map(LongWritable key, Text value, Context contex) throws IOException, InterruptedException
	{
		String line = value.toString();
		String[] wordsinline = line.split("\t");
		int rate=Integer.parseInt(wordsinline[2]);
		contex.write(new Text(wordsinline[0]),new LongWritable(rate));
	}
}
