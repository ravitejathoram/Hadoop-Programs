import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordPartitioner extends Partitioner<Text,LongWritable>
{
	public int getPartition(Text key,LongWritable value,int numReduceTasks)
	{

		if(numReduceTasks==0)
		{
		 return 0;
		}
		else 
		{
		return(key.toString().charAt(0)%numReduceTasks);
		}
									
	}
}
