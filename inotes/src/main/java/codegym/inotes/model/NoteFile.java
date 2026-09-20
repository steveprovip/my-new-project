package codegym.inotes.model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Bước 8: Lớp NoteFile - Strategy lưu trữ Ghi chú trong tệp tin.
 * <p>
 * Cấu trúc tệp tin (mỗi dòng một Ghi chú):
 * <pre>
 *     id,title,typeId,content
 * </pre>
 * Ví dụ: 1,Hoc Java,1,Mexh gap 3 gio, hoc Strategy pattern
 */
public class NoteFile implements Note {

    /* Đường dẫn tệp tin chứa Ghi chú (nằm trong thư mục người dùng) */
    public static final String NOTES_FILE =
            System.getProperty("user.home") + File.separator + "notes.txt";

    /* Tên phân loại mặc định khi không truy vấn được CSDL */
    private static final String[] TYPE_NAMES = {"Work", "Personal", "Ideas"};

    private int id;
    private String title;
    private String content;
    private int typeId;

    public NoteFile() {
    }

    public NoteFile(int id, String title, String content, int typeId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.typeId = typeId;
    }

    /* ---------- Getters / Setters (giống NoteDB) ---------- */

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

    /* getType(): tên phân loại theo typeId (đồng bộ với bảng notetypes) */
    @Override
    public String getType() {
        return typeNameById(typeId, "Unknown");
    }


    /* ---------- save(): lưu Ghi chú vào tệp tin ---------- */
    @Override
    public boolean save() {
        List<NoteFile> notes = readAll();
        boolean updated = false;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                notes.set(i, this);
                updated = true;
                break;
            }
        }
        if (!updated) {
            /* Nếu chưa có id thì tự sinh id mới = max + 1 */
            if (id <= 0) {
                int maxId = 0;
                for (NoteFile note : notes) {
                    if (note.getId() > maxId) {
                        maxId = note.getId();
                    }
                }
                id = maxId + 1;
            }
            notes.add(this);
        }
        return writeAll(notes);
    }

    /* ---------- delete(): xóa Ghi chú khỏi tệp tin ---------- */
    @Override
    public boolean delete() {
        List<NoteFile> notes = readAll();
        boolean removed = notes.removeIf(note -> note.getId() == id);
        if (removed) {
            writeAll(notes);
        }
        return removed;
    }

    /* ---------- search(): tìm kiếm ghi chú trong tệp tin ---------- */
    @Override
    public List<Note> search(String keyword) {
        List<Note> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        for (NoteFile note : readAll()) {
            if (note.getTitle().toLowerCase().contains(lowerKeyword)
                    || note.getContent().toLowerCase().contains(lowerKeyword)) {
                result.add(note);
            }
        }
        return result;
    }

    /* ---------- Hàm tiện ích đọc/ghi toàn bộ tệp tin ---------- */

    static List<NoteFile> readAll() {
        List<NoteFile> notes = new ArrayList<>();
        File file = new File(NOTES_FILE);
        if (!file.exists()) {
            return notes;
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                NoteFile note = parseLine(line);
                if (note != null) {
                    notes.add(note);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notes;
    }

    static boolean writeAll(List<NoteFile> notes) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(NOTES_FILE), StandardCharsets.UTF_8))) {
            for (NoteFile note : notes) {
                writer.write(toLine(note));
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* static findById dùng cho trang chi tiết (Bước 6) */
    public static NoteFile findById(int id) {
        for (NoteFile note : readAll()) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }

    /* Chuyển đổi Ghi chú <-> dòng trong tệp tin (id,title,typeId,content).
       Content đặt CUỐI dòng và split giới hạn 4 phần để nội dung
       có thể chứa dấu phẩy mà không làm vỡ cấu trúc. */
    private static NoteFile parseLine(String line) {
        String[] parts = line.split(",", 4);
        if (parts.length < 4) {
            return null;
        }
        try {
            int id = Integer.parseInt(parts[0].trim());
            int typeId = Integer.parseInt(parts[2].trim());
            return new NoteFile(id, parts[1], parts[3], typeId);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static String toLine(NoteFile note) {
        return note.getId() + "," + note.getTitle() + "," + note.getTypeId() + "," + note.getContent();
    }

    /* Trả về tên phân loại: ưu tiên tên từ CSDL, fallback sang mảng mặc định */
    static String typeNameById(int typeId, String dbTypeName) {
        if (dbTypeName != null && !"Unknown".equals(dbTypeName)) {
            return dbTypeName;
        }
        if (typeId >= 1 && typeId <= TYPE_NAMES.length) {
            return TYPE_NAMES[typeId - 1];
        }
        return dbTypeName != null ? dbTypeName : "Unknown";
    }
}
