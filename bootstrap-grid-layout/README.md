# [Bài tập] Thiết kế Trang Web với Bootstrap Grid System

Dự án bài tập thiết kế trang web responsive đa nền tảng sử dụng Bootstrap Containers và Grid System (CodeGym).

## 1. Yêu cầu & Cấu trúc các thành phần
Trang web được thiết kế gồm đầy đủ 5 phần:
1. **Header**: Chứa tiêu đề chính của trang web.
2. **Navbar**: Thanh menu điều hướng với Bootstrap Navbar có Dropdown đa cấp.
3. **Main Content**: Cột hiển thị nội dung chính bài viết.
4. **Sidebar**: Cột chứa thông tin phụ (chuyên mục, form đăng ký tài liệu).
5. **Footer**: Thông tin bản quyền chân trang.

## 2. Thiết lập Bootstrap Grid System & Responsive
- Giới hạn chiều rộng bằng `.container`.
- **Trên Desktop (>= 992px)**:
  - Main Content: `col-md-8 col-lg-8` (chiếm 8/12 cột, tương đương 66.6% chiều ngang).
  - Sidebar: `col-md-4 col-lg-4` (chiếm 4/12 cột, tương đương 33.3% chiều ngang).
- **Trên Mobile (< 992px)**:
  - Cả hai khối sử dụng `col-12`.
  - Sidebar tự động nằm bên dưới Main Content gọn gàng, thuận tiện thao tác lướt trên điện thoại.

## 3. Cách mở và kiểm tra
Mở trực tiếp file `index.html` trong trình duyệt web để kiểm tra tính năng Dropdown và kéo thay đổi kích thước cửa sổ để quan sát hiệu ứng Responsive của Bootstrap Grid.
