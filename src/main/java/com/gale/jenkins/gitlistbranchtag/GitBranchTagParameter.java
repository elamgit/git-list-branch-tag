package com.gale.jenkins.gitlistbranchtag;

import hudson.model.ParameterDefinition;
import hudson.model.ParameterValue;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 * Created by eannamal on 12/17/16.
 */
public class GitBranchTagParameter extends ParameterDefinition {

    private String name;
    private String repository;
    private String additional;

    @DataBoundConstructor
    public GitBranchTagParameter(String name){
        super(name);
    }

    @Override
    public ParameterValue createValue(StaplerRequest req, JSONObject jo) {
        return new GitBranchTagParameterValue("gitn", "gitd");
    }

    @Override
    public ParameterValue createValue(StaplerRequest req) {
        return new GitBranchTagParameterValue("gitn", "gitd");
    }
}
