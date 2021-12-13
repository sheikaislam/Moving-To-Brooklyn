import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class CleanReducer1 //reducer
 extends Reducer<Text, IntWritable, Text, IntWritable> { //The input types of the reduce function must match the output types of the map function: Text and IntWritable. And in this case, the output types of the reduce function are Text and IntWritable,

 @Override
 public void reduce(Text key, Iterable<IntWritable> values, Context context)
 throws IOException, InterruptedException {

 int sum = 0;
 int maxValue = Integer.MIN_VALUE;
 for (IntWritable value : values) { //for every value give with this key
    sum += value.get();
    maxValue = Math.max(maxValue, sum);
 }
 context.write(key, new IntWritable(maxValue)); //our output to the output file
 }
}