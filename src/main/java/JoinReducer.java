import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<TextPair, Text, Text, Text> {
    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text airportName = new Text(iter.next());
        if (!iter.hasNext()) return;
        float min = Float.parseFloat(iter.next().toString());
        float max = min;
        float sum = min;
        int n = 1;
        while (iter.hasNext()) {
            float cur = Float.parseFloat(iter.next().toString());
            if (cur<min) min = cur;
            if (cur>max) max = cur;
            sum += cur;
            n++;
        }
        if (max>0) context.write(airportName, new Text(String.format("min:%f max:%f avg:%f", min, max, sum/n)));
    }
}
