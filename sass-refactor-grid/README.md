# [Bài tập] Tái cấu trúc mã CSS cho sẵn (Responsive Grid)

Dự án tái cấu trúc toàn bộ mã nguồn HTML/CSS từ kho lưu trữ [codegym-vn/responsive-grid](https://github.com/codegym-vn/responsive-grid) sang kiến trúc SASS module chuẩn hóa (CodeGym).

## 1. Vấn đề của mã nguồn ban đầu
- Viết hầu như toàn bộ định dạng inline trong thẻ HTML (`style="height:90px; background:#9933cc; border-right-color:transparent;"...`).
- Lặp lại mã màu và chiều cao thủ công ở nhiều thẻ div.
- Khó bảo trì, không có biến số quy định lưới 12 cột.

## 2. Giải pháp tái cấu trúc với SASS
- **abstracts/_variables.scss**: Khai báo biến màu nhận diện (`$color-header`, `$color-menu-accent`, `$color-footer`) và tỉ lệ chia 12 cột tự động (`$grid-col-width: 8.333333%;`).
- **abstracts/_mixins.scss**: Xây dựng `@mixin clearfix` và `@mixin grid-column($col-span: 1)` giúp tính toán chiều rộng cột linh hoạt.
- **base/_reset.scss**: Reset `box-sizing: border-box` và margin/padding.
- **layout/_grid.scss**: Tách toàn bộ thuộc tính inline vào các class có ngữ nghĩa và theo chuẩn BEM (`.gridwrapper--header`, `.gridcontent--sidebar`, `.menu-item`...).
- **main.scss**: Import tập trung toàn bộ các file partials và biên dịch tự động sang `css/styles.css`.

## 3. Cấu trúc thư mục
```text
sass-refactor-grid/
├── index.html                  # HTML sạch, loại bỏ hoàn toàn inline CSS
├── scss/
│   ├── main.scss               # File SASS trung tâm
│   ├── abstracts/
│   │   ├── _variables.scss     # Biến màu sắc & độ rộng cột
│   │   └── _mixins.scss        # Mixin clearfix & grid-column
│   ├── base/
│   │   └── _reset.scss         # Reset CSS
│   └── layout/
│       └── _grid.scss          # Định dạng cấu trúc lưới
└── css/
    ├── styles.css              # File CSS sau khi biên dịch từ SASS
    └── styles.css.map
```
