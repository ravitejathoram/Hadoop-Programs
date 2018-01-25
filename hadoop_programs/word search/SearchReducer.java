import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.conf.Configuration;


public class SearchReducer extends Reducer<Text, Text, Text, Text>
{
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{ 
		int times=0,t;
		for(Text value:values)
		{
			String p=value.toString();
			String[] l=p.split("~");
			t=Integer.parseInt(l[1]);
			if(t!=0)
			{
				//x=x+l[0]+"\n";
				context.write(new Text("key:"+key+"\n"+"found in line:"),new Text(l[0]));
				times=1;
			}
		}
		if(times==0)
		context.write(new Text("key:"+key+"\n"+"not found"),new Text(""));
	}
}
