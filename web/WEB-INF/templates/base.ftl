
    <#macro page_body>
        <!-- Fixed navbar -->
        <div class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#about">Главная</a></li>
                        <li><a href="/courses?page=1">Курсы</a></li>
                        <li><a href="#">Экзамены</a></li>
                        <li><a href="#about">Личный кабинет</a></li>
                        <li><a href="#contact">Выход</a></li>
                        <li><a href="#contact">Обратная связь</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right navbar-header">
                        <li><a href="#">Войти</a></li>
                        <li>
                            <div class="navbar-brand" href="#">Russo turisto</div>
                            <img style="max-height:45px; margin-top: 5px;"
                                 src="logo.jpg" class="img-responsive"/>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->


            </div>
        </div>

        <div class="firstBlock">

            <!--Content-->
            <div class="content">

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
        <title></title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>
    </#macro>


    <#macro display_page>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <@page_head/>
    </head>
    <body>

        <@page_body/>

    </body>
    </html>
    </#macro>

