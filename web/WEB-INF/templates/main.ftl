<#ftl encoding="utf-8"/>
<#include "base.ftl">
<#macro title>Russo Turisto</#macro>

<#macro content>
<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home">Главная</a></li>
                <li><a href="/courses?page=1">Курсы</a></li>
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


<div class="firstBlock" style="margin-top: 50px">

    <!--Content-->

    <div class="content">
        <header class="jumbotron" id="overview" style="background-image: url(images/main_header_background.jpg)">
            <div class="row">
                <div class="col-xs-8 col-xs-offset-1">
                    <h1>Russo Turisto</h1>

                    <p class="lead">Языковая школа для всех и каждого!</p>
                </div>
                <div class="col-xs-3">
                    <img style="max-height: 150px;"
                         src="images/logo_recht.jpg" class="img-responsive img-circle no_margin"/>
                </div>
            </div>
        </header>
        <div class="row">
            <div class="col-xs-8 col-xs-offset-2">
                <h2>Что мы предлагаем</h2>
                <hr/>
                <div class="row">
                    <div class="col-xs-6">
                        <h4><span class="glyphicon glyphicon-volume-up" aria-hidden="true"></span> Акцент на развитие
                            разговорных навыков</h4>

                        <p>Бóльшая часть учебного времени уделяется обсуждению статей, обмену мнениями и воспроизведению
                            диалогов из реальных ситуаций.</p>
                    </div>
                    <div class="col-xs-6">
                        <h4><span class="glyphicon glyphicon-education" aria-hidden="true"></span> Сильные преподаватели
                        </h4>

                        <p>Все наши преподаватели имеют высшее лингвистическое или педагогическое образование, и они
                            постоянно повышают свою квалификацию.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <h4><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span> Удобное расписание
                        </h4>

                        <p>Даже при самом ненормированном индивидуальном графике вы сможете выбрать любое время для
                            изучения языка с 7:00 до 21:30.
                        </p>
                    </div>
                    <div class="col-xs-6">
                        <h4><span class="glyphicon glyphicon-certificate" aria-hidden="true"></span> Удостоверение об
                            окончании курсов</h4>

                        <p>Ваши навыки владения английским языком подтверждаются удостоверением, которое станет частью
                            вашего портфолио.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <h4><span class="glyphicon glyphicon-comment" aria-hidden="true"></span> Коммуникативная
                            методика</h4>

                        <p>На занятиях практически не используется родной язык, благодаря чему происходит полное
                            «погружение» в изучаемый язык.</p>
                    </div>
                    <div class="col-xs-6">
                        <h4><span class="glyphicon glyphicon-book" aria-hidden="true"></span> Учебные материалы
                            международного стандарта</h4>

                        <p>В основе учебников, наглядных пособий, аудио- и видеоматериалов лежит опыт лучших методистов
                            со всего мира.</p>
                    </div>
                </div>
            </div>
        </div>
        <!--slyder row-->
        <div class="row">
            <div class="col-xs-offset-2 col-xs-8">
                <hr/>
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="images/slyder_main_1.jpg" alt="...">

                            <div class="carousel-caption">
                                <h3>Учиться</h3>

                                <p>никогда не поздно!</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="images/slyder_main_3.jpg" alt="...">

                            <div class="carousel-caption">
                                <h3>Путешествовать</h3>

                                <p>станет гораздо легче!</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="images/slyder_main_2.jpg" alt="...">

                            <div class="carousel-caption">
                                <h3>Общаться</h3>

                                <p>теперь будет проще!</p>
                            </div>
                        </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
        <!--form row-->
        <div class="row">
            <div class="col-xs-offset-2 col-xs-8">
                <h2 class="page-header">Спецпредложение для вас!</h2>
                <p>Оставьте заявку прямо сейчас и получите 2 месяца обучения в подарок!</p>

                <form method="post" class="form-horizontal" onsubmit="return checkform();">
                    <div class="row">
                        <div class="col-xs-4">
                            <div class="form-group">
                                <label class="control-label" for="input_name">Имя</label>
                                <input type="text" id="input_name" class="form-control" name="name">
                            </div>
                        </div>
                        <div class="col-xs-3 col-xs-offset-1">
                            <div class="form-group">
                                <label class="control-label" for="input_email">Email</label>
                                <input type="email" id="input_email" class="form-control" name="email">
                            </div>
                        </div>
                        <div class="col-xs-3 col-xs-offset-1">
                            <div class="form-group">
                                <label class="control-label" for="input_phone">Телефон</label>
                                <input type="text" id="input_phone" class="form-control" name="phone">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group">
                                <button type="submit" class="btn btn-warning btn-block" id="send_button">Получить
                                    спецпредложение!
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>



</div>

<!--Scripts-->
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/enough_data_to_submit_from_main.js"></script>
</#macro>
