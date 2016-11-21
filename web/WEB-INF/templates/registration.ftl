<#ftl encoding="utf-8"/>
<#include "base.ftl">

<#macro page_head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>
</#macro>
<#macro page_body>
<#--<div class="navbar navbar-default navbar-fixed-top" role="navigation">-->
    <#--<div class="container">-->
        <#--<div class="navbar-collapse collapse">-->
            <#--<ul class="nav navbar-nav">-->
                <#--<li class="active"><a href="#about">Главная</a></li>-->
                <#--<li><a href="/courses?page=1">Курсы</a></li>-->
                <#--<li><a href="/exams?page=1">Экзамены</a></li>-->
                <#--<li><a href="/login">Личный кабинет</a></li>-->
                <#--<li><a href="/feedback">Обратная связь</a></li>-->
            <#--</ul>-->
            <#--<ul class="nav navbar-nav navbar-right navbar-header">-->

                <#--<li>-->
                    <#--<div class="navbar-brand" href="#">Russo turisto</div>-->
                    <#--<img style="max-width:50px; margin-top: 5px;"-->
                         <#--src="logo.png" class="img-responsive"/>-->
                <#--</li>-->
            <#--</ul>-->
        <#--</div><!--/.nav-collapse &ndash;&gt;-->


    <#--</div>-->
<#--</div>-->

<#--<form method=POST action=/registration id="form">-->
    <#--<input type=text id="username" oninput="checkLogin()" name=username>-->
    <#--<input type=password name=password>-->
    <#--<input type="email" name=email>-->
    <#--<p id="errorLogin" class="errorMessage"></p>-->
    <#--<input type="phone" name=phone>-->
    <#--<input type=submit value=Зарегистрироваться id="submit">-->
<#--</form>-->
<div class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home">Главная</a></li>
                <li><a href="/courses?page=1">Курсы</a></li>
                <li><a href="/exams?page=1">Экзамены</a></li>
                <li><a href="/profile">Личный кабинет</a></li>
                <li><a href="/feedback">Обратная связь</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-header">
                <li><a href="/login">Войти</a></li>
                <li>
                    <div class="navbar-brand" href="#">Russo turisto</div>
                    <img style="max-height:45px; margin-top: 5px;"
                         src="images/logo.png" class="img-responsive">

                </li>
            </ul>
        </div><!--/.nav-collapse -->


    </div>
</div>

<div class="firstBlock">

    <!--Content-->
    <div class="content container">

        <div class="row">
            <h1 class="col-md-offset-4 col-md-4 header_with_bottom_margin" align="center">Регистрация</h1>
        </div>

        <form method="post" action="/registration" class="form-horizontal" id="form" onsubmit="return checkform();">
            <div class="form-group">
                <p id="errorLogin" class="errorMessage col-md-offset-5 wrong-login"></p>
                <label for="input_login" class="col-md-offset-3 col-md-2 control-label">Логин</label>

                <div class="col-md-2">
                    <input type="text" class="form-control" id="username" oninput="checkLogin()" name="username">
                </div>

            </div>

            <div class="form-group">
                <label for="input_password" class="col-md-offset-3 col-md-2 control-label">Пароль</label>

                <div class="col-md-2">
                    <input type="password" class="form-control" id="input_password" name="password">
                </div>
            </div>
            <div class="form-group">
                <label for="input_password" class="col-md-offset-3 col-md-2 control-label">Повторите пароль</label>

                <div class="col-md-2">
                    <input type="password" class="form-control" id="input_repeated_password">
                </div>

            </div>
            <div class="form-group">
                <label for="input_phone" class="col-md-offset-3 col-md-2 control-label">Телефон</label>
                <div class="col-md-2">
                    <input type="phone" class="form-control" id="input_phone" name="phone">
                </div>
            </div>

            <div class="form-group">
                <label for="email_input" class="col-md-offset-4 col-md-1 control-label">Email</label>

                <div class="col-md-2">
                    <input type="email" class="form-control" id="email_input" name="email">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-5 col-md-2">

                    <button type="submit" class="btn btn-success btn-block" id="submit">Зарегестрироваться
                    </button>
                </div>
            </div>
        </form>
        <form class="form-horizontal" action="/login">
            <div class="form-group">
                <div class="col-md-offset-5 col-md-2">
                    <button class="btn btn-info btn-block" id="login_button" type="submit">Уже есть аккаунт?</button>
                </div>
            </div>
        </form>
    </div>

    <!--Footer-->

    <div class="footer">
        <hr id="footer-border-hr"/>
        <div class="row">
        </div>
        <div class="col-md-3 col-md-offset-2">
            <h4>Языковая школа "RussoTuristo"</h4>

            <p>Посетите <a href="https://github.com/Taaya/semester_work_2016_11501_BuzukinaKrylovShatin">репозиторий
                проекта на GitHub</a></p>
        </div>
        <div class="col-md-3 col-md-offset-2">
            <h4>Команда проекта</h4>
            <ul id="team-list">
                <li>Бузукина Тая</li>
                <li>Крылов Антон</li>
                <li>Шатин Олег</li>
            </ul>
        </div>
    </div>
</div>


<!--Scripts-->

<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/passwords_matcher.js"></script>
<script type="application/javascript" src="/js/jquery-3.1.1.min.js"></script>
<script>
    function checkLogin(){
        var username = $("#username");
        var error = $("#errorLogin");
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
        if ($("#username").val() != '' && size == 0) {
            $("#form").submit();
        }else{
            $(".errorMessage").html("Данное имя пользователя занято");
            return false;
        }
    });
</script>
</#macro>
<@display_page/>


<body>
<!-- Fixed navbar -->

</body>
</html>