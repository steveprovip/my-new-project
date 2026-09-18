# [Thực hành] Tạo mixins & biến để tối ưu CSS của website mẫu

Dự án tối ưu hóa CSS bằng cách áp dụng SASS Variables và Mixins theo chuẩn module (CodeGym).

## 1. Cấu trúc thư mục
```text
sass-mixins-variables-demo/
├── index.html                  # Giao diện kiểm thử kết quả hiển thị
├── scss/
│   ├── main.scss               # Import tập trung toàn bộ partials
│   ├── abstracts/
│   │   ├── _variables.scss     # $primary-color, $text-color, $font-large, $font-medium, $padding-standard, $box-shadow-default
│   │   └── _mixins.scss        # @mixin button-style($bg-color), @mixin box-style
│   ├── base/
│   │   └── _typography.scss    # Định dạng h1, h2 theo biến font và màu sắc
│   └── components/
│       ├── _buttons.scss       # @include button-style($primary-color)
│       └── _cards.scss         # @include box-style
└── css/
    ├── styles.css              # File CSS sau khi SASS CLI biên dịch
    └── styles.css.map
```

## 2. Kết quả tối ưu hóa
- **Giảm lặp code**: Toàn bộ định dạng nút bấm và thẻ card được đóng gói vào các mixin có thể tái sử dụng ở bất kỳ đâu.
- **Dễ dàng bảo trì**: Khi muốn thay đổi bảng màu hoặc kích thước chữ của toàn bộ trang web, chỉ cần cập nhật tại file `_variables.scss` một lần duy nhất.
