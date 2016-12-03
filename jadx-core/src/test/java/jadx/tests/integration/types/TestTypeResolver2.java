package jadx.tests.integration.types;

import org.junit.Test;

import java.io.IOException;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;

import static jadx.tests.api.utils.JadxMatchers.containsOne;
import static org.junit.Assert.assertThat;

public class TestTypeResolver2 extends IntegrationTest {

    @Test
    public void test() {
        noDebugInfo();

        ClassNode cls = getClassNode(TestCls.class);
        String code = cls.getCode().toString();

        assertThat(code, containsOne("if (obj != null) {"));
    }

    public static class TestCls {

        private static boolean test(Object obj) throws IOException {
            if (obj != null) {
                return true;
            }
            throw new IOException();
        }
    }
}
