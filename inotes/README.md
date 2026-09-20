# iNotes — Ứng dụng quản lý Ghi chú (JSP/Servlet + Strategy Pattern)

![Java](https://img.shields.io/badge/Java-8-blue) ![Tomcat](https://img.shields.io/badge/Tomcat-9-yellow) ![MySQL](https://img.shields.io/badge/MySQL-8-orange)

## Mục tiêu
Xây dựng ứng dụng quản lý ghi chú, sử dụng **Strategy pattern** để dễ dàng chuyển đổi
việc lưu trữ dữ liệu giữa **CSDL MySQL** và **tệp tin**.

## Cấu trúc dự án

```
inotes/
├── sql/inotes.sql                          # Bước 1: Script tạo CSDL iNotes
├── pom.xml                                 # Maven config (war)
└── src/main/
    ├── java/codegym/inotes/
    │   ├── model/
    │   │   ├── Note.java                   # Bước 7: Interface (Strategy)
    │   │   ├── NoteDB.java                 # Bước 2: Lưu trong MySQL
    │   │   └── NoteFile.java               # Bước 8: Lưu trong tệp tin
    │   └── controller/
    │       ├── NoteManagement.java         # Bước 3 + 8: searchNotes, addNote, changeNoteStore
    │       └── NoteServlet.java            # Servlet điều khiển chính
    └── webapp/
        ├── WEB-INF/web.xml
        ├── list.jsp                        # Bước 5: Trang liệt kê + tìm kiếm
        ├── add.jsp                         # Bước 4: Form thêm Ghi chú
        └── detail.jsp                      # Bước 6: Trang chi tiết Ghi chú
```

## Sơ đồ lớp (Strategy Pattern)

```
                    ┌──────────────────────┐
                    │    <<interface>>     │
                    │        Note          │
                    │──────────────────────│
                    │ + setTitle(title)    │
                    │ + setContent(content)│
                    │ + setTypeId(typeId)  │
                    │ + getTitle()         │
                    │ + getContent()       │
                    │ + getType()          │
                    │ + save()             │
                    │ + delete()           │
                    │ + search(keyword)    │
                    └──────────△───────────┘
                               │
              ┌────────────────┴────────────────┐
              │                                 │
    ┌───────────────────┐             ┌───────────────────┐
    │      NoteDB       │             │      NoteFile     │
    │  (lưu trong MySQL)│             │ (lưu trong file)  │
    └───────────────────┘             └───────────────────┘
              ▲                                 ▲
              └──────────────┬──────────────────┘
                    ┌────────┴─────────┐
                    │  NoteManagement  │
                    │──────────────────│
                    │ - note: Note     │
                    │ + changeNoteStore│
                    │ + searchNotes()  │
                    │ + addNote()      │
                    │ + deleteNote()   │
                    └──────────────────┘
```

## Cấu trúc tệp tin lưu Ghi chú (NoteFile)

Mỗi dòng một ghi chú theo định dạng `id,title,typeId,content`
(content đặt cuối dòng nên có thể chứa dấu phẩy; tiêu đề không chứa dấu phẩy):

```
1,Hoc Java,1,Mexh gap 3 gio, hoc Strategy pattern
2,Di cho,2,Mua rau va trai cay
3,Y tuong moi,3,Lam app ghi chu
```

## Hướng dẫn chạy

### 1. Tạo CSDL
Chạy script `sql/inotes.sql` trong MySQL Workbench hoặc:
```bash
mysql -u root -p < sql/inotes.sql
```

### 2. Cấu hình kết nối
Sửa thông tin đăng nhập MySQL trong file `NoteDB.java`:
```java
private static final String JDBC_URL = "jdbc:mysql://localhost:3306/iNotes?useSSL=false&serverTimezone=UTC";
private static final String JDBC_USER = "root";
private static final String JDBC_PASSWORD = "123456";   // ← đổi mật khẩu của bạn
```

### 3. Deploy lên Tomcat 9
```bash
mvn clean package          # tạo target/inotes.war
# Copy target/inotes.war vào webapps/ của Tomcat 9, hoặc:
mvn tomcat7:deploy         # nếu dùng plugin tomcat
```
Hoặc mở dự án bằng **IntelliJ IDEA** → Add Configuration → **Tomcat Server → Local** →
Deployment → artifact `inotes:war exploded` → Run.

### 4. Truy cập
```
http://localhost:8080/inotes/notes
```

## Chức năng chính

| Chức năng | URL | Mô tả |
|-----------|-----|-------|
| Danh sách | `/notes?store=db` | Liệt kê ghi chú lưu trong CSDL |
| Danh sách | `/notes?store=file` | Liệt kê ghi chú lưu trong tệp tin |
| Tìm kiếm | `/notes?keyword=xxx` | Tìm trong **cả CSDL lẫn tệp tin** |
| Thêm | `/notes?action=add` | Form thêm ghi chú mới |
| Chi tiết | `/notes?action=view&id=1` | Xem chi tiết ghi chú |
| Xóa | `/notes?action=delete&id=1` | Xóa ghi chú |

## Về Strategy Pattern

- `Note` là **interface** chung cho 2 chiến lược lưu trữ.
- `NoteDB` và `NoteFile` là 2 **strategy** cụ thể, đều triển khai đầy đủ
  `save()`, `delete()`, `search()`.
- `NoteManagement` chứa tham chiếu `note` kiểu `Note` và có phương thức
  `changeNoteStore(storeType)` để **hoán đổi strategy lúc runtime** mà không
  cần sửa code phía trình bày (JSP/Servlet) — đúng tinh thần
  *"Program to an interface, not an implementation"*.
