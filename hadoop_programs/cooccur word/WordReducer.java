import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class WordReducer extends Reducer<Text, LongWritable, Text, LongWritable>
{
	LongWritable totalWC = new LongWritable();
	public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException
	{
		long wordcount = 0;
		for(LongWritable val:values)
			wordcount = wordcount + val.get();
		totalWC.set(wordcount);
		
		if(wordcount>1)
		context.write(key,totalWC);
	}
}
