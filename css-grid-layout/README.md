# [Thực hành] Xây dựng bố cục trang web với CSS Grid

Thực hành tạo bố cục website chuẩn Responsive sử dụng CSS Grid (`grid-template-areas`, `grid-template-columns`, `grid-template-rows`).

## Cấu trúc bố cục
- **Header**: Chiếm toàn bộ chiều ngang hàng đầu tiên (`header header`).
- **Sidebar**: Chiếm 1 cột bên trái (`1fr`).
- **Content**: Chiếm 3 cột bên phải (`3fr`).
- **Footer**: Chiếm toàn bộ chiều ngang hàng cuối cùng (`footer footer`).

## Responsive (Mobile <= 768px)
- Bố cục chuyển sang 1 cột duy nhất dạng xếp chồng dọc:
  - Header
  - Sidebar
  - Content
  - Footer
