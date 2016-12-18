package com.gale.jenkins.gitlistbranchtag;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.ParameterDefinition;
import hudson.model.ParameterValue;
import hudson.model.SimpleParameterDefinition;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.export.Model;

public class GitBranchTagParameterDefinition extends ParameterDefinition {

    private String name;
    private String repository;
    private String additional;

    @DataBoundConstructor
    public GitBranchTagParameterDefinition(String name, String repository, String additional){
        super(name);
        this.name = name;
        this.repository = repository;
        this.additional = additional;
        System.err.println("in constructor");
    }


    @Override
    public ParameterValue createValue(StaplerRequest req, JSONObject jo) {
        return new GitBranchTagParameterValue("name", "repo", "additional");
    }

    @Override
    public ParameterValue createValue(StaplerRequest req) {
        return new GitBranchTagParameterValue("name", "repo", "additional");
    }

    @Extension
    public static class GitBranchTagParameterDescriptor extends ParameterDescriptor {

        @Override
        public String getDisplayName() {
            return "hello";
        }
    }

}
