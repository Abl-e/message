$(function () {
})
function query() {
    var command = $("input[name='command']").val();
    var description = $("input[name='description']").val();
    $.get("/list", { command:command, description:description });
}