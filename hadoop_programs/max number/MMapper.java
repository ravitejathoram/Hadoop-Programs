import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

class MMapper extends Mapper<LongWritable,Text,Text,LongWritable>
{
	int max=0,i,j,count=0;
	public void map(LongWritable key, Text value, Context contex) throws 	IOException, InterruptedException
	{
		String line=value.toString();
		String[] num_arr=line.split(" ");
		if(count==0)
		{
			max=Integer.parseInt(num_arr[0]);
			count=1;
		}
		else
		{
		for(i=0;i<num_arr.length;i++)
		{
			j=Integer.parseInt(num_arr[i]);
			if(j>max)
			max=j;
		}
		}
		contex.write(new Text("X"),new LongWritable(max));

	}	
}
