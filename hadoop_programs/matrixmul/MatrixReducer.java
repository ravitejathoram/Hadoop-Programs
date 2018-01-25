import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.JobConf;

public class MatrixReducer extends Reducer<Text, Text, Text, LongWritable>
{
	int sum,c1,c2,c,b,x,y,col;
	int[][] a=new int[100][100];
	public void reduce(Text key,Iterable<Text> values, Context context) throws IOException, InterruptedException
	{
		Configuration conf = context.getConfiguration();
		int iteration=Integer.parseInt(conf.get("colA"));
		y=0;
		sum=0;
		String keys=key.toString();
		String[] l=keys.split(",");
		c1=Integer.parseInt(l[0]);
		c2=Integer.parseInt(l[1]);
		for(Text tre:values)
		{
			String valu=tre.toString();
			String[] arr=valu.split(" ");
			for(x=0;x<arr.length;x++)
			{
				a[y][x]=Integer.parseInt(arr[x]);
			}
			y++;
		}
		for(int k=0;k<iteration;k++)
		{
			c=search(a,c1,k,0);
			b=search(a,k,c2,1);
			sum=sum+c*b;
		}		
		context.write(new Text(key),new LongWritable(sum));
	}
	public int search(int[][] q,int w,int e,int u)
	{
		int g;
		for(g=0;g<q[0].length;g++)
		{
			if((q[g][0]==w)&&(q[g][1]==e)&&(q[g][3]==u))
			{
				return q[g][2];
			}
		}
		return 0;
	}
}
