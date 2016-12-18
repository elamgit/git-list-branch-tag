package com.gale.jenkins.gitlistbranchtag;

import hudson.model.ParameterValue;

/**
 * Created by eannamal on 12/18/16.
 */
public class GitBranchTagParameterValue extends ParameterValue {

    protected GitBranchTagParameterValue(String name, String description) {
        super(name, description);
    }
}
