# [Thực hành] Xây dựng Trang Chủ với Bootstrap

Bài thực hành thiết kế trang chủ hoàn chỉnh kết hợp Bootstrap 5.3.0, Carousel, Flexbox căn giữa, Font Awesome Icons và Contact Form (CodeGym).

## 1. Các thành phần chính (Components)
- **Bước 1**: Nhúng Bootstrap 5.3.0 CDN (CSS & JS) và Font Awesome 6 Icons CDN.
- **Bước 2 (Navbar & Font Awesome)**: Thanh điều hướng nền tối (`navbar-dark bg-dark`) có icon trang chủ `<i class="fas fa-home"></i>` và menu `Home`, `About`, `Services`, `Contact`.
- **Bước 3 (Hero Section với Carousel)**: Slideshow hình ảnh tự động trượt (`carousel slide`, `data-bs-ride="carousel"`) có nút Next/Prev điều khiển và tiêu đề chú thích.
- **Bước 4 (Section với Flexbox)**: Khối chào mừng sử dụng các tiện ích Flexbox của Bootstrap (`d-flex justify-content-center align-items-center bg-light py-5`).
- **Bước 5 (Contact Form với Bootstrap Form)**: Form liên hệ gồm Tên, Email, Nội dung tin nhắn và nút gửi `btn-primary`.

## 2. Kiểm tra
Mở trực tiếp file `index.html` trong trình duyệt để xem slideshow tự động chạy và thử tính năng tương thích Responsive trên thiết bị di động.
