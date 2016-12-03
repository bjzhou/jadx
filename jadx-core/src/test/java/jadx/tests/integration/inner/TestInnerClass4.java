package jadx.tests.integration.inner;

import org.junit.Test;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;

import static jadx.tests.api.utils.JadxMatchers.containsOne;
import static org.junit.Assert.assertThat;

public class TestInnerClass4 extends IntegrationTest {

    @Test
    public void test() {
        ClassNode cls = getClassNode(TestCls.class);
        String code = cls.getCode().toString();

        assertThat(code, containsOne("return new C().c;"));
    }

    public static class TestCls {
        private String test() {
            return new C().c;
        }

        public class C {
            public String c;

            private C() {
                this.c = "c";
            }
        }
    }
}
