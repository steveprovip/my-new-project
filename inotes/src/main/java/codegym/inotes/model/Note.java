package codegym.inotes.model;

import java.util.List;

/**
 * Bước 7: Interface Note (Strategy).
 * NoteDB (lưu trong CSDL) và NoteFile (lưu trong tệp tin)
 * là 2 chiến lược (strategy) kế thừa interface này.
 */
public interface Note {

    int getId();

    void setId(int id);

    /* Bước 2: các phương thức gán tiêu đề, nội dung, phân loại */
    void setTitle(String title);

    void setContent(String content);

    void setTypeId(int typeId);

    /* Bước 2: các phương thức lấy tiêu đề, nội dung, tên phân loại */
    String getTitle();

    String getContent();

    String getType();

    /* Bước 2 & 8: lưu Ghi chú (insert nếu chưa có id, update nếu đã có) */
    boolean save();

    /* Bước 2 & 8: xóa Ghi chú khỏi CSDL / tệp tin */
    boolean delete();

    /* Bước 8: tìm kiếm ghi chú trong kho lưu trữ của strategy hiện tại
       (được NoteManagement dùng để tìm kiếm cả trong CSDL lẫn tệp tin) */
    List<Note> search(String keyword);
}
