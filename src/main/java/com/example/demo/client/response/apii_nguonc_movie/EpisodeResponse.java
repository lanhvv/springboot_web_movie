package com.example.demo.client.response.apii_nguonc_movie;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EpisodeResponse {
    @JsonProperty("server_name")
    private String serverName;
    @JsonProperty("server_date")
    private List<EpisodeDataResponse> serverData;

    public EpisodeResponse() {
    }

    public EpisodeResponse(String serverName, List<EpisodeDataResponse> serverData) {
        this.serverName = serverName;
        this.serverData = serverData;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public List<EpisodeDataResponse> getServerData() {
        return serverData;
    }

    public void setServerData(List<EpisodeDataResponse> serverData) {
        this.serverData = serverData;
    }
}
