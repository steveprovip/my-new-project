package codegym.inotes.controller;

import codegym.inotes.model.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet điều khiển chính của iNotes (Bước 4, 5, 6).
 * Nhận tham số store=db|file để chọn Strategy lưu trữ (Bước 8).
 */
@WebServlet(name = "NoteServlet", urlPatterns = "/notes")
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        NoteManagement management = getManagement(request);

        switch (action) {
            case "add":
                /* Bước 4: hiển thị form thêm Ghi chú */
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
            case "view":
                /* Bước 6: trang chi tiết một Ghi chú */
                int viewId = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("note", management.findById(viewId));
                request.getRequestDispatcher("detail.jsp").forward(request, response);
                break;
            case "delete":
                /* Xóa Ghi chú rồi quay về danh sách */
                int deleteId = Integer.parseInt(request.getParameter("id"));
                management.deleteNote(deleteId);
                response.sendRedirect("notes?store=" + currentStore(request));
                break;
            default:
                /* Bước 5: trang liệt kê + tìm kiếm Ghi chú */
                String keyword = request.getParameter("keyword");
                List<Note> notes = (keyword == null || keyword.trim().isEmpty())
                        ? management.searchNotes("")
                        : management.searchNotes(keyword.trim());
                request.setAttribute("notes", notes);
                request.setAttribute("keyword", keyword);
                request.setAttribute("store", currentStore(request));
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        /* Bước 4: nhận dữ liệu từ form thêm Ghi chú */
        NoteManagement management = getManagement(request);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        management.addNote(title, content, typeId);
        response.sendRedirect("notes?store=" + currentStore(request));
    }

    /* Lấy NoteManagement với Strategy được chọn qua tham số store */
    private NoteManagement getManagement(HttpServletRequest request) {
        NoteManagement management = new NoteManagement(currentStore(request));
        request.setAttribute("store", currentStore(request));
        return management;
    }

    private String currentStore(HttpServletRequest request) {
        String store = request.getParameter("store");
        return NoteManagement.STORE_FILE.equalsIgnoreCase(store)
                ? NoteManagement.STORE_FILE : NoteManagement.STORE_DB;
    }
}
