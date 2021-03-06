package jadx.samples;

import jadx.samples.otherpkg.A;

/**
 * Tests:
 * - class B not imported
 */
public class TestImports extends AbstractTest {

    public static void main(String[] args) {
        new TestImports().testRun();
    }

    @Override
    public boolean testRun() {
        return true;
    }

    public class C extends A {
        public B getB() {
            return null;
        }
    }
}
