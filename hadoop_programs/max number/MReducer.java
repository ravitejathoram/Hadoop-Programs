import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class MReducer extends Reducer<Text, LongWritable, Text, LongWritable>
{
	int i,count=0;
	long maxim=0;
	public void reduce(Text key, Iterable<LongWritable> values, Context context)throws IOException, InterruptedException
	{
		for(LongWritable val:values)
		{
			if(count==0)
			{
				maxim=val.get();
				count=1;
			}
			else
			{
				if(val.get()>maxim)
				maxim=val.get();
			}
		}
		context.write(new Text("maximum"),new LongWritable(maxim));
		
	}
}
