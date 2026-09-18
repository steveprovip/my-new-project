# [Thực hành] Tạo Bố Cục 3 Cột bằng Bootstrap Grid và Flexbox

Bài thực hành kết hợp Bootstrap Grid System, Flexbox căn chỉnh nội dung, các class Margin/Padding (`my-5`, `py-3`) và Display Responsive Utilities (`d-none d-md-block`) (CodeGym).

## 1. Nội dung triển khai
- **Bước 1 (Grid 3 cột + Flexbox)**:
  Sử dụng `.row` và 3 cột `.col-md-4`. Kết hợp class `d-flex justify-content-center align-items-center` để căn giữa nội dung theo cả hai chiều ngang và dọc trong từng khối.
- **Bước 2 (Margin & Padding)**:
  Ứng dụng class `my-5` (khoảng cách ngoài trên/dưới) và `py-3` (khoảng cách đệm trong trên/dưới) để định dạng khoảng cách section chuẩn thẩm mỹ.
- **Bước 3 (Display Property ẩn/hiện)**:
  Sử dụng `d-none d-md-block` để ẩn khối nội dung thông báo trên thiết bị di động (`< 768px`) và chỉ cho phép hiển thị trên màn hình máy tính (`>= 768px`).

## 2. Cách kiểm tra
Mở file `index.html` trong trình duyệt web và thay đổi kích thước cửa sổ để kiểm tra hiệu ứng ẩn/hiện của `d-none d-md-block`.
