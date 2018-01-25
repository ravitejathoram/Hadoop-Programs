import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.conf.Configuration;

public class SearchMapper extends Mapper<LongWritable, Text, Text, Text>
{
	int count;
	public void map(LongWritable key, Text value, Context contex) throws IOException, InterruptedException
	{
			count=0;
			Configuration conf = contex.getConfiguration();
			String search_key=conf.get("key");
			String line1=value.toString();
			String line=value.toString();
			line=line.replaceAll("[+-;\",]"," ");
			String[] word=line.split(" ");
			for(int i=0;i<word.length;i++)
			{
				if((search_key.toUpperCase()).equals(word[i].toUpperCase()))
				{
					count++;
				}
			}
			contex.write(new Text(search_key),new Text(line1+"~"+count));
	}
}
