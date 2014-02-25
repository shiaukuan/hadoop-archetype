#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IntSumReducerTest {

	private static Reducer reducer;
	private static ReduceDriver reducerDriver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reducer = new IntSumReducer();
		reducerDriver = ReduceDriver.newReduceDriver(reducer);
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testSetupContext() {
		// TODO
	}

	@Test
	public final void testReduceTextIterableOfIntWritableContext() throws IOException {
		List<IntWritable> values = new ArrayList<IntWritable>();
		values.add(new IntWritable(1));
		values.add(new IntWritable(1));
		reducerDriver.withInput(new Text("hello"), values);
		reducerDriver.withOutput(new Text("hello"), new IntWritable(2));
		reducerDriver.runTest();
	}

	@Test
	public final void testCleanupContext() {
		// TODO
	}

}
