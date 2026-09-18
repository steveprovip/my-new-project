# [Thực hành] CSS | flex-wrap property

Bài thực hành tìm hiểu và ứng dụng thuộc tính `flex-wrap` trong CSS Flexbox (CodeGym).

## 1. Lý thuyết tổng quan
Thuộc tính `flex-wrap` quy định các flex items có được phép xuống dòng mới khi kích thước container không đủ chứa hay không.

### Cú pháp:
```css
flex-wrap: nowrap | wrap | wrap-reverse | initial;
```

## 2. Các giá trị chi tiết
- **`nowrap` (Mặc định)**: Các phần tử ép nằm trên 1 hàng, không tự ngắt dòng.
- **`wrap`**: Các phần tử tự động xuống dòng kế tiếp khi đầy hàng ngang.
- **`wrap-reverse`**: Các phần tử xuống dòng nhưng thứ tự các hàng bị đảo ngược (hàng mới nằm ở trên).
- **`initial`**: Đặt lại về giá trị mặc định của CSS (`nowrap`).

## 3. Cách mở bài thực hành
Mở file `index.html` trực tiếp trên trình duyệt để so sánh trực quan cả 4 trường hợp giá trị.
