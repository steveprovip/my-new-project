package codegym.inotes.controller;

import codegym.inotes.model.Note;
import codegym.inotes.model.NoteDB;
import codegym.inotes.model.NoteFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Bước 3: Lớp điều khiển sử dụng lớp Note (thông qua thuộc tính note).
 * Bước 8: bổ sung changeNoteStore(storeType) để đổi Strategy lưu trữ
 * (DB hoặc FILE) và searchNotes() tìm kiếm trong cả CSDL lẫn tệp tin.
 */
public class NoteManagement {

    public static final String STORE_DB = "db";
    public static final String STORE_FILE = "file";

    /* Thuộc tính note - thể hiện Strategy đang được sử dụng */
    private Note note;

    public NoteManagement() {
        /* Mặc định lưu trữ trong CSDL */
        this(STORE_DB);
    }

    public NoteManagement(String storeType) {
        changeNoteStore(storeType);
    }

    /* Bước 8: chuyển đổi Strategy lưu trữ */
    public void changeNoteStore(String storeType) {
        if (STORE_FILE.equalsIgnoreCase(storeType)) {
            this.note = new NoteFile();
        } else {
            this.note = new NoteDB();
        }
    }

    /* searchNotes(keyword): tìm trong kho hiện tại,
       sau đó hợp nhất (unique theo id) với kho còn lại */
    public List<Note> searchNotes(String keyword) {
        List<Note> result = new ArrayList<>();
        result.addAll(note.search(keyword));

        Note other = (note instanceof NoteFile) ? new NoteDB() : new NoteFile();
        for (Note candidate : other.search(keyword)) {
            boolean exists = false;
            for (Note found : result) {
                if (found.getId() == candidate.getId()) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                result.add(candidate);
            }
        }
        return result;
    }

    /* addNote(title, content, typeId): dùng save() của note để lưu Ghi chú */
    public boolean addNote(String title, String content, int typeId) {
        note.setTitle(title);
        note.setContent(content);
        note.setTypeId(typeId);
        return note.save();
    }

    /* deleteNote(id): dùng delete() của note để xóa Ghi chú */
    public boolean deleteNote(int id) {
        note.setId(id);
        return note.delete();
    }

    /* findById: dùng cho trang chi tiết (Bước 6) */
    public Note findById(int id) {
        if (note instanceof NoteFile) {
            return NoteFile.findById(id);
        }
        return NoteDB.findById(id);
    }

    public Note getNote() {
        return note;
    }
}
