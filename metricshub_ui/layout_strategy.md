# Layout Strategy — MetricsHub

**CSS Grid sinh ra để làm Layout tổng thể, Flexbox sinh ra để làm Component chi tiết.**

- **Navbar → Flexbox:** bố cục 1 chiều (1D), nội dung động (chữ tiếng Đức dài) cần tự giãn theo content thay vì fix cứng pixel như Grid cũ. `flex-wrap` giúp menu rớt dòng đẹp mắt.
- **Dashboard → CSS Grid:** bố cục 2 chiều (2D) dạng Bento Box, widget cần span 2×2 đan xen — Flexbox không kiểm soát được trục dọc và ngang đồng thời, dẫn đến Div Soup. Các `.widget` giờ là siblings trực tiếp của `.grid-dashboard` (DOM phẳng).
- **Pricing → Bootstrap:** lưới chuẩn 12 cột, 3 cột desktop / xếp chồng mobile chỉ bằng `col-12 col-md-4`, không viết thêm CSS thuần nào.

Trong mỗi `.widget` (Grid item) tôi vẫn dùng Flexbox để canh giữa icon + chữ — hai công cụ bổ trợ, không loại trừ.
