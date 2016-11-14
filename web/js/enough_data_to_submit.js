
function checkform() {
    if ($("#input_login").val() === '' || $("#input_password").val() === '') {
        //remove old notification about empty login
        if ($("#input_login").val() !== '' && $('#input_login').parent().children().is("#login_empty_warning")){
            $("#login_empty_warning").remove();
            $('#input_login').parent().removeClass("has-error");

        }
        //add notification about empty login
        if ($("#input_login").val() === '' && !$('#input_login').parent().children().is("#login_empty_warning")){
            $('#input_login').parent().append('\<label class="control-label" id ="login_empty_warning" for="input_login">Введите логин</label>');
            $('#input_login').parent().addClass("has-error");
        }
        //remove old notification about empty pass
        if ($("#input_password").val() !== '' && $('#input_password').parent().children().is("#password_empty_warning")){
            $("#password_empty_warning").remove();
            $('#input_password').parent().removeClass("has-error");

        }
        //add notification about empty pass
        if ($("#input_password").val() === '' && !$('#input_password').parent().children().is("#password_empty_warning")){
            $('#input_password').parent().append('\<label class="control-label" id="password_empty_warning" for="input_password">Введите пароль</label>');
            $('#input_password').parent().addClass("has-error");

        }
        return false;
    } else {
        return true;
    }
};