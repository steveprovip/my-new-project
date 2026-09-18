# [Bài tập] Tạo Trang Đăng Ký Người Dùng (Bootstrap Form & Carousel)

Dự án giao diện trang đăng ký tài khoản chuyên nghiệp kết hợp giữa Bootstrap Carousel (giới thiệu lợi ích dịch vụ) và Bootstrap Forms (form đăng ký) theo tiêu chuẩn Responsive (CodeGym).

## 1. Cấu trúc giao diện
- **Bố cục 2 cột (Bootstrap Grid)**:
  - **Cột trái (`col-lg-6`)**: Carousel trình diễn 3 slide lợi ích dịch vụ nổi bật (*Học tập không giới hạn, Kèm cặp 1-1, Cơ hội việc làm*), tự động trượt kèm chú thích và hiệu ứng ảnh mượt mà.
  - **Cột phải (`col-12 col-lg-6`)**: Khối form đăng ký người dùng với thiết kế thẩm mỹ cao.
- **Form đăng ký gồm 4 trường thông tin bắt buộc**:
  1. **Họ và tên**: Thẻ input kết hợp `input-group` có icon người dùng.
  2. **Email**: Thẻ input kết hợp `input-group` có icon phong thư.
  3. **Mật khẩu**: Thẻ input type password với icon ổ khóa.
  4. **Xác nhận mật khẩu**: Thẻ input type password với icon bảo mật.
  - Checkbox chấp nhận điều khoản.
  - Nút đăng ký `btn btn-primary btn-lg` kích thước lớn full-width.

## 2. Tiêu chuẩn Bootstrap áp dụng
- Tận dụng tối đa các class có sẵn của Bootstrap 5: `form-control`, `input-group`, `input-group-text`, `btn-primary`, `carousel slide`, `carousel-item`, `carousel-caption`.
- Bố cục tự động co giãn và ẩn Carousel trên màn hình nhỏ (`d-none d-lg-block`) để người dùng mobile tập trung trực tiếp vào form đăng ký nhanh chóng.

## 3. Cách mở và kiểm tra
Mở trực tiếp file `index.html` trong trình duyệt web để xem slider tự động chuyển đổi và form đăng ký chuẩn đẹp.
