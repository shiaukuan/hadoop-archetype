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
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TokenizerMapperTest {

	private static  Mapper map;
	private static  MapDriver mapDriver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map = new TokenizerMapper();
		mapDriver = MapDriver.newMapDriver(map);

	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testSetupContext() {
	// TODO
	}

	@Test
	public final void testMapObjectTextContext() throws IOException {
		String text = "hello hello mrunit";
		mapDriver.withInput(new LongWritable(), new Text(text));
		mapDriver.withOutput(new Text("hello"), new IntWritable(1))
				   .withOutput(new Text("hello"), new IntWritable(1))
				.withOutput(new Text("mrunit"), new IntWritable(1)).runTest();
	}

	@Test
	public final void testCleanupContext() {
		// TODO
	}

}
