package ru.kpfu.Buzukina.entities;

import ru.kpfu.Buzukina.dao.ExamDAO;
import ru.kpfu.Buzukina.daoImpl.ExamDAOImpl;

/**
 * Created by taa on 05.11.16.
 */
public class Exam {

    private long id;

    public Exam(long id, String name, String language, String description) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    private String name;
    private String language;

    public String getDescription() {
        return description;
    }

    private String description;

    public String getSimpleLanguage(){

        String language = this.getLanguage();
        switch (language){
            case "en":
                language = "Английский";
                break;
            case "de":
                language = "Немецкий";
                break;
            case "ja":
                language = "Японский";
                break;
            case "fr":
                language = "Французский";
                break;
            case "ch":
                language = "Китайский";
                break;
        }
        return language;
    }
    String getExamDate(Exam exam){
        ExamDAO examDAO = new ExamDAOImpl();
        return examDAO.getExamDate(this);
    }

}
