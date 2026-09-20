# AI Prompt Log — MetricsHub

## Prompt 1 — Phân tích 1D vs 2D
> "Khi tôi cần một bố cục mà một phần tử con phải chiếm chính xác 2 hàng và 2 cột (span 2 rows, 2 columns) đan xen với các phần tử nhỏ khác, tôi nên chọn CSS Grid hay Flexbox? Tại sao Flexbox lại chật vật với yêu cầu này?"

**Kết quả:** Chọn CSS Grid — Grid làm việc trên cả 2 trục (hàng + cột) nên một item có thể chiếm nhiều ô bằng `grid-column: span 2; grid-row: span 2;`. Flexbox chỉ làm việc trên 1 trục, muốn "giả grid" phải lồng nhiều container → Div Soup, và phải fix cứng `height` cho các widget lớn.

## Prompt 2 — Phản biện lựa chọn Bootstrap cho Pricing
> "Trong Bootstrap 5, sự khác biệt giữa col-sm-4 và col-md-4 là gì? Tại sao tôi nên dùng Bootstrap thay vì tự viết CSS Grid cho 3 cột Bảng giá?"

**Kết quả:** `col-sm-4` áp dụng từ breakpoint ≥576px, `col-md-4` từ ≥768px. Với bài này dùng `col-12 col-md-4`: mobile mặc định full-width, từ tablet trở lên thành 3 cột. Dùng Bootstrap vì: hệ 12 cột chuẩn hóa, đã test sẵn responsive, giảm CSS tự viết và dễ bảo trì.

## Prompt 3 — Bento Box syntax
> "Hãy cho tôi xem cú pháp CSS Grid (dùng span) để tạo layout Bento Box: 1 ô lớn bên trái chiếm 2×2, các ô nhỏ bên phải."

**Kết quả:** `grid-template-columns: repeat(3, 1fr); grid-auto-rows: minmax(120px, auto);` + `.large { grid-column: span 2; grid-row: span 2; }` — đã áp dụng cho Chart A.

## Prompt 4 — Navbar responsive bằng flex-wrap
> "Làm thế nào dùng flex-wrap: wrap để Navbar trên điện thoại tự động đẩy menu xuống dòng mà không che khuất Logo?"

**Kết quả:** Đặt `flex-wrap: wrap` + `gap` cho `.nav-flexbox` và `.nav-menu`; logo giữ `flex-shrink: 0` ngầm vì là item riêng — menu tự rớt xuống hàng dưới thay vì tràn/đè lên nhau.

## Prompt 5 — gap thay thế margin
> "Thuộc tính gap hỗ trợ cho cả Grid và Flexbox như thế nào, dùng để thay margin lộn xộn ra sao?"

**Kết quả:** `gap` định nghĩa khoảng cách giữa các item (cả 2 trục với Grid: `row-gap`/`column-gap`) mà không tạo margin dư ở mép ngoài container, giúp bỏ các hack `margin: -x` và `margin` lộn xộn giữa siblings.
