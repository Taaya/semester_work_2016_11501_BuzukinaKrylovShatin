<#ftl encoding="utf-8"/>
<#include "base.ftl">

<#macro page_body>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#about">Главная</a></li>
                <li><a href="/courses?page=1">Курсы</a></li>
                <li><a href="/exams?page=1">Экзамены</a></li>
                <li><a href="/login">Личный кабинет</a></li>
                <li><a href="#contact">Обратная связь</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-header">

                <li>
                    <div class="navbar-brand" href="#">Russo turisto</div>
                    <img style="max-width:50px; margin-top: 5px;"
                         src="logo.png" class="img-responsive"/>
                </li>
            </ul>
        </div><!--/.nav-collapse -->


    </div>
</div>
<form method=POST action=/registration id="form">
    <input type=text id="username" oninput="checkLogin()" name=username>
    <input type=password name=password>
    <input type="email" name=email>
    <input type="phone" name=phone>
    <input type=submit value=Зарегистрироваться id="submit">
    <p id="errorLogin"></p>
</form>
<script>
    function checkLogin(){
        var username = $("#username");
        var error = $("#errLogin");
        error.removeClass("error");
        var message = "";
        $.ajax({
            'url':'/searchLogin',
            'data':
            {
                'username': username.val()
            },
            'method':'get',
            'success':function(obj){
                if(obj.result) {
                    error.html(obj.result);
                    error.addClass("error");
                }
            }
        });
        error.html(message);
    }
    $("#submit").click(function() {
        var  size = 0;
        $(".error").each(function(){
            size += 1;
        });
        if ($("#login").val() != '') {
            $("#form").submit();
        }else{
            $(".errorMessage").html("Некорректные данные!");
            return false;
        }
    });
</script>
</#macro>
<@display_page/>