<#include "base.ftl">

<#macro page_head>
    <meta charset="UTF-8">
    <title>Наши курсы</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>
    <link href="css/selectButtons.css" rel="stylesheet" type="text/css"/>
    <script type="application/javascript" src="/js/jquery-3.1.1.min.js"></script>
</#macro>

<#macro page_body>
<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top  navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/home">Главная</a></li>
                <li class="active"><a href="/courses?page=1>">Курсы</a></li>
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
                         src="images/logo.png" class="img-responsive"/>
                </li>
            </ul>
        </div><!--/.nav-collapse -->


    </div>
</div>

<div class="firstBlock">

    <!--Content-->
    <div class="content">
        <div class="h1 col-md-2 col-md-offset-1 navbar-left nav">
            <div class="row">
                <div id="imaginary_container" class="col-md-12 margin_minimal">
                    <div class="input-group stylish-input-group">
                        <input type="text" class="form-control" placeholder="Search" id="q" oninput="f()">
                    <span class="input-group-addon">
                        <button type="submit"><span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                    </div>
                </div>
                <form method="get" action="/courses">

                <div class="col-md-12 margin_minimal">
                    <a class="btn btn-primary btn-select" id="level_selector" href="">
                        <input type="hidden" class="btn-select-input" id="" name="level_selector" value=""/>

                        <span class="btn-select-value">Уровень</span>
                        <span class='btn-select-arrow glyphicon glyphicon-chevron-down'></span>
                        <ul>
                            <li value="1">1</li>
                            <li value="2">2</li>
                            <li value="3">3</li>
                            <li value="4">4</li>
                            <li value="5">5</li>
                        </ul>
                    </a>
                    <input type="hidden" name="page" value="${page}">
                    <button type="submit" class="btn btn-primary btn-block" id="apply_filters">Применить</button>
                </div>
                </form>


            </div>
        </div>

        <div class="col-md-8">
            <div class="row">
                <div class="bootstrap snippet">
                    <div class="row">
                        <div class="col-md-12">
                            <h1>Курсы</h1>
                        </div>
                    </div>
                    <div id="names" class="row title col-md-offset-1">

                    </div>
                    <div>

                        <div  class="row">
                            <#list courses as course>
                                <div class="col-md-6">
                                    <div class="panel panel-default">
                                        <div class="row panel-body">
                                            <div class="col-xs-12">
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <h3 class="title"><a><a href="/course?id=${course.getId()}">${course.getName()}</a></h3>
                                                        <p>${course.getDescription()}</p>
                                                        <h4 class="no_margin">
                                                            <span class="label label-warning">${course.getSimpleLanguage()}</a></span>
                                                            <span class="label label-warning">Уровень ${course.getLevel()}</span>
                                                        </h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </#list>
                        </div>
                    </div>
                    </div>


            <div class="row">
                <div class="col-md-12 container" align="center">
                    <ul class="pagination">
                        <#if page=1>
                            <li class="active"><a href="/courses?page=1">1 <span class="sr-only">(current)</span></a></li>
                            <li><a href="/courses?page=2">2</a></li>
                            <li><a href="/courses?page=3">3</a></li>
                            <li><a href="/courses?page=2">»</a></li>
                        </#if>
                        <#if page=2>
                            <li class="disabled"><a href="/courses?page=1">«</a></li>
                            <li><a href="/courses?page=1">1</a></li>
                            <li class="active"><a href="/courses?page=2">2 <span class="sr-only">(current)</span></a></li>
                            <li><a href="/courses?page=3">3</a></li>
                            <li><a href="courses?page=3">»</a></li>
                        </#if>
                        <#if page=3>
                            <li class="disabled"><a href="/courses?page=2">«</a></li>
                            <li><a href="/courses?page=1">1</a></li>
                            <li><a href="/courses?page=2">2</a></li>
                            <li class="active"><a href="/courses?page=3">3<span class="sr-only">(current)</a></li>

                        </#if>


                    </ul>
                </div>
            </div>

        </div>

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
    <script src="js/selectButtons.js"></script>
<script type="application/javascript">
    var f = function(){
        $.ajax({
            'url' : '/searchCoursesServlet',
            'data' : {
                'q' : $("#q").val()
            },
            'method' : 'get',
            'success' : function(obj){
                $("#names").html(obj.result.join(", "));
            }
        });
    }
</script>

</#macro>


<@display_page/>




