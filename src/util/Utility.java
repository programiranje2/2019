/*
 * Created on Nov 25, 2019
 *
 */
package util;

import java.io.File;

public class Utility {
    
    public static String getProjectDir() {
        StringBuffer projectDir = (new StringBuffer(new File(".").getAbsolutePath()));
        projectDir.delete(projectDir.length()-1, projectDir.length());
        return projectDir.toString();
    }
    
    public static String makeProjectSubdir(String subdir) {
        File projectSubdir = new File(getProjectDir(), subdir);
        projectSubdir.mkdirs();
        return projectSubdir.getAbsolutePath();
    }
    
    public static String getResourcesDir() {
        return makeProjectSubdir("resources\\") + "\\";
    }

}
