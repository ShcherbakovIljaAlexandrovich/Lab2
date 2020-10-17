import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FirstPartitioner extends Partitioner<TextPair, Text> {
    @Override
    public int getPartition(TextPair textPair, Text text, int i) {
        return Integer.parseInt(textPair.getFirst().toString()) % i;
    }
}
