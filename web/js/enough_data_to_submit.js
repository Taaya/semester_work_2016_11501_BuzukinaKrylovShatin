
function checkform() {
    if ($("#login").val() === '' || $("#password").val() === '') {
        //remove old notification about empty login
        if ($("#login").val() !== '' && $('#login').parent().children().is("#login_empty_warning")){
            $("#login_empty_warning").remove();
            $('#input_login').parent().removeClass("has-error");

        }
        //add notification about empty login
        if ($("#login").val() === '' && !$('#login').parent().children().is("#login_empty_warning")){
            $('#login').parent().append('\<label class="control-label" id ="login_empty_warning" for="input_login">Введите логин</label>');
            $('#login').parent().addClass("has-error");
        }
        //remove old notification about empty pass
        if ($("#password").val() !== '' && $('#password').parent().children().is("#password_empty_warning")){
            $("#password_empty_warning").remove();
            $('#input_password').parent().removeClass("has-error");

        }
        //add notification about empty pass
        if ($("#password").val() === '' && !$('#password').parent().children().is("#password_empty_warning")){
            $('#password').parent().append('\<label class="control-label" id="password_empty_warning" for="input_password">Введите пароль</label>');
            $('#ipassword').parent().addClass("has-error");

        }
        return false;
    } else {
        return true;
    }
};