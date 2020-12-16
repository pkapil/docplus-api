package com.docplus.config;


import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


public class NaiveAuditorAware implements AuditorAware<String> {

    private String auditor = "auditor";

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(auditor);
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }
}