package domain;

public class InfoJob {
    private String titlePaper;
    private String descriptionPaper;
    private String nameConference;
    private String nameAuthor;

    public InfoJob(String titlePaper, String descriptionPaper, String nameConference, String nameAuthor) {
        this.titlePaper = titlePaper;
        this.descriptionPaper = descriptionPaper;
        this.nameConference = nameConference;
        this.nameAuthor = nameAuthor;
    }

    public InfoJob() {
    }

    public String getTitlePaper() {
        return titlePaper;
    }

    public void setTitlePaper(String titlePaper) {
        this.titlePaper = titlePaper;
    }

    public String getDescriptionPaper() {
        return descriptionPaper;
    }

    public void setDescriptionPaper(String descriptionPaper) {
        this.descriptionPaper = descriptionPaper;
    }

    public String getNameConference() {
        return nameConference;
    }

    public void setNameConference(String nameConference) {
        this.nameConference = nameConference;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }
}
