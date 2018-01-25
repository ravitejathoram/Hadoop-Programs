import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class WordReducer extends Reducer <Text,LongWritable,Text,LongWritable>
{
	public void reduce(Text key,LongWritable values,Context context)throws IOException,InterruptedException
	{
		
		context.write(key,values);
	}
}
