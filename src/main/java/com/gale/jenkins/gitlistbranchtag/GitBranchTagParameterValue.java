package com.gale.jenkins.gitlistbranchtag;

import hudson.model.StringParameterValue;
import org.kohsuke.stapler.DataBoundConstructor;

public class GitBranchTagParameterValue extends StringParameterValue {
    private String name;
    private String value;

    @DataBoundConstructor
    public GitBranchTagParameterValue(String name, String value) {
        super(name,value);
        this.name = name;
        this.value = value;
    }
}
