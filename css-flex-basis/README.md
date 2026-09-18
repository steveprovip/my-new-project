# [Thực hành] CSS | flex-basis Property

Bài thực hành tìm hiểu và sử dụng thuộc tính `flex-basis` trong CSS Flexbox (CodeGym).

## 1. Lý thuyết tổng quan
Thuộc tính `flex-basis` dùng để chỉ định kích thước ban đầu (main size) của một flex item trước khi không gian trống còn lại được phân bổ.

### Cú pháp:
```css
flex-basis: number | auto | initial | inherit;
```

### Các giá trị:
- **`number` (px, %, em, rem...)**: Độ dài ban đầu cụ thể của phần tử.
- **`auto` (mặc định)**: Chiều dài dựa theo thuộc tính kích thước hoặc nội dung của item.
- **`initial`**: Thiết lập về giá trị mặc định của thuộc tính.
- **`inherit`**: Kế thừa giá trị từ phần tử cha.

## 2. Các ví dụ minh họa
- **Ví dụ 1**: Các phần tử có `flex-basis` cố định khác nhau (100px, 250px, 150px).
- **Ví dụ 2**: Ứng dụng trong bố cục cột giao diện (Sidebar có `flex-basis: 220px`, Main Content dùng `flex-basis: auto` và `flex-grow: 1` để chiếm trọn phần còn lại).
