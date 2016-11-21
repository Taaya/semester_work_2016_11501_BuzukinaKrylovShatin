<#ftl encoding="utf-8"/>
<#include "base.ftl">
<#macro page_body>
<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top  navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/home">Главная</a></li>
                <li><a href="/courses?page=1">Курсы</a></li>
                <li><a href="/exams?page=1">Экзамены</a></li>
                <li class="active"><a href="/profile">Личный кабинет</a></li>
                <li><a href="/logout">Выход</a></li>
                <li><a href="/feedback">Обратная связь</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-header">
                <li>
                    <div class="navbar-brand" href="#">Russo turisto</div>
                    <img style="max-height:45px; margin-top: 5px;"
                         src="images/logo.png" class="img-responsive"/>
                </li>
            </ul>
        </div><!--/.nav-collapse -->


    </div>
</div>
<!--No offset content: back to exams list button-->
<div class="row no_top_offset_first_block">
    <div class="col-md-12">
        <button class="btn btn-warning btn-block" data-toggle="modal" data-target="#change_info_about_user_modal">Редактировать информацию о себе <span class="glyphicon glyphicon-pencil">
        </button>
    </div>
</div>
<!--Modal for change info about user-->
<div class="modal fade" id="change_info_about_user_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <form method="post" class="form-horizontal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Редактирование информации о себе</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-2 col-xs-offset-2">
                                <label for="input_login" class="control-label">Логин</label>
                            </div>
                            <div class="col-xs-6">
                                <input type="text" class="form-control" id="input_login" placeholder="vasya_superkrut">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-2 col-xs-offset-2">
                                <label for="input_login" class="control-label">Email</label>
                            </div>
                            <div class="col-xs-6">
                                <input type="text" class="form-control" id="input_email" placeholder="vasya@mail.ru">
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Сохранить изменения</button>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="firstBlock">

    <!--Content-->
    <div class="content">
        <div class="row">
            <!--about user-->
            <div class="col-md-8 col-md-offset-2">
                <h1>${user.getUsername()}</h1>
                <!--login & email-->
                <h3>
                    <span class="label label-warning">${user.getEmail()}</span>
                </h3>
            </div>
        </div>


        <div class="row">
            <!--Courses list-->
            <div class="col-md-offset-2 col-md-4">
                <h3>Мои курсы</h3>
                <hr/>

                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-7 small">Курс</div>
                            <div class="col-xs-5 small">Следующее занятие</div>
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

                        <!--MyCourse and Modal item-->
                        <#if courses??>
                        <#list courses as course>
                        <li class="list-group-item">
                            <div class="row">
                                <!--about course
                                --><div class="col-xs-7 valign">
                                <!-- panel trigger modal: data target = "#course_modal_id" -->
                                <div class="panel panel-default no_margin" data-toggle="modal" data-target="#course_modal_1">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <h4 class="title">${course.getName()}</h4>
                                                <h4 class="no_margin">
                                                    <span class="label label-warning">${course.getSimpleLanguage()}</span>
                                                    <span class="label label-warning">Уровень ${course.getLevel()}</span>
                                                </h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                                <div class="col-xs-4 valign">
                                    <#if course.getNextClass(course)??>
                                        <label>${course.getNextClass(course)}</label>
                                    </#if>


                                </div>

                            <div class="modal fade" id="course_modal_1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title">О курсе</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <h4 class="title">${course.getName()}</h4>
                                                    <h4 class="no_margin">
                                                        <span class="label label-warning">${course.getSimpleLanguage()}</span>
                                                        <span class="label label-warning">Уровень ${course.getLevel()}</span>
                                                    </h4>
                                                </div>
                                            </div>
                                            <hr/>
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <button class="btn btn-block btn-primary">Чат группы</button>
                                                </div>
                                            </div>
                                            <hr/>
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <h6>Расписание</h6>
                                                    <span class="label label-danger mono_width_text">ПН 19:00-20:00</span>
                                                    <span class="label label-danger mono_width_text">ВТ 19:00-20:00</span>
                                                    <span class="label label-danger mono_width_text">СР 19:00-20:00</span>

                                                </div>
                                                <div class="col-xs-9">
                                                    <div class="row">
                                                        <div class="col-xs-6">
                                                            <h6>Преподаватель:</h6>
                                                            <label>Альбус Дамблдор</label>
                                                        </div>
                                                        <div class="col-xs-6">
                                                            <h6>Следующее занятие:</h6>
                                                            <label>2016-11-30 в 17:30</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <!--remove not used buttons-->

                                            <button type="button" class="btn btn-danger">Отказаться от прохождения курса</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        </#list>
                        </#if>

                        <!--MyCourse and Modal item-->

                        <!--end of items-->

                    </ul>
                </div>

            </div>

            <!--My Exams-->
            <div class="col-md-4">
                <h3>Мои экзамены</h3>
                <hr/>
                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-7 small">Экзамен</div>
                            <div class="col-xs-5 small">Дата экзамена</div>
                        </div>
                    </div>
                    <!--course panels-->
                    <ul class="list-group">
                    <#if exams??>
                        <!--My exam item-->
                        <#list exams as exam>
                        <li class="list-group-item">
                            <div class="row">
                                <!--about course
                                --><div class="col-xs-7 valign">
                                <!-- panel trigger modal: data target = "#course_modal_id" -->
                                <div class="panel panel-default no_margin">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <h4 class="title">${exam.getName()}</h4>
                                                <h4 class="no_margin">
                                                    <span class="label label-warning">${exam.getSimpleLanguage()}</span>
                                                </h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div><!--next lessonn
                                    --><div class="col-xs-5 valign">
                                <label>2016-12-28 в 12.00</label>
                            </div>
                            </div>
                        </li>
                        </#list>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
        <!--Groups list end-->

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
</#macro>

<#macro page_head>
    <meta charset="UTF-8">
    <title>Личный кабинет</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>
</#macro>
    <!--/.nav-collapse -->


<@display_page/>