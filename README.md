# CodeGym - Dự Án Thiết Kế UI/UX Trang Đăng Ký Người Dùng

Dự án thực hành thiết kế giao diện Đăng ký người dùng và Xác nhận thành công theo tiêu chuẩn UI/UX hiện đại, tuân thủ Fitts' Law và Responsive Design đa nền tảng.

## 📌 Tính Năng Nổi Bật
- **Trang 1: Form Đăng Ký**:
  - 4 trường thông tin bắt buộc (*Họ và tên, Email, Mật khẩu, Xác nhận mật khẩu*).
  - Tích hợp đăng ký nhanh bằng tài khoản Google & GitHub (áp dụng Jakob's Law).
  - Thước đo độ mạnh mật khẩu trực quan (Feedback) kèm 4 tiêu chí bảo mật.
  - Chức năng ẩn/hiện mật khẩu và kiểm tra mật khẩu trùng khớp tức thì (Error Prevention).
  - Nút Submit chính kích thước lớn 52px full-width chuẩn Fitts' Law.
- **Trang 2: Xác Nhận Thành Công**:
  - Huy hiệu thành công kèm hiệu ứng phát sáng (Pulse animation).
  - Thẻ tóm tắt thông tin người dùng vừa đăng ký.
  - Nút Primary CTA điều hướng đến Dashboard và nút gửi lại email kích hoạt với bộ đếm ngược 60 giây.
- **Thanh Công Cụ Trình Diễn**:
  - Chuyển đổi giữa chế độ **Hi-Fi UI** (giao diện hoàn thiện), **Wireframe Mode** (bản phác thảo khung dây mộc), và **Ghi chú UX** (hiển thị trực quan các định luật Fitts, Jakob, Hick).
  - Hỗ trợ chuyển đổi Dark Mode / Light Mode.

## 📁 Cấu Trúc Thư Mục
```
F:\CodeGym\
├── index.html              # Trang giao diện chính (Trang 1 & Trang 2)
├── styles.css              # Hệ thống CSS Design Tokens, Fitts' Law, Responsive
├── app.js                  # Logic kiểm tra validation và chuyển trang
├── BAOCAO_THIETKE_UI_UX.md # Báo cáo nghiên cứu & thuyết minh UI/UX chi tiết
├── README.md               # Giới thiệu tổng quan dự án
└── screenshots/            # Bộ ảnh chụp nộp bài chất lượng cao
```

## 🚀 Hướng Dẫn Chạy Dự Án
1. Tải hoặc clone repository về máy:
   ```bash
   git clone https://github.com/steveprovip/codegym-ui-ux-register.git
   ```
2. Mở trực tiếp file `index.html` bằng trình duyệt web bất kỳ (Google Chrome, Microsoft Edge, Mozilla Firefox).
