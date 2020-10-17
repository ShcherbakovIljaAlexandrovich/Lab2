import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.contains("AIRPORT")) return;
        String[] tokens = line.split(",");
        String airportID = tokens[14];
        String delay = tokens[18];
        context.write(new TextPair(airportID, "1"), new Text(delay));
    }
}
