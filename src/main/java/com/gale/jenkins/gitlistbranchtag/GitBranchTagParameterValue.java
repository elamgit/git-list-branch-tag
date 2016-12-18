package com.gale.jenkins.gitlistbranchtag;

import hudson.model.ParameterValue;
import org.kohsuke.stapler.DataBoundConstructor;

public class GitBranchTagParameterValue extends ParameterValue {
    private String name;
    private String value;

    @DataBoundConstructor
    public GitBranchTagParameterValue(String name, String value) {
        super(name);
        this.name = name;
        this.value = value;
    }
}
