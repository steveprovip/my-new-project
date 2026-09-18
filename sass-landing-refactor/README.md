# [Bài tập] Tái cấu trúc mã CSS của các bài tập đã làm

Dự án tái cấu trúc toàn bộ 4 bài tập giao diện trong module Template Landing Page sang kiến trúc SASS chuẩn hóa (CodeGym).

## 1. Các bài tập được tích hợp & tái cấu trúc
Dự án bao gồm đầy đủ 4 bài tập con thành một Landing Page hoàn chỉnh:
1. **[Bài tập] Dựng navigation và header của landing page thiết kế sẵn**:
   - Tái cấu trúc trong `layout/_header.scss`.
   - Navbar sticky kết hợp hiệu ứng kính mờ `backdrop-filter: blur`, menu dạt phải và Hero header nền gradient tối.
2. **[Bài tập] Dựng phần sản phẩm nổi bật của landing page thiết kế sẵn**:
   - Tái cấu trúc trong `components/_products.scss`.
   - Lưới sản phẩm 3 cột (Desktop) tự co về 2 cột (Tablet) và 1 cột (Mobile) qua mixin `@include responsive()`.
   - Card sản phẩm tái sử dụng mixin `@include card-style` với hiệu ứng nhấc nổi khi hover.
3. **[Bài tập] Dựng phần số liệu thống kê của landing page thiết kế sẵn**:
   - Tái cấu trúc trong `components/_stats.scss`.
   - Lưới thống kê 4 cột (`stats-grid`) trên nền màu gradient chuyển sắc, chữ số to đậm ấn tượng.
4. **[Bài tập] Dựng phần footer của landing page thiết kế sẵn**:
   - Tái cấu trúc trong `layout/_footer.scss`.
   - Bố cục lưới chân trang 4 cột (`footer-grid`) và dòng bản quyền dưới cùng.

## 2. Kiến trúc thư mục SASS
```text
sass-landing-refactor/
├── index.html                  # Giao diện Landing Page hoàn chỉnh
├── scss/
│   ├── main.scss               # Import tập trung toàn bộ các partials
│   ├── abstracts/
│   │   ├── _variables.scss     # Biến màu, font, spacing, border-radius
│   │   └── _mixins.scss        # Mixins flex, card-style, responsive breakpoint
│   ├── base/
│   │   └── _reset.scss         # Reset margin, padding, box-sizing, container
│   ├── layout/
│   │   ├── _header.scss        # Module Navigation & Hero Section
│   │   └── _footer.scss        # Module Chân trang
│   └── components/
│       ├── _buttons.scss       # Module nút bấm
│       ├── _products.scss      # Module lưới sản phẩm nổi bật
│       └── _stats.scss         # Module số liệu thống kê
└── css/
    ├── styles.css              # File CSS sau khi SASS CLI biên dịch
    └── styles.css.map
```

## 3. Lợi ích của việc tái cấu trúc sang SASS
- **Không còn lặp CSS**: Mọi thuộc tính Flexbox, căn giữa, thẻ Card đều được đóng gói thành `@mixin`.
- **Dễ đổi giao diện**: Bảng màu chủ đạo, font chữ và kích thước đệm chỉ cần sửa 1 lần tại `_variables.scss`.
- **Bảo trì nhanh chóng**: Mỗi phần giao diện nằm riêng biệt trong một file SCSS theo đúng chức năng.
