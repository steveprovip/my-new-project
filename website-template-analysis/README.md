# [Bài tập] Phân tích và Xây dựng Cấu Trúc Website Template

Dự án bài tập phân tích cấu trúc bố cục một website thực tế và tái hiện lại bằng HTML5 & CSS thuần (CodeGym).

## 1. Báo cáo phân tích cấu trúc website thực tế
Dựa trên khảo sát cấu trúc các website tin tức & công nghệ hàng đầu (như Medium, TechCrunch):
- **Header**: Đặt ở phần trên cùng của trang web, chứa tiêu đề thương hiệu (`site-title`) và câu khẩu hiệu ngắn gọn (`site-tagline`) để người đọc định hình nội dung ngay khi truy cập.
- **Navigation Menu**: Thanh thực đơn nằm ngang, gắn chặt phía dưới Header và sử dụng thuộc tính `position: sticky; top: 0;` để luôn theo sát người dùng khi cuộn trang; gồm 5 mục điều hướng chính (`Trang chủ`, `Báo cáo phân tích`, `Dịch vụ & Đào tạo`, `Về chúng tôi`, `Liên hệ`).
- **Content Section**: Bố cục nội dung chính gồm 2 phần:
  - Khối tóm tắt phân tích bố cục (`analysis-card`) trình bày dạng lưới 2 cột (`grid-template-columns: repeat(2, 1fr)`).
  - Khối giới thiệu nội dung kết hợp văn bản mô tả và hình ảnh minh họa thực tế (`content-showcase`) bằng Flexbox 2 cột cân xứng.
- **Footer**: Chân trang nền tối (`#0f172a`) hiển thị thông tin bản quyền pháp lý, phụ chú môn học và các liên kết chính sách nhanh.

## 2. Cấu trúc thư mục
```text
website-template-analysis/
├── index.html
├── css/
│   └── style.css
└── README.md
```

## 3. Cách mở và kiểm tra
Mở trực tiếp file `index.html` trong trình duyệt web để xem bố cục gọn gàng, chuẩn Responsive trên cả Desktop và Mobile.
