package org.add.unit;

import org.add.message;
import org.junit.Test;

public class messageTest {
    @Test
    public void messageTest(){
        message message = new message();
        assert message.message() == "org.add.message";
    }
}
