

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class test {
    int a = 0;
    @Before
    public void setup(){
        a = 15;
    }

    @Test
    public void assd (){
      //  assertTrue(true);
        assertTrue (a == 15);
    }
}
