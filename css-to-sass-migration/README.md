# [Thực hành] Chuyển đổi CSS có sẵn sang SASS theo chuẩn

Dự án bài thực hành chuyển đổi file CSS truyền thống ban đầu sang cấu trúc SASS/SCSS theo mô hình chia module chuẩn (CodeGym).

## 1. File CSS ban đầu
```css
body {
  font-family: Arial, sans-serif;
  color: #333;
  background: #f4f4f4;
}

.container {
  width: 80%;
  margin: 0 auto;
}

.button {
  background: blue;
  color: white;
  padding: 10px 20px;
  border-radius: 5px;
}

.card {
  border: 1px solid #ddd;
  padding: 20px;
  box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
}
```

## 2. Cấu trúc SASS sau khi chuyển đổi
```text
css-to-sass-migration/
├── index.html                  # Giao diện HTML minh họa
├── scss/
│   ├── main.scss               # Import tập trung các partials
│   ├── abstracts/
│   │   ├── _variables.scss     # Khai báo các biến $primary-color, $border-color...
│   │   └── _mixins.scss        # Khai báo mixin button-style, box-shadow
│   ├── base/
│   │   └── _global.scss        # Định dạng thẻ body
│   ├── layout/
│   │   └── _container.scss     # Định dạng .container
│   └── components/
│       ├── _buttons.scss       # Định dạng .button tái sử dụng mixin
│       └── _cards.scss         # Định dạng .card tái sử dụng mixin
└── css/
    ├── styles.css              # File CSS sau khi SASS CLI biên dịch
    └── styles.css.map
```

## 3. Lợi ích đạt được
- Tối ưu hóa bằng biến (`$variables`) và hàm tái sử dụng (`@mixin`).
- Code rõ ràng, không trùng lặp và cực kỳ dễ dàng mở rộng, bảo trì.
