<#ftl encoding="utf-8"/>
<#include "base.ftl">

<#macro page_head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>
</#macro>

<#macro page_body>
<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#about">Главная</a></li>
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

<div class="firstBlock">


    <!--Content-->
    <div class="content container ">
        <h1 class="col-md-offset-5 col-md-4">Вход</h1>

        <form method="post" action="/login" class="form-horizontal">
            <div class="form-group">
                <label for="inputLogin" class="col-md-offset-3 col-md-2 control-label">Логин</label>

                <div class="col-md-2">
                    <#if username??>
                        <input type=text name=username class="form-control" id="inputLogin" placeholder="Login" value=${username}>
                    <#else>
                            <input type=text name=username class="form-control" id="inputLogin" placeholder="Login" value="">
                    </#if>
                </div>

            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-md-offset-3 col-md-2 control-label">Пароль</label>

                <div class="col-md-2">
                    <#if password??>
                        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password" value="${password}">
                    <#else>
                        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password" value="">
                    </#if>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="rememberMe"> Запомнить меня
                        </label>
                    </div>
                </div>

                <#if err??>
                    <p>${err}</p>
                </#if>
            </div>
            <div class="form-group">
                <div class="col-md-offset-5 col-md-2">
                    <button type="submit" class="btn btn-success btn-block">Войти</button>
                </div>
            </div>
        </form>
        <form action="/registration">
            <div class="form-horizontal">
                <label for="signup_button" class="col-md-offset-3 col-md-2 control-label" id="signup_label">Впервые у
                    нас?</label>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-info btn-block" id="signup_button">Регистрация</button>
                </div>
            </div>
        </form>


    </div>

    <!--Footer-->

    <div class="footer navbar-fixed-bottom">
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

</#macro>

<@display_page/>



