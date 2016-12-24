package jadx.core.dex.visitors;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.MethodNode;

public class DepthTraversal {

    public static void visit(IDexTreeVisitor visitor, ClassNode cls) {
        try {
            if (visitor.visit(cls)) {
                for (ClassNode inCls : cls.getInnerClasses()) {
                    visit(visitor, inCls);
                }
                for (MethodNode mth : cls.getMethods()) {
                    visit(visitor, mth);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void visit(IDexTreeVisitor visitor, MethodNode mth) {
        if (mth.contains(AType.JADX_ERROR)) {
            return;
        }
        try {
            visitor.visit(mth);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
