package mo.com.jaru.criptografie.file;

import java.util.List;

public class FileNameValidator {

    private  static final  List<String> FORBIDDEN_DIRS_FILES =
            List.of(".bash_history", ".bash_profile", "etc", "proc");
}
