package jadx.tests.integration.synchronize;

import org.junit.Test;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class TestSynchronized extends IntegrationTest {

    @Test
    public void test() {
        ClassNode cls = getClassNode(TestCls.class);
        String code = cls.getCode().toString();

        assertThat(code, not(containsString("synchronized (this) {")));
        assertThat(code, containsString("public synchronized boolean test1() {"));
        assertThat(code, containsString("return this.f"));
        assertThat(code, containsString("synchronized (this.o) {"));

        assertThat(code, not(containsString(indent(3) + ";")));
        assertThat(code, not(containsString("try {")));
        assertThat(code, not(containsString("} catch (Throwable th) {")));
        assertThat(code, not(containsString("throw th;")));
    }

    public static class TestCls {
        public final Object o = new Object();
        public boolean f = false;
        public int i = 7;

        public synchronized boolean test1() {
            return this.f;
        }

        public int test2() {
            synchronized (this.o) {
                return i;
            }
        }
    }
}
