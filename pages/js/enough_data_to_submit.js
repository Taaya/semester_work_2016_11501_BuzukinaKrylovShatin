/**
 * Created by Олег on 31.10.2016.
 */
function checkform() {
    if ($("#input_login").val() === '' || $("#input_password").val() === '') {
        //remove old notification about empty login
        if ($("#input_login").val() !== '' && $('#input_login').parent().children().is("#login_empty_alert")){
            $("#login_empty_alert").remove();
            console.log("login should be removed");
        }
        //add notification about empty login
        if ($("#input_login").val() === '' && !$('#input_login').parent().children().is("#login_empty_alert")){
            $('#input_login').parent().append('\<div class=\"alert alert-danger\" id="login_empty_alert" align="center">\
            <strong>Введите логин</strong>\
        </div>');
        }
        if ($("#input_password").val() !== '' && $('#input_password').parent().children().is("#password_empty_alert")){
            $("#password_empty_alert").remove();
            console.log("pass should be removed");
        }
        if ($("#input_password").val() === '' && !$('#input_password').parent().children().is("#password_empty_alert")){
            $('#input_password').parent().append('\<div class=\"alert alert-danger\" id="password_empty_alert" align="center">\
            <strong>Введите пароль</strong>\
        </div>');
        }
        return false;
    } else {
        return true;
    }
};