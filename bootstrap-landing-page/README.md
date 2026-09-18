# [Thực hành] Xây dựng Landing Page với Bootstrap

Bài thực hành xây dựng trang Landing Page hoàn chỉnh bằng Bootstrap 5.3.0 CDN theo quy trình chuẩn từng bước (CodeGym).

## 1. Cài đặt Bootstrap 5 CDN
- CSS trong `<head>`:
  ```html
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  ```
- JS Bundle trước thẻ đóng `</body>`:
  ```html
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  ```

## 2. Các thành phần chính (Components)
- **Navbar**: Nền tối (`navbar-dark bg-dark`), nút Hamburger toggler cho mobile, các liên kết `Home`, `About`, `Services`, `Contact` dạt sang phải (`ms-auto`).
- **Hero Section**: Khối tiêu đề lớn chào mừng, nút Call to Action (`btn btn-light`).
- **Grid System - Services**: Lưới 3 cột (`row` và `col-md-4`) chứa các thẻ Card giới thiệu dịch vụ (Thiết kế Web, SEO & Marketing, Hỗ trợ 24/7).
- **Footer**: Nền tối hiển thị thông tin bản quyền trang web.

## 3. Chạy thử nghiệm
Mở file `index.html` trong trình duyệt web để xem giao diện hoàn thiện và kiểm tra tính năng Responsive.
