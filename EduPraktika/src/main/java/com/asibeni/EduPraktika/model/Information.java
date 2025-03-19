package com.asibeni.EduPraktika.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Information {
    String publicationYear;
    String level;
    public Information(String publicationYear,String level) {
        this.publicationYear = publicationYear;
        this.level = level;
    }

    public Information() {

    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
