$(document).ready(function () {
    $('#datatable').dataTable();

    $("[data-toggle=tooltip]").tooltip();

});

function edit(user) {
    document.getElementById("inputName").value = user.name;
    document.getElementById("inputEmail").value = user.email;
    document.getElementById("inputPassword").value = user.password;
    document.getElementById("inputDescription").value = user.description;
    document.getElementById("inputPermission").value = user.permission.toString();
    document.getElementById("myform").action = "editUser?userId=" + user.userId;
}

function deleteU(id) {
    document.getElementById("deletef").href = "deleteUser?userId=" + id;
    document.getElementById("Heading").innerHTML = "Delete user id: " + id;
}