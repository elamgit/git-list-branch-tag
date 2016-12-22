package com.gale.jenkins.gitlistbranchtag;

import hudson.Extension;
import hudson.model.*;
import hudson.util.ListBoxModel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.AncestorInPath;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import java.io.IOException;

public class GitBranchTagParameterDefinition extends ParameterDefinition {

    private String name;
    private String repository;
    private final String additional;

    @DataBoundConstructor
    public GitBranchTagParameterDefinition(String name, String repository, String additional){
        super(name);
        this.name = name;
        this.repository = repository;
        this.additional = additional;
    }


    @Override
    public ParameterValue createValue(StaplerRequest req, JSONObject jo) {
        Object value = jo.get("value");
        StringBuilder strValue = new StringBuilder();
        if (value instanceof String) {
            strValue.append(value);
        } else if (value instanceof JSONArray) {
            JSONArray jsonValues = (JSONArray) value;
            for (int i = 0; i < jsonValues.size(); i++) {
                strValue.append(jsonValues.getString(i));
                if (i < jsonValues.size() - 1) {
                    strValue.append(",");
                }
            }
        }

        if (strValue.length() == 0) {
            strValue.append("master");
        }

        GitBranchTagParameterValue gitParameterValue = new GitBranchTagParameterValue(jo.getString("name"), strValue.toString());
        return gitParameterValue;
    }

    @Override
    public ParameterValue createValue(StaplerRequest request) {
        String value[] = request.getParameterValues(getName());
        if (value == null || value.length == 0 || StringUtils.isBlank(value[0])) {
            return getDefaultParameterValue();
        }
        return new GitBranchTagParameterValue(getName(), value[0]);
    }

    @Extension
    public static class GitBranchTagParameterDescriptor extends ParameterDescriptor {

        @Override
        public String getDisplayName() {
            return "Git List Branch Tags";
        }

        public ListBoxModel doFillValueItems(@AncestorInPath Job job, @QueryParameter String param)
                throws IOException, InterruptedException {
            ListBoxModel items = new ListBoxModel();
//            ParametersDefinitionProperty property = (ParametersDefinitionProperty) job.getProperty(ParametersDefinitionProperty.class);
//            property.getParameterDefinition("appLabel");
            items.add("master", "master");
            ListBoxModel.Option option = new ListBoxModel.Option("release","release",true);
            items.add(1,option);
            return items;
        }
    }

}
