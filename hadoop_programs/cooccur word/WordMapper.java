import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class WordMapper extends Mapper<LongWritable, Text, Text, LongWritable>
{
	LongWritable one = new LongWritable(1);
	int i;	
	public void map(LongWritable key, Text value, Context contex) throws 	IOException, InterruptedException
	{
		String line = value.toString();
		String[] wordsinline = line.split(" ");
		
		for( i=0 ; i<wordsinline.length-1 ; i++)
		contex.write(new Text(wordsinline[i]+" "+wordsinline[i+1]),one);
	}
}
