package ru.myproject.entities;

/**
 * Created by taa on 02.11.16.
 */
public class Course {
    private long id;

    public Course(long id, String name, String description, String language_code, int level) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.language_code = language_code;
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

    public String getLanguage_code() {
        return language_code;
    }

    public int getLevel() {
        return level;
    }

    private String name;
    private String description;
    private String language_code;
    private int level;

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }
    public String getSimpleLanguage(){

        String language = this.getLanguage_code();
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
