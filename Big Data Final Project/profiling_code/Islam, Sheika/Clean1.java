import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Clean1 { //runs MapReduce job, application to find the maximum temperature in the weather dataset
 public static void main(String[] args) throws Exception {
 if (args.length != 2) {
 System.err.println("Usage: Clean1 <input path> <output path>");
 System.exit(-1);
 }

 Job job = new Job();
 job.setNumReduceTasks(1); //outputs one output file!
 job.setJarByClass(Clean1.class); //we dont need to explicitly specify the name of the jar file, we can just pass a class in this method. Hadoop will use it to locate the relevant JAR file by looking for the JAR file containing this class.
 job.setJobName("Clean1");
 FileInputFormat.addInputPath(job, new Path(args[0])); //An input path is specified by calling it on Fileinputformat. Its static. 
 FileOutputFormat.setOutputPath(job, new Path(args[1])); //An output path is specified by calling it on Fileoutputformat. Its static. It specifies a directory where the output files from the reduce function are written. The directory shouldn’t exist before running the job because Hadoop will complain and not run the job. 
 job.setMapperClass(CleanMapper1.class); //specify map type
 job.setReducerClass(CleanReducer1.class); //specify reduce type
 job.setOutputKeyClass(Text.class);
 job.setOutputValueClass(IntWritable.class); //The setOutputKeyClass() and setOutputValueClass() methods control the output types for the reduce function, and must match what the Reduce class produces
 
 System.exit(job.waitForCompletion(true) ? 0 : 1); // submits the job and waits for it to finish.
 
    }
}