import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class RReducer extends Reducer<Text,LongWritable, Text, DoubleWritable>
{
	public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException
	{
		double sum_rate = 0;
		double count=0;
		for(LongWritable val:values)
		{	
			sum_rate = sum_rate + val.get();
			count++;
		}
		double avg_rate=sum_rate/count;
		context.write(key,new DoubleWritable(avg_rate));
	}
}
