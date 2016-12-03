package jadx.tests.integration.inner;

import org.junit.Test;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class TestInnerClass3 extends IntegrationTest {

    @Test
    public void test() {
        ClassNode cls = getClassNode(TestCls.class);
        String code = cls.getCode().toString();

        assertThat(code, not(containsString("synthetic")));
        assertThat(code, not(containsString("access$")));
        assertThat(code, not(containsString("x0")));
        assertThat(code, containsString("setC(\"c\");"));
    }

    public static class TestCls {
        private String c;

        private void setC(String c) {
            this.c = c;
        }

        public class C {
            public String c() {
                setC("c");
                return c;
            }
        }
    }
}
