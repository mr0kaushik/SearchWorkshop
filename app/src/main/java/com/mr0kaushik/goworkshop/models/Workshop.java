package com.mr0kaushik.goworkshop.models;

public class Workshop {
    private String workshopTitle;
    private String workshopDescription;
    private String workshopOrganiser;
    private String workshopLocation;
    private String startDate;
    private String applyBy;
    private int workshopDuration;



    private String cityName;

    public Workshop(String workshopTitle, String workshopDescription, String workshopOrganiser, String workshopLocation, String startDate, String applyBy, int workshopDuration) {
        this.workshopTitle = workshopTitle;
        this.workshopDescription = workshopDescription;
        this.workshopOrganiser = workshopOrganiser;
        this.workshopLocation = workshopLocation;
        this.startDate = startDate;
        this.applyBy = applyBy;
        this.workshopDuration = workshopDuration;
    }

    public String getWorkshopTitle() {
        return workshopTitle;
    }

    public void setWorkshopTitle(String workshopTitle) {
        this.workshopTitle = workshopTitle;
    }

    public String getWorkshopDescription() {
        return workshopDescription;
    }

    public void setWorkshopDescription(String workshopDescription) {
        this.workshopDescription = workshopDescription;
    }

    public String getWorkshopOrganiser() {
        return workshopOrganiser;
    }

    public void setWorkshopOrganiser(String workshopOrganiser) {
        this.workshopOrganiser = workshopOrganiser;
    }

    public String getWorkshopLocation() {
        return workshopLocation;
    }

    public void setWorkshopLocation(String workshopLocation) {
        this.workshopLocation = workshopLocation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getApplyBy() {
        return applyBy;
    }

    public void setApplyBy(String applyBy) {
        this.applyBy = applyBy;
    }

    public int getWorkshopDuration() {
        return workshopDuration;
    }

    public void setWorkshopDuration(int workshopDuration) {
        this.workshopDuration = workshopDuration;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


}
