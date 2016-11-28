<#ftl encoding="utf-8"/>
<#include "base.ftl">

<#macro title>Обратная связь</#macro>
<#macro content>
<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/home">Главная</a></li>
                <li><a href="/courses?page=1">Курсы</a></li>
                <li><a href="/exams?page=1">Экзамены</a></li>
                <li><a href="/profile">Личный кабинет</a></li>
                <#if current_user??>
                    <li><a href="/logout">Выход</a></li>
                </#if>

                <li class="active"><a href="/feedback">Обратная связь</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-header">
                <#if !current_user??>
                <li><a href="#">Войти</a></li>
                </#if>
                <li>
                    <div class="navbar-brand" href="#">Russo turisto</div>
                    <img style="max-height:45px; margin-top: 5px;"
                         src="images/logo_recht.jpg" class="img-responsive"/>
                </li>
            </ul>
        </div><!--/.nav-collapse -->


    </div>
</div>

<div class="firstBlock">

    <!--Content-->
    <div class="content">
        <div class="row">
            <div class="col-xs-offset-4 col-xs-4">
                <h1 class="page-header">Обратная связь</h1>
            </div>
        </div>
        <form method="post" class="form-horizontal" onsubmit="return checkform();">

            <div class="form-group">

                <div class="row">
                    <div class="col-xs-4 col-lg-offset-4">
                        <#if message??>
                            <p>${message}</p>
                        </#if>
                        <label class="control-label" for="input_name">Имя</label>
                        <input type="text" id="input_name" class="form-control" placeholder="Имя" name="name">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-xs-2 col-xs-offset-4">
                        <label class="control-label" for="input_email">Email</label>
                        <input type="email" id="input_email" class="form-control" placeholder="Email" name="email">
                    </div>
                    <div class="col-xs-2">
                        <label class="control-label" for="input_phone">Телефон</label>
                        <input type="text" id="input_phone" class="form-control" name="phone">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-xs-4 col-xs-offset-4">
                        <label class="control-label" for="input_text">Ваш вопрос</label>
                        <textarea class="form-control" rows="3" id="input_text" placeholder="Введите Ваш вопрос" name="feedback_text"></textarea>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-xs-2 col-xs-offset-6">
                        <button type="submit" class="btn btn-success btn-block" id="send_button">Отправить</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <!--Footer-->


</div>

<!--Scripts-->
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/enough_data_to_submit_feedback.js"></script>

</#macro>