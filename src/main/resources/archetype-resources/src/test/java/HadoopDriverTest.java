#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HadoopDriverTest {

	private static Mapper map;
	private static Reducer reducer;
	private static MapReduceDriver mapReduceDriver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map = new TokenizerMapper();
		reducer = new IntSumReducer();
		mapReduceDriver = MapReduceDriver.newMapReduceDriver(map, reducer);
		;
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testRun() throws IOException {
		String text = "hello hello mrunit";
		mapReduceDriver.withInput(new LongWritable(), new Text(text));
		mapReduceDriver.withOutput(new Text("hello"), new IntWritable(2))
				.withOutput(new Text("mrunit"), new IntWritable(1)).runTest();
	}

}
