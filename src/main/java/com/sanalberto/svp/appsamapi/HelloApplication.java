package com.sanalberto.svp.appsamapi;

import com.sanalberto.svp.repositories.IssuesRepositories;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    public HelloApplication() {
        IssuesRepositories issuesRepositories = new IssuesRepositories();
        issuesRepositories.insertIssue();
    }

}