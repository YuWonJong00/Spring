package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class singletest {
    @Test
    public void test(){
        Singl a=Singl.getInstance();
        a.logic();
        Singl b=Singl.getInstance();
        b.logic();
        Assertions.assertThat(a).isSameAs(b);

    }
}
