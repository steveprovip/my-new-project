# [Thực hành] Tạo layout trong Bootstrap

Bài thực hành tạo bố cục và nội dung trang thương mại điện tử (Online Shopping Mall) sử dụng các thành phần kinh điển của Bootstrap (CodeGym).

## 1. Cấu trúc trang (layout.html)
- **Header**: Banner với hiệu ứng chữ lớn `Impact` ("Online shopping mall"), phụ đề, hình ảnh minh họa dạt phải bằng `.pull-right`.
- **Nav (`navbar-inverse`)**: Menu đầy đủ Glyphicons:
  - Trang chủ (`glyphicon-home`)
  - Giới thiệu (`glyphicon-list-alt`)
  - Liên hệ (`glyphicon-earphone`)
  - Góp ý (`glyphicon-envelope`)
  - Hỏi đáp (`glyphicon-question-sign`)
  - Tài khoản (`glyphicon-user` - Dropdown menu)
- **Article (`col-sm-9`)**: Danh sách sản phẩm dạng lưới (mỗi hàng 3 sản phẩm, mỗi sản phẩm `col-sm-4 poly-prod` gồm Panel Heading, Panel Body ảnh sản phẩm và Panel Footer giá bán).
- **Aside (`col-sm-3`)**:
  - Giỏ hàng (`.poly-cart`): Panel chứa icon giỏ hàng và danh sách số lượng/tổng tiền.
  - Ô tìm kiếm: Panel chứa input search và nút tìm kiếm.
  - Chủng loại: Panel List-group các danh mục sản phẩm kèm số lượng badge.
- **Footer**: Panel default căn giữa bản quyền CodeGym.

## 2. File định dạng poly.css
Định dạng chi tiết theo hướng dẫn đề bài cho `.shopping-mall`, `.poly-cart`, `.poly-prod` và các phần tử liên quan.
