package com.example.req.service.DTO;

public class ManualDTO {
    private String manual_name;
    private String manual_description;
    private String manual_category;
    private StepDTO [] steps;

    public String getManual_name() {
        return manual_name;
    }

    public void setManual_name(String manual_name) {
        this.manual_name = manual_name;
    }

    public String getManual_description() {
        return manual_description;
    }

    public void setManual_description(String manual_description) {
        this.manual_description = manual_description;
    }

    public StepDTO[] getSteps() {
        return steps;
    }

    public void setSteps(StepDTO[] steps) {
        this.steps = steps;
    }

    public String getManual_category() {
        return manual_category;
    }

    public void setManual_category(String manual_category) {
        this.manual_category = manual_category;
    }
}
