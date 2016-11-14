<#ftl encoding="utf-8"/>
<#include "base.ftl">
<#macro page_body>
    <div class="navbar navbar-default navbar-fixed-top  navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#about">Главная</a></li>
                <li class="active"><a href="/courses?page=1>">Курсы</a></li>
                <li><a href="/exams?page=1">Экзамены</a></li>
                <li><a href="/profile">Личный кабинет</a></li>
                <#if current_user??>
                    <li><a href="/logout">Выход</a></li>
                </#if>
                <li><a href="#contact">Обратная связь</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-header">
                <#if !current_user??>
                    <li><a href="/login">Войти</a></li>
                </#if>
                <li>
                    <div class="navbar-brand" href="#">Russo turisto</div>
                    <img style="max-height:45px; margin-top: 5px;"
                         src="../../img/logo.png" class="img-responsive"/>
                </li>
            </ul>
        </div>
    </div>
    </div>
    <!--/.nav-collapse -->
    <br>


</#macro>

<@display_page/>