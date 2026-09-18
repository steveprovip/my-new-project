# [Thực hành] Tạo Website Template Có Giao Diện Đẹp Mắt

Dự án Website Template nâng cao áp dụng CSS Flexbox & CSS Grid, hình nền mờ (blur backdrop), hiệu ứng hover thẻ Card và menu cố định khi cuộn (CodeGym).

## 1. Cấu trúc thư mục dự án
```
website-template-advanced/
├── index.html
├── css/
│   └── style.css
├── images/
└── README.md
```

## 2. Các điểm nâng cấp nổi bật
- **Header**: Sử dụng ảnh nền chất lượng cao, lớp phủ tối mờ (`backdrop-filter: blur`), chữ nổi bật và nút bấm Call to Action có hiệu ứng đổi màu khi hover.
- **Navigation**: Menu dùng `position: sticky` hoặc `position: fixed` cố định trên đỉnh khi cuộn trang, căn giữa bằng Flexbox và hiệu ứng đổi màu vàng cam khi hover.
- **Content Section (Card Layout)**: Bố cục lưới CSS Grid 3 cột (`repeat(3, 1fr)`), thẻ card có viền bóng đổ nhẹ nhàng và hiệu ứng nhấc nổi `transform: translateY(-8px)` khi rê chuột.
- **Footer**: Bố cục 2 cột bằng Flexbox (`justify-content: space-between`) phân cấp nội dung chuyên nghiệp bằng dấu chấm (`•`).
- **Responsive**: Hỗ trợ hiển thị tối ưu trên cả máy tính bảng (2 cột) và điện thoại di động (1 cột).

## 3. Cách xem
Mở trực tiếp file `index.html` trong trình duyệt web để trải nghiệm.
