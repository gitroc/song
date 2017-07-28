package com.example.song;

import com.example.song.controller.HelloWorldController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSayHello() {
		assertEquals("Hello,World!",new HelloWorldController().sayHello());
	}

}
