import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class WordMapper extends Mapper<LongWritable,Text,Text,LongWritable>
{
	LongWritable one= new LongWritable(1);
	public void map(LongWritable key,Text value,Context context)throws 	IOException,InterruptedException
	{
		int i;
		String line=value.toString();
		String[]wordsinline=line.split(" ");
		for(i=0;i<wordsinline.length;i++)
		context.write(new Text(wordsinline[i]),one);
	}
}
