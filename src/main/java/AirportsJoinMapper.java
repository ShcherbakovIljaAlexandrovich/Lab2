import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

import java.util.regex.*;

public class AirportsJoinMapper extends Mapper<LongWritable, Text, TextPair, Text>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.contains("code")) return;
        String pattern = "\"(.*)\",\"(.*)\"";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            context.write(new TextPair(m.group(1), "0"), new Text(m.group(2)));
        }
    }
}
