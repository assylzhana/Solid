package models;

import interfaces.Item;

public class Magazine implements Item {
    private String title;
    private int issueNumber;

    public Magazine(String title, int issueNumber) {
        this.title = title;
        this.issueNumber = issueNumber;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}
