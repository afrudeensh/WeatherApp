package com.example.response;

import com.example.DTO.SourceDTO;

import java.util.List;

public class SourceResponse {
    private String status;
    private List<SourceDTO> sources;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SourceDTO> getSources() {
        return sources;
    }

    public void setSources(List<SourceDTO> sources) {
        this.sources = sources;
    }

}
