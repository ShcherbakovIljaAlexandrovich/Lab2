import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<TextPair, Text, Text, IntWritable> {
    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text airportName = new Text(iter.next());
        if (!iter.hasNext()) return;
        int min = Integer.parseInt(iter.next().toString());
        int max = min;
        int avg = min;
        
    }
}
