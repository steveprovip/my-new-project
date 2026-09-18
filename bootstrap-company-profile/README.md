# [Thực hành] Tạo Trang Giới Thiệu Doanh Nghiệp với Bootstrap

Bài thực hành thiết kế trang giới thiệu công ty/doanh nghiệp hoàn chỉnh bằng Bootstrap 5.3.0 CDN (CodeGym).

## 1. Cài đặt Bootstrap 5 CDN
- **CSS** trong thẻ `<head>`:
  ```html
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  ```
- **JS Bundle** trước thẻ đóng `</body>`:
  ```html
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  ```

## 2. Các thành phần chính (Components)
- **Navbar (Bước 2.2)**: Nền sáng (`navbar-light bg-light`), thương hiệu Doanh Nghiệp, menu `Trang Chủ`, `Về Chúng Tôi`, `Dịch Vụ`, `Liên Hệ`.
- **Hero Section (Bước 2.3)**: Khối chào mừng nền xanh (`bg-primary text-white text-center py-5`) với nút CTA `Tìm Hiểu Ngay`.
- **About Section (Bước 2.4)**: Giới thiệu thông tin về năng lực và định hướng công ty.
- **Services Section (Bước 2.5)**: Lưới 3 cột Bootstrap Grid (`col-md-4`) chứa các dịch vụ: *Thiết kế Website, Marketing Online, Hỗ trợ khách hàng*.
- **Contact Section (Bước 2.6)**: Thông tin liên hệ gồm Email và Hotline.
- **Footer (Bước 2.7)**: Nền tối bản quyền trang web.

## 3. Chạy thử nghiệm
Mở trực tiếp file `index.html` trong trình duyệt web để xem giao diện và kiểm tra tính năng Responsive trên các độ phân giải màn hình khác nhau.
