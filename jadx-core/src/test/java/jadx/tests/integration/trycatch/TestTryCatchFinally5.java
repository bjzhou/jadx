package jadx.tests.integration.trycatch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;

import static jadx.tests.api.utils.JadxMatchers.containsOne;
import static org.junit.Assert.assertThat;

public class TestTryCatchFinally5 extends IntegrationTest {

    @Test
    public void test() {
        ClassNode cls = getClassNode(TestCls.class);
        String code = cls.getCode().toString();

        assertThat(code, containsOne("} finally {"));
        // TODO: remove duplicates on multiple paths
//		assertThat(code, containsOne("d.close();"));
    }

    public static class TestCls {
        private <E> List<E> test(A a, B<E> b) {
            C c = p(a);
            if (c == null) {
                return null;
            }
            D d = b.f(c);
            try {
                if (!d.first()) {
                    return null;
                }
                List<E> list = new ArrayList<E>();
                do {
                    list.add(b.load(d));
                } while (d.toNext());
                return list;
            } finally {
                d.close();
            }
        }

        private C p(A a) {
            return (C) a;
        }

        private interface A {
        }

        private interface B<T> {
            D f(C c);

            T load(D d);
        }

        private interface C {
        }

        private interface D {
            boolean first();

            boolean toNext();

            void close();
        }
    }
}
