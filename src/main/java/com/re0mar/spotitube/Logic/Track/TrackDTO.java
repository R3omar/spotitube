package com.re0mar.spotitube.Logic.Track;

public class TrackDTO {
    private int trackID;
    private String title;
    private String performer;
    private String url;
    private int duration;
    private boolean offlineAvailable;

    private String album;

    private String publishDate;
    private String description;

    public TrackDTO(int trackID, String title, String performer, String url, int duration, boolean offline, String album, String publishDate, String description) {
        this.trackID = trackID;
        this.title = title;
        this.performer = performer;
        this.url = url;
        this.duration = duration;
        this.offlineAvailable = offline;
        this.album = album;
        this.publishDate = publishDate;
        this.description = description;
    }

    public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isOfflineAvailable() {
        return offlineAvailable;
    }

    public void setOfflineAvailable(boolean offlineAvailable) {
        this.offlineAvailable = offlineAvailable;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
