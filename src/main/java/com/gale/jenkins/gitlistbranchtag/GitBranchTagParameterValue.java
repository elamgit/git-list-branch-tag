package com.gale.jenkins.gitlistbranchtag;

import hudson.model.ParameterValue;
import org.kohsuke.stapler.DataBoundConstructor;

public class GitBranchTagParameterValue extends ParameterValue {
    private String name;
    private String repository;
    private String additional;

    @DataBoundConstructor
    public GitBranchTagParameterValue(String name, String repository, String additional) {
        super(name);
        this.name = name;
        this.repository = repository;
        this.additional = additional;
    }
}
