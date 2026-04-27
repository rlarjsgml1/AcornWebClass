package fileuploadSample;

 

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/upload2")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,      // 1MB
    maxFileSize = 5 * 1024 * 1024,       // 파일 1개당 5MB
    maxRequestSize = 10 * 1024 * 1024    // 전체 요청 10MB
)
public class UploadServlet2 extends HttpServlet {

     

    // C드라이브 upload 폴더
    private static final String UPLOAD_DIR = "C:\\upload";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/upload.jsp")
           .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // 저장 폴더 생성
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        Part filePart = request.getPart("file");
        String fileName = extractFileName(filePart);

        if (fileName != null && !fileName.isEmpty()) {

            File saveFile = new File(UPLOAD_DIR, fileName);

            Files.copy(
                filePart.getInputStream(),
                saveFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING
            );
            
            /*
             
             */

            // 업로드 후 이미지 보기 페이지 이동
            String encoded = URLEncoder.encode(fileName, "UTF-8");

            response.sendRedirect(
                request.getContextPath()
                + "/view?fileName=" + encoded
            );

        } else {
            response.getWriter().println("파일이 선택되지 않았습니다.");
        }
    }

    // 파일명 추출
    private String extractFileName(Part part) {

        String contentDisp = part.getHeader("content-disposition");

        for (String token : contentDisp.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(
                    token.indexOf("=") + 2,
                    token.length() - 1
                );
            }
        }
        return null;
    }
}