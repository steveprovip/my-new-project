<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>iNotes - Thêm Ghi chú</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4" style="max-width: 640px">
    <h1 class="mb-3">➕ Thêm Ghi chú</h1>

    <%-- Bước 4: Form thêm Ghi chú theo mẫu --%>
    <form method="post" action="notes" class="bg-white p-4 rounded shadow-sm">
        <input type="hidden" name="store" value="${store}">
        <div class="mb-3">
            <label class="form-label">Title</label>
            <input type="text" class="form-control" name="title" required placeholder="Tiêu đề ghi chú">
        </div>
        <div class="mb-3">
            <label class="form-label">Type</label>
            <select class="form-select" name="typeId">
                <option value="1">Work</option>
                <option value="2">Personal</option>
                <option value="3">Ideas</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Content</label>
            <textarea class="form-control" name="content" rows="5" placeholder="Nội dung ghi chú"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <a class="btn btn-secondary" href="notes?store=${store}">Back</a>
    </form>
</div>
</body>
</html>
