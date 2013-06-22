/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author luctanbinh
 */
public class UploadHelper {

    static public void process(FileItem imageItem, String dirName) throws FileUploadException, IOException {
        /* Save the uploaded file if its size is greater than 0. */
        if (imageItem.getSize() > 0) {
            String fileName = imageItem.getName();
            File saveTo = new File(dirName + fileName);
            try {
                imageItem.write(saveTo);
            } catch (Exception e) {
            }
        }
    }
}
