# [Thực hành] Template web page using HTML and CSS

Dự án mẫu thiết kế giao diện trang web giới thiệu công nghệ lập trình sử dụng cấu trúc thẻ ngữ nghĩa HTML5 và CSS Layout Flexbox theo đề bài CodeGym.

## 1. Cấu trúc bài làm
- **Navbar sticky (`.navbar.background`)**:
  - Logo tròn bên trái.
  - Danh sách liên kết: `Web Technology`, `C Programming`, `Courses`.
  - Ô tìm kiếm và nút search bo góc bên phải (`.rightNav`).
- **Section 1 - Web Technology (`.firstsection`)**: Nền xanh lá, hiển thị giới thiệu về HTML và ngôn ngữ đánh dấu.
- **Section 2 - C Programming (`.secondsection`)**: Nền xanh dương, hiển thị nguồn gốc và đặc điểm của ngôn ngữ C.
- **Section 3 - Java (`.section`)**: Bố cục Flexbox kết hợp văn bản bên trái và hình ảnh thumbnail laptop bên phải (hỗ trợ `flex-direction: row-reverse` khi muốn đổi hướng).
- **Footer (`footer.background`)**: Chân trang nền đen căn giữa hiển thị bản quyền `All rights are reserved`.

## 2. Các kỹ thuật CSS nổi bật
- **Flexbox**: Căn lề điều hướng bằng `display: flex; justify-content: space-between; align-items: center;`.
- **Position Sticky**: Giữ thanh Navbar cố định trên đỉnh khi cuộn trang (`position: sticky; top: 0;`).
- **Google Fonts**: Nhúng font `Piazzolla` cho tiêu đề lớn và `Ubuntu` cho phần chân trang.

## 3. Cách mở và kiểm tra
Mở trực tiếp file `index.html` trong trình duyệt web để xem giao diện hoàn chỉnh.
