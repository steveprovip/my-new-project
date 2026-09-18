# [Thực hành] CSS | flex-grow Property

Bài thực hành tìm hiểu và ứng dụng thuộc tính `flex-grow` trong CSS Flexbox (CodeGym).

## 1. Lý thuyết tổng quan
Thuộc tính `flex-grow` chỉ định tỷ lệ một flex item sẽ mở rộng bao nhiêu so với các item khác khi còn không gian trống trong Flex Container.

### Cú pháp:
```css
flex-grow: number | initial | inherit;
```

### Các giá trị:
- **`number`**: Số nguyên hoặc số thực không âm (0, 1, 2, 3...) xác định tỷ lệ phân bổ khoảng trống còn lại. Mặc định là `0`.
- **`initial`**: Đặt lại về giá trị mặc định của CSS (`0`).
- **`inherit`**: Kế thừa giá trị từ phần tử cha.

## 2. Minh họa thực hành
- **Ví dụ 1 (theo đề bài)**: Một vùng chứa gồm 5 thẻ `div`, trong đó thẻ thứ 2 được gán `flex-grow: 3`, còn 4 thẻ khác có `flex-grow: 0`. Thẻ thứ 2 sẽ phát triển và chiếm phần lớn chiều rộng của vùng chứa.
- **Ví dụ 2**: So sánh tỷ lệ phát triển giữa các phần tử theo tỷ lệ 1 : 2 : 1.
