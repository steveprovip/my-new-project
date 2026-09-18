# [Thực hành] Xây dựng bố cục trang web với CSS Flexbox

Bài thực hành xây dựng bố cục trang web hoàn chỉnh và thích ứng Responsive đa thiết bị bằng CSS Flexbox (CodeGym).

## 1. Cấu trúc bố cục
- **Container chính (`.container`)**: Sử dụng `display: flex; flex-direction: column;` để xếp dọc các phần tử Header, Nav, Main-container và Footer.
- **Main Container (`.main-container`)**:
  - `display: flex; flex: 1;`
  - **Content (`.content`)**: `flex: 3;` chiếm 3 phần không gian.
  - **Sidebar (`.sidebar`)**: `flex: 1;` chiếm 1 phần không gian.

## 2. Responsive (Mobile <= 768px)
- Thay đổi `flex-direction: column;` cho `.main-container` giúp Sidebar tự động xếp xuống dưới Content khi hiển thị trên màn hình nhỏ.
