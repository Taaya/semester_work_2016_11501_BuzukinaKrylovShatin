/**
 * Created by Олег on 02.11.2016.
 */
$('#input_repeated_password').keyup(function() {

    var pass = $("#input_password").val();
    var pass_rep = $("#input_repeated_password").val();
    if (pass != pass_rep) {
        if ( !$("#input_repeated_password").parent().hasClass("has-error")) {
            $("#input_repeated_password").parent().append('\<label class="control-label" id ="passwords_not_matching_warning" for="input_login">Пароли не совпадают</label>');
            $("#input_repeated_password").parent().addClass("has-error");
        }
    } else {
        $("#passwords_not_matching_warning").remove();
        $("#input_repeated_password").parent().removeClass("has-error");
    }
});
