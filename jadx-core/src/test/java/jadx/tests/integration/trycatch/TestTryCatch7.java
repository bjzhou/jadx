package jadx.tests.integration.trycatch;

import org.junit.Test;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;

import static jadx.tests.api.utils.JadxMatchers.containsOne;
import static org.junit.Assert.assertThat;

public class TestTryCatch7 extends IntegrationTest {

    @Test
    public void test() {
        noDebugInfo();
        ClassNode cls = getClassNode(TestCls.class);
        String code = cls.getCode().toString();

        String excVarName = "exception";
        assertThat(code, containsOne("Exception " + excVarName + " = new Exception();"));
        assertThat(code, containsOne("} catch (Exception e) {"));
        assertThat(code, containsOne(excVarName + " = e;"));
        assertThat(code, containsOne(excVarName + ".printStackTrace();"));
        assertThat(code, containsOne("return " + excVarName + ";"));
    }

    public static class TestCls {
        private Exception test() {
            Exception e = new Exception();
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
                e = ex;
            }
            e.printStackTrace();
            return e;
        }
    }
}
