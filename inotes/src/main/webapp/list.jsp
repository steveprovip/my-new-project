<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="codegym.inotes.model.Note" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>iNotes - Danh sách Ghi chú</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <h1 class="mb-3">📒 iNotes</h1>

    <%-- Chuyển đổi Strategy lưu trữ: DB hoặc FILE (Bước 8) --%>
    <div class="btn-group mb-3" role="group">
        <a href="notes?store=db"
           class="btn btn-sm ${"db".equals(store) ? "btn-primary" : "btn-outline-primary"}">Lưu trong CSDL</a>
        <a href="notes?store=file"
           class="btn btn-sm ${"file".equals(store) ? "btn-primary" : "btn-outline-primary"}">Lưu trong tệp tin</a>
    </div>

    <%-- Form tìm kiếm Ghi chú --%>
    <form class="row g-2 mb-3" method="get" action="notes">
        <input type="hidden" name="store" value="${store}">
        <div class="col-auto">
            <input type="text" class="form-control" name="keyword" placeholder="Tìm kiếm ghi chú..."
                   value="${keyword}">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-success">Search</button>
            <a class="btn btn-primary" href="notes?action=add&store=${store}">Add note</a>
        </div>
    </form>

    <table class="table table-striped table-hover bg-white shadow-sm">
        <thead class="table-dark">
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Type</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Note> notes = (List<Note>) request.getAttribute("notes");
            if (notes == null || notes.isEmpty()) {
        %>
        <tr>
            <td colspan="4" class="text-center text-muted">Không có ghi chú nào</td>
        </tr>
        <%
            } else {
                for (Note note : notes) {
        %>
        <tr>
            <td><%= note.getId() %></td>
            <td><a href="notes?action=view&id=<%= note.getId() %>&store=${store}"><%= note.getTitle() %></a></td>
            <td><span class="badge bg-secondary"><%= note.getType() %></span></td>
            <td>
                <a class="btn btn-sm btn-warning"
                   href="notes?action=view&id=<%= note.getId() %>&store=${store}">Edit</a>
                <a class="btn btn-sm btn-danger"
                   href="notes?action=delete&id=<%= note.getId() %>&store=${store}"
                   onclick="return confirm('Xóa ghi chú này?')">Delete</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
