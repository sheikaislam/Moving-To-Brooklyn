import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.StringTokenizer; //*should we output the number of times each neighborhood appears in the Kaggle or output from the Reduce stage to count the number of rentals in each neighbourhood (use the neighbourhood field) and also output the neighborhood group (e.g. Brooklyn) using the neighbourhood_group field


//columns 5 & 6 on csv file "neighborhood group & neighborhood"
public class CleanMapper //mapper (update inputs)
 extends Mapper<LongWritable, Text, Text, IntWritable> { //input key, input value, output key, and output value ( input key is a long integer offset, the input value is a line of text, the output key is a year, and the output value is an air temperature (an integer)))
 private static final int MISSING = 9999;

 //private final static IntWritable one = new IntWritable(1);
 //private final static IntWritable zero = new IntWritable(0);
 private Text word = new Text();

 @Override
 public void map(LongWritable key, Text value, Context context) //The map() method is passed a key and a value
 throws IOException, InterruptedException {
     IntWritable one = new IntWritable(1);
     String line = value.toString();
     String[] tokens = line.split("\t"); //splitting at column, check index of the two thigns
     //String data = tokens[28] + " " + tokens[29] + " " + tokens[31] + " " + tokens[33] + " " + tokens[34] + " " + tokens[36] + " " + tokens[37] + " " + tokens[44] + " " + tokens[54] + " " + tokens[60];
     String boro = tokens[24];
     if (boro.equals("Boro")){
        String data = "BOROUGH" + "\t" + tokens[44] + "\t" + tokens[48]+ "\t" + tokens[1] + "\t" + tokens[40] + "\t" + tokens[39] + "\t" + tokens[35];  //boro, pov stat, gov threshold, sporder #of peopl, full time work or not, fam type, nutrition
        context.write( new Text(data), one);
     }
     if (boro.equals("2")){
        String data = "Brooklyn" + "\t" + tokens[44] + "\t" + tokens[48]+ "\t" + tokens[1] + "\t" + tokens[40] + "\t" + tokens[39] + "\t" + tokens[35];  //boro, pov stat, gov threshold, sporder #of peopl, full time work or not, fam type, nutrition
        context.write( new Text(data), one);
     }
     //if (tokens[0] != " "){
         //Text counted = new Text("Total number of records: ");
         //context.write(counted,one);
     //}
 } 
 }
