<#ftl encoding="utf-8"/>
<#include "base.ftl">

<#macro title>${course.getName()}</#macro>

<#macro content>
<div class="navbar navbar-default navbar-fixed-top  navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/home">Главная</a></li>
                <li class="active"><a href="/courses?page=1">Курсы</a></li>
                <li><a href="/exams?page=1">Экзамены</a></li>
                <li><a href="/profile">Личный кабинет</a></li>
                <#if current_user??>
                    <li><a href="/logout">Выход</a></li>
                </#if>
                <li><a href="/feedback">Обратная связь</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-header">
                <#if !current_user??>
                    <li><a href="/login">Войти</a></li>
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
            <!--title and description and lang and lvl labels-->
            <div class="col-md-8 col-md-offset-2">
                <!--lang and lvl-->

                <h1>${course.getName()}</h1>
                <hr/>
                <p>${course.getDescription()}</p>

                <h3>

                    <span class="label label-warning">${course.getSimpleLanguage()}</span>
                    <span class="label label-warning">Уровень ${course.getLevel()}</span>
                </h3>
            </div>
        </div>

        <!--Groups list-->
        <div class="row">
            <div class="col-md-offset-2 col-md-8">
                <hr/>
                <h3>Доступные группы</h3>

                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">
                        <div class="row" align="center">
                            <div class="col-xs-1 small">Группа</div>
                            <div class="col-xs-3 small">Преподаватель</div>
                            <div class="col-xs-3 small">Расписание</div>
                            <div class="col-xs-3 small">Первое занятие</div>
                            <div class="col-xs-1 small">
                                <div style="white-space: nowrap; margin-left: -50%;">Осталось мест</div>
                            </div>
                            <div class="col-xs-1"></div>
                        </div>
                    </div>
                    <!--WARNING!!!! comments below are very IMPORTANT!! DO NOT REMOVE THEM!!
                    THEY MUST BE LIKE
                        ...
                        </div><!-- comment
                         --/><div class= "col-xs-# valign">
                        ...
                    ITS A MAGIC, DO NOT TOUCH IT-->
                    <ul class="list-group">
                        <li class="list-group-item">
                            <div class="row" align="center">
                                <!--group num-->
                                <#list groups as g>
                                    <div class="col-xs-1 valign">
                                        <label>${g.getName()}</label>
                                    </div><!--
                                teacher
                                --><div class="col-xs-3 valign">
                                    <label>${g.getTeacherName()}</label>
                                </div><!--
                                timetable
                                --><div class="col-xs-3 valign">
                                    <div class="row">
                                        <div class="col-xs-12 small-row">
                                            <#list times as time>
                                                <#list time as t>
                                                    <span class="label label-danger mono_width_text">${t}</span>
                                                </#list>
                                            </#list>
                                        </div>
                                    </div>
                                </div><!--first lesson
                                --><div class="col-xs-3 valign">
                                    <label>${g.getFirstClass()}</label>
                                </div><!--free places
                                --><div class="col-xs-1 valign">
                                    <label>${g.getPlacesLeft()}/20</label>
                                </div><!--join us
                                --><div class="col-xs-1 valign">
                                    <button class="btn btn-block btn-success"><span class="glyphicon glyphicon-plus"
                                                                                    aria-hidden="true"></span>
                                    </button>
                                </div>
                                </#list>

                            </div>
                        </li>

                    </ul>
                </div>

            </div>
        </div>
        <!--Groups list end-->


    </div>
</div>


<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
</#macro>
