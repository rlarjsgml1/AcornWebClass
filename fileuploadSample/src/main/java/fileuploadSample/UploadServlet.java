package fileuploadSample;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")

@MultipartConfig(
		 fileSizeThreshold = 1024 * 1024,     // 1MB
		    maxFileSize = 5 * 1024 * 1024,       // 파일 하나당 최대 5MB
		    maxRequestSize = 10 * 1024 * 1024 )    // 전체 요청 최대 10MB)
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "upload";  // webapp/upload 폴더에 저장
    
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
    	
    	req.getRequestDispatcher("/WEB-INF/views/upload.jsp").forward(req, resp);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // webapp/upload 경로 설정
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        
        System.out.println( uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        Part filePart = request.getPart("file");
        String fileName = extractFileName(filePart);
        
        System.out.println("fileName="+ fileName);

        if (fileName != null && !fileName.isEmpty()) {
            File file = new File(uploadPath, fileName);
            Files.copy(filePart.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);

            String encodedName = URLEncoder.encode(fileName, "UTF-8");
            // 이미지 보기 컨트롤러로 이동
            response.sendRedirect(request.getContextPath() + "/view?fileName=" + encodedName);           
         
            
        } else {
            response.getWriter().println("파일이 선택되지 않았습니다.");
        }
    }
    
    

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println( contentDisp);
        for (String token : contentDisp.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return null;
    }
}
