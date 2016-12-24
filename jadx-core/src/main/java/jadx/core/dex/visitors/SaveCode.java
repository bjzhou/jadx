package jadx.core.dex.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import jadx.api.IJadxArgs;
import jadx.core.codegen.CodeWriter;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.utils.exceptions.CodegenException;

public class SaveCode extends AbstractVisitor {
    private static final Logger LOG = LoggerFactory.getLogger(SaveCode.class);
    private final File dir;
    private final IJadxArgs args;

    public SaveCode(File dir, IJadxArgs args) {
        this.args = args;
        this.dir = dir;
    }

    public static void save(File dir, IJadxArgs args, ClassNode cls) {
        CodeWriter clsCode = cls.getCode();
        if (clsCode == null) {
            LOG.warn("clsCode == null " + cls.getFullName());
            return;
        }
        String fileName = cls.getClassInfo().getFullPath() + ".java";
        if (args.isFallbackMode()) {
            fileName += ".jadx";
        }
        clsCode.save(dir, fileName);
    }

    @Override
    public boolean visit(ClassNode cls) throws CodegenException {
        save(dir, args, cls);
        return false;
    }
}
