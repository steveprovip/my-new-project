# [Bài tập] Thiết kế Trang Giới Thiệu Sản Phẩm (Apple iPhone)

Dự án thiết kế trang giới thiệu sản phẩm phong cách Apple iPhone ([Apple iPhone Product Page](https://www.apple.com/iphone/)) sử dụng Bootstrap Grid System, Flexbox, Display, Margin, Padding và Font Awesome Icons (CodeGym).

## 1. Cấu trúc trang web
- **Apple Global Navbar**: Thanh điều hướng trên cùng với logo Apple, các danh mục Mac, iPad, iPhone, Watch, AirPods cùng icon tìm kiếm & giỏ hàng.
- **iPhone Sub-Navbar**: Thanh phụ hiển thị tên dòng máy `iPhone 16 Pro`, giá khởi điểm và nút mua nhanh `Buy`.
- **Hero Section**: Khối tiêu đề giới thiệu chất liệu Titanium và chip A18 Pro với gradient màu titan đặc trưng, nút CTA tròn và hình ảnh sản phẩm trung tâm.
- **Key Specifications Grid (Highlights)**: Lưới 4 cột (`col-12 col-md-6 col-lg-3`) kết hợp các icon Font Awesome nổi bật:
  - `Camera Control` (icon máy ảnh, camera 48MP)
  - `A18 Pro Chip` (icon vi xử lý, Apple Intelligence)
  - `Battery Life` (icon pin dung lượng lớn đến 33 giờ)
  - `Titanium & Ceramic Shield` (icon khiên bảo vệ siêu bền)
- **Comparison Section**: So sánh 3 phiên bản iPhone (iPhone 16 Pro, iPhone 16, iPhone 15) với bảng thông số kỹ thuật chi tiết.
- **Trade-in CTA Section**: Khối đổi cũ lấy mới với trợ giá.
- **Apple Footer**: Chân trang phong cách tối giản của Apple.

## 2. Tiêu chuẩn Bootstrap áp dụng
- **Flexbox & Alignment**: `d-flex`, `justify-content-center`, `justify-content-between`, `align-items-center`.
- **Grid System**: `row g-4`, `col-12 col-md-6 col-lg-3`, `col-md-4`.
- **Spacing**: Tối ưu khoảng cách trực quan bằng `py-5`, `my-3`, `gap-4`, `p-4`.
- **Font Awesome Icons**: Tích hợp icon trực quan cho từng thông số kỹ thuật.

## 3. Cách mở và kiểm tra
Mở trực tiếp file `index.html` trong trình duyệt web để xem giao diện Apple iPhone sắc nét và mượt mà trên mọi thiết bị.
