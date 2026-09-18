# [Thực hành] CSS | grid-gap Property

Bài tập thực hành tìm hiểu và sử dụng thuộc tính `grid-gap` trong CSS Grid layout (CodeGym).

## 1. Lý thuyết
Thuộc tính `grid-gap` là thuộc tính viết tắt (shorthand) cho:
- `grid-row-gap`: Khoảng cách giữa các dòng / hàng
- `grid-column-gap`: Khoảng cách giữa các cột

### Cú pháp:
```css
grid-gap: <grid-row-gap> <grid-column-gap>;
```
- Nếu truyền 1 giá trị: `grid-gap: 30px;` thì cả hàng và cột đều cách nhau 30px.
- Nếu truyền 2 giá trị: `grid-gap: 20px 50px;` thì hàng cách 20px, cột cách 50px.

*(Lưu ý: Trong chuẩn CSS Grid hiện đại, thuộc tính này còn được viết ngắn gọn là `gap`, `row-gap`, `column-gap`).*

## 2. Các ví dụ triển khai trong dự án
- **Ví dụ 1**: Lưới 4 cột hiển thị các số từ 1 đến 8 với `grid-gap: 20px 50px;`.
- **Ví dụ 2**: Lưới thẻ Card 3 cột với `grid-gap: 30px;`.

## 3. Cách xem
Mở file `index.html` trực tiếp trên trình duyệt.
