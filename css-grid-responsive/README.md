# [Bài tập] Tạo bố cục responsive bằng CSS Grid

Bài tập tạo bố cục trang web hoàn chỉnh và thích ứng linh hoạt (Responsive) trên Desktop & Mobile bằng CSS Grid Layout (CodeGym).

## 1. Yêu cầu bài toán & Cấu trúc các thành phần
Gồm 5 khu vực chức năng chính:
- **Header (`header`)**: Tiêu đề trang web.
- **Navigation (`nav`)**: Thanh menu điều hướng các danh mục.
- **Main Content (`main`)**: Khu vực hiển thị nội dung chính bài viết và tính năng.
- **Sidebar (`sidebar`)**: Cột chứa widget tin tức nổi bật và quảng cáo.
- **Footer (`footer`)**: Thông tin bản quyền chân trang.

## 2. Thiết kế Grid & Responsive
- **Desktop (mặc định > 768px)**:
  ```css
  grid-template-columns: 3fr 1fr;
  grid-template-rows: auto auto 1fr auto;
  grid-template-areas: 
      "header header"
      "nav nav"
      "main sidebar"
      "footer footer";
  ```
- **Mobile (<= 768px)**:
  Chuyển sang dạng 1 cột duy nhất, xếp dọc toàn bộ các khối:
  ```css
  grid-template-columns: 1fr;
  grid-template-areas: 
      "header"
      "nav"
      "main"
      "sidebar"
      "footer";
  ```

## 3. Chạy thử nghiệm
Mở file `index.html` trong trình duyệt và thay đổi kích thước cửa sổ (hoặc mở DevTools F12 Responsive Mode) để kiểm tra giao diện chuyển đổi linh hoạt.
