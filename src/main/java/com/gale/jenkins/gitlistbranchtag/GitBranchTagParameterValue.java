package com.gale.jenkins.gitlistbranchtag;

import hudson.model.ParameterValue;

public class GitBranchTagParameterValue extends ParameterValue {

    protected GitBranchTagParameterValue(String name, String description) {
        super(name, description);
    }
}
