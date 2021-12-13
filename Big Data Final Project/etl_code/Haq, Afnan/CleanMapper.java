import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String line = value.toString();
		String[] linePart = line.split("\\t", -1);

		int length = linePart.length;

		//String lengthStr = Integer.toString(length);
		if (length >= 41) {
			String uniqueKey = linePart[0];
			String createdDate = linePart[1];
			String closedDate = linePart[2];
			String agency = linePart[3];
			String complainType = linePart[5];
			String zipCode = linePart[8];
			String address = linePart[9];
			String landmark = linePart[17];
			String status = linePart[19];
			String latitude = linePart[38];
			String longitude = linePart[39];
			String location = linePart[40];

			context.write(new Text(""), new Text(uniqueKey + "," + createdDate + "," + closedDate + "," + agency + "," 
			+ complainType + "," + zipCode + "," + address + "," + landmark + "," + status + "," + latitude + "," + longitude + "," + location));	
		} 
		
		
	}

}