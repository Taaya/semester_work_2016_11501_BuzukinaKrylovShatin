/**
 * Created by Олег on 31.10.2016.
 */
function checkform() {
    var name = $("#input_name");
    var email = $("#input_email");
    if (name.val() === '' || email.val() === '') {
        //remove old notification about empty name
        if (name.val() !== '' && name.parent().children().is("#name_empty_warning")){
            name.parent().removeClass("has-error");
            
        }
        //add notification about empty name
        if (name.val() === '' && !name.parent().children().is("#name_empty_warning")){
            name.parent().addClass("has-error");
        }
        //remove old notification about empty email
        if (email.val() !== '' && email.parent().children().is("#email_empty_warning")){
            email.parent().removeClass("has-error");

        }
        //add notification about empty email
        if (email.val() === '' && !email.parent().children().is("#email_empty_warning")){
            email.parent().addClass("has-error");

        }
        return false;
    } else {
        return true;
    }
};