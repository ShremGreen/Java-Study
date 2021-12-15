package IO.package_1;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class IODemo10 {
    @Test
    public void test() {
        File srcFile = new File("憨狗.jpg");
        File destFile = new File("憨狗4.jpg");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
