package fileuploadSample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view2")
public class ViewServlet2 extends HttpServlet {

    private static final String UPLOAD_PATH = "C:/upload/";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("fileName");

        if (fileName == null || fileName.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        File file = new File(UPLOAD_PATH, fileName);

        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String contentType =
                getServletContext().getMimeType(file.getName());

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        response.setContentType(contentType);
        response.setContentLengthLong(file.length());

        FileInputStream fis = null;
        OutputStream os = null;

        try {
            fis = new FileInputStream(file);
            os = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int read;

            while ((read = fis.read(buffer)) != -1) {
                os.write(buffer, 0, read);
            }

            os.flush();

        } finally {
            if (fis != null) fis.close();
        }
    }
}


/*


package fileuploadSample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/view2")
public class ViewServlet2 extends HttpServlet {

    private static final String UPLOAD_PATH = "C:/upload/";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("fileName");

        if (fileName == null || fileName.trim().isEmpty()) {
            response.sendError(400);
            return;
        }

        File file = new File(UPLOAD_PATH, fileName);

        if (!file.exists()) {
            response.sendError(404);
            return;
        }

        String contentType = getServletContext().getMimeType(fileName);

        if (contentType == null) {
            contentType = "application/octet-stream";  //바이너리 파일의 기본 MIME
        }

        response.setContentType(contentType);

        Files.copy(file.toPath(), response.getOutputStream());
    }
}

*/