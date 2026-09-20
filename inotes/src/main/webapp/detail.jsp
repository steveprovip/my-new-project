<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="codegym.inotes.model.Note" %>
<%
    Note note = (Note) request.getAttribute("note");
%>
<html>
<head>
    <title>iNotes - Chi tiết Ghi chú</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4" style="max-width: 720px">
    <% if (note == null) { %>
    <div class="alert alert-danger">Không tìm thấy ghi chú!</div>
    <% } else { %>
    <%-- Bước 6: trang chi tiết một Ghi chú theo mẫu --%>
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h4 class="mb-0"><%= note.getTitle() %></h4>
            <span class="badge bg-light text-primary"><%= note.getType() %></span>
        </div>
        <div class="card-body">
            <p class="card-text" style="white-space: pre-line;"><%= note.getContent() %></p>
        </div>
        <div class="card-footer">
            <a class="btn btn-secondary" href="notes?store=${store}">← Back to list</a>
            <a class="btn btn-warning" href="notes?action=add&store=${store}">Add new</a>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>
