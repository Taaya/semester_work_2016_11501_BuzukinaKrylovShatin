package ru.kpfu.Buzukina.entities;

import ru.kpfu.Buzukina.daoImpl.CourseDAOImpl;
import ru.kpfu.Buzukina.dao.CourseDAO;

/**
 * Created by taa on 02.11.16.
 */
public class Course {
    private long id;

    public Course(long id, String name, String description, String languageCode, int level) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.languageCode = languageCode;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public int getLevel() {
        return level;
    }

    private String name;
    private String description;
    private String languageCode;
    private int level;

    public String getNextClass(Course course){
        CourseDAO courseDAO = new CourseDAOImpl();
        return courseDAO.getNextClass(this);
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
    public String getSimpleLanguage(){

        String language = this.getLanguageCode();
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

}
