# [Bài đọc] Cách tổ chức thư mục và file SASS hiệu quả (7-1 Pattern)

Kho lưu trữ mẫu thực hành cấu trúc thư mục SASS theo mô hình chuẩn **7-1 SASS Pattern** dành cho các dự án Web Frontend quy mô vừa và lớn (CodeGym).

## 1. Cấu trúc thư mục chi tiết
```
sass/
│── main.scss         # File SASS chính (import tất cả 7 folder bên dưới)
│── abstracts/        # Chứa biến, mixins, functions
│   │── _variables.scss
│   │── _mixins.scss
│   └── _functions.scss
│── base/             # Thiết lập nền tảng dự án
│   │── _reset.scss
│   │── _typography.scss
│   └── _global.scss
│── layout/           # Bố cục tổng thể
│   │── _header.scss
│   │── _footer.scss
│   └── _grid.scss
│── components/       # Các thành phần UI độc lập
│   │── _buttons.scss
│   └── _cards.scss
│── pages/            # Style riêng cho từng trang
│   │── _home.scss
│   │── _about.scss
│   └── _contact.scss
│── themes/           # Chế độ màu sắc (sáng/tối)
│   │── _light.scss
│   └── _dark.scss
└── vendors/          # Tùy biến thư viện ngoài
    │── _bootstrap.scss
    └── _custom.scss
```

## 2. File main.scss
Đã import toàn bộ 7 thư mục logic theo đúng thứ tự ưu tiên:
1. `abstracts`
2. `base`
3. `layout`
4. `components`
5. `pages`
6. `themes`
7. `vendors`

## 3. Lợi ích
- Code sạch, không trùng lặp, dễ bảo trì và phân công công việc trong nhóm.
