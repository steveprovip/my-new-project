# [Thực hành] Tạo Navbar với Bootstrap

Bài thực hành tạo thanh điều hướng (Navbar) chuyên nghiệp, chuẩn Responsive sử dụng thư viện Bootstrap 5.3.0 CDN (CodeGym).

## 1. Cài đặt Bootstrap 5 CDN
- **CSS** trong thẻ `<head>`:
  ```html
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  ```
- **JS Bundle** trước thẻ đóng `</body>`:
  ```html
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  ```

## 2. Cấu trúc Navbar
- Khung điều hướng nền tối: `<nav class="navbar navbar-expand-lg navbar-dark bg-dark">`
- Thương hiệu: `<a class="navbar-brand" href="#">MyWebsite</a>`
- Nút bấm thu phóng cho mobile: `<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarNav">`
- Danh sách liên kết: `Home`, `About`, `Contact`
- Danh mục con thả xuống (Dropdown): `Services` (`Web Design`, `SEO`)

## 3. Cách xem & thử nghiệm
Mở file `index.html` trong trình duyệt và:
- Bấm vào mục **Services** để kiểm tra menu Dropdown.
- Thu nhỏ kích thước cửa sổ để kiểm tra nút Toggle trên thiết bị di động.
