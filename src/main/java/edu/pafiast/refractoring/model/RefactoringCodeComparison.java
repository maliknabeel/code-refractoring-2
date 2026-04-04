package edu.pafiast.refractoring.model;

public class RefactoringCodeComparison {

    private String name;
    private String category;
    private String badCode;
    private String goodCode;

    public RefactoringCodeComparison() {}

    public RefactoringCodeComparison(String name, String category, String badCode, String goodCode) {
        this.name = name;
        this.category = category;
        this.badCode = badCode;
        this.goodCode = goodCode;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getBadCode() { return badCode; }
    public void setBadCode(String badCode) { this.badCode = badCode; }

    public String getGoodCode() { return goodCode; }
    public void setGoodCode(String goodCode) { this.goodCode = goodCode; }
}
