# [Bài tập] Tạo bố cục responsive bằng CSS Flexbox

Bài tập xây dựng bố cục trang web hoàn chỉnh và chuẩn Responsive trên thiết bị di động bằng CSS Flexbox (CodeGym).

## 1. Yêu cầu & Cấu trúc các thành phần
Gồm đầy đủ 5 phần theo đề bài:
- **Header**: Tiêu đề và slogan thương hiệu.
- **Navigation**: Menu điều hướng đa mục.
- **Main Content**: Khối bài viết chính và danh sách tính năng con.
- **Sidebar**: Chứa menu khóa học đề xuất và banner ưu đãi.
- **Footer**: Bản quyền và thông tin chân trang.

## 2. Thiết lập Bố cục bằng Flexbox
- **Desktop (màn hình lớn)**:
  - Khung bao `.wrapper`: `display: flex; flex-direction: column; min-height: 100vh;`
  - Khối thân `.main-body`: `display: flex; gap: 20px;`
    - `.main-content`: `flex: 3;` chiếm 3 phần không gian.
    - `.sidebar`: `flex: 1;` chiếm 1 phần không gian.
- **Mobile (màn hình <= 768px)**:
  - Toàn bộ các phần tử xếp dọc gọn gàng theo chiều dọc:
    - `.main-body`: `flex-direction: column;` (Sidebar tự động xếp bên dưới Main Content).
    - `.nav-list`: `flex-direction: column;`
    - `.cards-grid`: `flex-direction: column;`

## 3. Kiểm tra
Mở file `index.html` trong trình duyệt web để kiểm tra tính Responsive trên cả Desktop và Mobile (DevTools F12).
