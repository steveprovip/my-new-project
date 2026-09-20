-- =============================================
-- iNotes - Bước 1: Thiết kế CSDL
-- 2 bảng: notetypes (phân loại) và notes (ghi chú)
-- =============================================
CREATE DATABASE IF NOT EXISTS iNotes CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE iNotes;

CREATE TABLE IF NOT EXISTS notetypes (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS notes (
    id      INT PRIMARY KEY AUTO_INCREMENT,
    title   VARCHAR(255) NOT NULL,
    content TEXT,
    type_id INT,
    FOREIGN KEY (type_id) REFERENCES notetypes (id)
);

-- Dữ liệu mẫu cho phân loại (khớp với NoteFile.TYPE_NAMES)
INSERT INTO notetypes (id, name) VALUES (1, 'Work'), (2, 'Personal'), (3, 'Ideas');

-- Dữ liệu mẫu cho ghi chú
INSERT INTO notes (title, content, type_id) VALUES
('Họp sprint', 'Họp sprint lúc 9h thứ 2, phòng họp A', 1),
('Mua sắm cuối tuần', 'Mua rau, trái cây và sữa', 2),
('Ý tưởng app', 'Làm app ghi chú với Strategy pattern', 3);
