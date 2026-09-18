# [Bài đọc] Hướng dẫn cài đặt SASS bằng npm & SASS CLI

Kho lưu trữ hướng dẫn chi tiết và mã nguồn thực hành quy trình cài đặt, cấu hình và biên dịch SASS/SCSS sang CSS thông qua npm và SASS CLI (CodeGym).

## 1. Các bước thực hiện
1. **Kiểm tra Node.js & npm**:
   ```bash
   node -v
   npm -v
   ```
   *(Hệ thống hiện tại đã sẵn sàng với Node.js v24.15.0 & npm 11.12.1).*
2. **Cài đặt SASS toàn cục (Global)**:
   ```bash
   npm install -g sass
   # Kiểm tra phiên bản
   sass --version
   ```
3. **Biên dịch tệp SCSS sang CSS**:
   ```bash
   sass scss/styles.scss css/styles.css
   ```
4. **Kích hoạt chế độ theo dõi tự động (Watch mode)**:
   ```bash
   sass scss/:css/ --watch
   ```
5. **Khắc phục quyền thực thi script trên Windows PowerShell**:
   ```powershell
   Set-ExecutionPolicy Unrestricted -Scope CurrentUser
   ```

## 2. Cấu trúc thư mục thực hành
```text
sass-npm-guide/
├── index.html        # Giao diện web trực quan nhúng file CSS được sinh ra từ SASS
├── scss/
│   └── styles.scss   # File nguồn SASS (biến, mixins, nesting, inheritance)
├── css/
│   ├── styles.css    # File CSS đích được SASS CLI biên dịch tự động
│   └── styles.css.map # Source map hỗ trợ debug
└── README.md
```

## 3. Cách xem
Mở trực tiếp file `index.html` trong trình duyệt để kiểm chứng kết quả áp dụng CSS được biên dịch trực tiếp từ SASS.
