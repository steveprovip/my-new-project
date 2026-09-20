package codegym.inotes.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Bước 2: Lớp NoteDB (trước khi refactor tên là Note)
 * Kế thừa interface Note (Bước 7) - Strategy lưu trữ trong MySQL.
 */
public class NoteDB implements Note {

    private int id;
    private String title;
    private String content;
    private int typeId;

    private static final String JDBC_URL =
            "jdbc:mysql://localhost:3306/iNotes?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    public NoteDB() {
    }

    public NoteDB(int id, String title, String content, int typeId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.typeId = typeId;
    }

    /* ---------- Getters / Setters (Bước 2) ---------- */

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

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getType() {
        return NoteFile.typeNameById(typeId, getTypeNameFromDb());
    }

    /* getType(): truy vấn tên phân loại từ bảng notetypes */
    private String getTypeNameFromDb() {
        String sql = "SELECT nt.name FROM notetypes nt WHERE nt.id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, typeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Unknown";
    }

    /* ---------- save(): lưu (insert/update) Ghi chú vào CSDL ---------- */
    @Override
    public boolean save() {
        if (id > 0) {
            return update();
        }
        String sql = "INSERT INTO notes (title, content, type_id) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setInt(3, typeId);
            int rows = statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    id = keys.getInt(1);
                }
            }
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean update() {
        String sql = "UPDATE notes SET title = ?, content = ?, type_id = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setInt(3, typeId);
            statement.setInt(4, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* ---------- delete(): xóa Ghi chú khỏi CSDL ---------- */
    @Override
    public boolean delete() {
        if (id <= 0) {
            return false;
        }
        String sql = "DELETE FROM notes WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* ---------- search(): tìm kiếm ghi chú trong CSDL ---------- */
    @Override
    public List<Note> search(String keyword) {
        List<Note> result = new ArrayList<>();
        String sql = "SELECT n.id, n.title, n.content, n.type_id FROM notes n "
                + "WHERE n.title LIKE ? OR n.content LIKE ? ORDER BY n.id DESC";
        String pattern = "%" + keyword + "%";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pattern);
            statement.setString(2, pattern);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new NoteDB(resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("content"),
                            resultSet.getInt("type_id")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /* findById dùng cho trang chi tiết (Bước 6) */
    public static NoteDB findById(int id) {
        String sql = "SELECT id, title, content, type_id FROM notes WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new NoteDB(resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("content"),
                            resultSet.getInt("type_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
