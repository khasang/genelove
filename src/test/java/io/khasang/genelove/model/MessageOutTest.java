package io.khasang.genelove.model;

import io.khasang.genelove.config.AppConfig;
import io.khasang.genelove.config.application.WebConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class, Temp.class})
public class MessageOutTest {
    @Autowired
    private Temp temp;
    private static int countTemp = 1;

    @Before
    public void digital() {
       countTemp++;
    }

    @Test(timeout = 1)
    public void testGetMessageWithParam() {
        assertEquals("something going wrong: ", countTemp, temp.sum(2));
    }

    @Test
    public void testGetMessageWithParam1() {
        assertEquals("something going wrong: ", countTemp, temp.sum(2));
    }

    @After
    public void digitalAfter() {
        countTemp--;
    }

    @Test
    public void testTempNotNull(){
        assertNotNull(new Temp());
    }

}
