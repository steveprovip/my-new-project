# [Thực hành] CSS | flex-flow Property

Bài thực hành tìm hiểu và sử dụng thuộc tính `flex-flow` trong CSS Flexbox (CodeGym).

## 1. Lý thuyết tổng quan
Thuộc tính `flex-flow` là cú pháp viết tắt (shorthand) tích hợp đồng thời hai thuộc tính:
- `flex-direction`: Hướng sắp xếp trục chính (`row`, `row-reverse`, `column`, `column-reverse`).
- `flex-wrap`: Kiểm soát việc ngắt/bọc dòng (`nowrap`, `wrap`, `wrap-reverse`).

### Cú pháp:
```css
flex-flow: <flex-direction> <flex-wrap>;
```

## 2. Các ví dụ minh họa
- **`flex-flow: row nowrap;`**: Xếp theo hàng ngang từ trái sang phải, không xuống dòng (mặc định).
- **`flex-flow: row-reverse nowrap;`**: Xếp theo hàng ngang ngược hướng (từ phải sang trái), không xuống dòng.
- **`flex-flow: row wrap;`**: Xếp theo hàng ngang, tự động xuống dòng khi đầy.
- **`flex-flow: column wrap;`**: Xếp theo cột dọc, tự động ngắt sang cột mới khi chạm giới hạn chiều cao.
