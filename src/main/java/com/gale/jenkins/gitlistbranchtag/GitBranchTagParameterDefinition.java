package com.gale.jenkins.gitlistbranchtag;

import hudson.Extension;
import hudson.model.*;
import hudson.util.ListBoxModel;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.AncestorInPath;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.export.Model;

import java.io.IOException;
import java.util.Map;

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
        return new GitBranchTagParameterValue("name1", "value1");
    }

    @Override
    public ParameterValue createValue(StaplerRequest req) {
        return new GitBranchTagParameterValue("name2", "value2");
    }

    @Extension
    public static class GitBranchTagParameterDescriptor extends ParameterDescriptor {

        @Override
        public String getDisplayName() {
            return "hello";
        }

        public ListBoxModel doFillValueItems(@AncestorInPath Job job, @QueryParameter String param)
                throws IOException, InterruptedException {
            ListBoxModel items = new ListBoxModel();
            items.add("master", "master");
            return items;
        }
    }

}
