package com.dabsquared.gitlabjenkins;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabCommitStatus;
import org.gitlab.api.models.GitlabProject;

import java.io.IOException;
import java.util.Date;

/**
 * Represents for WebHook payload
 *
 * Created by sisihj on 2015/12/9.
 */


public class GitLabNoteRequest {
    public static GitLabNoteRequest create(String payload) {
        if (payload == null) {
            throw new IllegalArgumentException("payload should not be null");
        }

        GitLabNoteRequest gitLabNote=  GitLabRequest.Builder.INSTANCE.get().fromJson(payload, GitLabNoteRequest.class);
        return gitLabNote;
    }

    public GitLabNoteRequest() {
    }


    public GitLabMergeRequest getGitLabMergeRequest(){

        GitLabMergeRequest gr = new GitLabMergeRequest();
        gr.setObjectAttribute(this.mergeRequest);
        gr.setObject_kind("merge_request");
       return gr;
    }



    private GitlabProject sourceProject = null;

    private String object_kind;

    private String project_id;

    private Repository repository;

    private ObjectAttributes objectAttributes;

    private GitLabMergeRequest.ObjectAttributes mergeRequest;

    public String getObject_kind() {
        return object_kind;
    }

    public void setObject_kind(String object_kind) {
        this.object_kind = object_kind;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public GitlabProject getSourceProject() {
        return sourceProject;
    }

    public void setSourceProject(GitlabProject sourceProject) {
        this.sourceProject = sourceProject;
    }

    public ObjectAttributes getObjectAttributes() {
        return objectAttributes;
    }

    public void setObjectAttributes(ObjectAttributes objectAttributes) {
        this.objectAttributes = objectAttributes;
    }

    public GitLabMergeRequest.ObjectAttributes getMergeRequest() {
        return mergeRequest;
    }

    public void setMergeRequest(GitLabMergeRequest.ObjectAttributes mergeRequest) {
        this.mergeRequest = mergeRequest;
    }

    public GitlabProject getSourceProject (GitLab api) throws IOException {
        if (sourceProject == null) {
            sourceProject = api.instance().getProject(project_id);
        }
        return sourceProject;
    }


    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public GitlabCommitStatus createCommitStatus(GitlabAPI api, String status, String targetUrl) {
        try {
            if(mergeRequest.getLastCommit()!=null) {
                return api.createCommitStatus(sourceProject, mergeRequest.getLastCommit().getId(), status, mergeRequest.getLastCommit().getId(), "Jenkins", targetUrl, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class Repository {

        private String name;

        private String url;

        private String description;

        private String homepage;

        public Repository() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getHomepage() {
            return homepage;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }


        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        }

    }
    public static class ObjectAttributes {

        private Integer id;

        private String note;

        private String noteableType;

        private Integer authorId;

        private String attachement;

        private Date createdAt;

        private Date updatedAt;

        private Integer projectId;

        private String attachment;

        private String lineCode;

        private Integer noteableId;

        private String stDiff;

        private String system;

        private String status;

        private Integer updatedById;

        private String url;


        public ObjectAttributes() {
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getNoteableType() {
            return noteableType;
        }

        public void setNoteableType(String noteableType) {
            this.noteableType = noteableType;
        }

        public Integer getAuthorId() {
            return authorId;
        }

        public void setAuthorId(Integer authorId) {
            this.authorId = authorId;
        }

        public String getAttachement() {
            return attachement;
        }

        public void setAttachement(String attachement) {
            this.attachement = attachement;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getProjectId() {
            return projectId;
        }

        public void setProjectId(Integer projectId) {
            this.projectId = projectId;
        }

        public String getAttachment() {
            return attachment;
        }

        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public Integer getNoteableId() {
            return noteableId;
        }

        public void setNoteableId(Integer noteableId) {
            this.noteableId = noteableId;
        }

        public String getStDiff() {
            return stDiff;
        }

        public void setStDiff(String stDiff) {
            this.stDiff = stDiff;
        }

        public String getSystem() {
            return system;
        }

        public void setSystem(String system) {
            this.system = system;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getUpdatedById() {
            return updatedById;
        }

        public void setUpdatedById(Integer updatedById) {
            this.updatedById = updatedById;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

//    public static class MergeRequest {
//        private Integer id;
//
//        private Integer iid;
//
//        private String targetBranch;
//
//        private String sourceBranch;
//
//        private Integer sourceProjectId;
//
//        private Integer authorId;
//
//        private Integer assigneeId;
//
//        private String title;
//
//        private Date createdAt;
//
//        private Date updatedAt;
//
//        private String state;
//
//        private String mergeStatus;
//
//        private Integer targetProjectId;
//
//        private String description;
//
//        private Branch source;
//
//        private Branch target;
//
//        private LastCommit lastCommit;
//
//        private String action;
//
//        public MergeRequest() {
//        }
//
//        @Override
//        public String toString() {
//            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
//        }
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public Integer getIid() {
//            return iid;
//        }
//
//        public void setIid(Integer iid) {
//            this.iid = iid;
//        }
//
//        public String getTargetBranch() {
//            return targetBranch;
//        }
//
//        public void setTargetBranch(String targetBranch) {
//            this.targetBranch = targetBranch;
//        }
//
//        public String getSourceBranch() {
//            return sourceBranch;
//        }
//
//        public void setSourceBranch(String sourceBranch) {
//            this.sourceBranch = sourceBranch;
//        }
//
//        public Integer getSourceProjectId() {
//            return sourceProjectId;
//        }
//
//        public void setSourceProjectId(Integer sourceProjectId) {
//            this.sourceProjectId = sourceProjectId;
//        }
//
//        public Integer getAuthorId() {
//            return authorId;
//        }
//
//        public void setAuthorId(Integer authorId) {
//            this.authorId = authorId;
//        }
//
//        public Integer getAssigneeId() {
//            return assigneeId;
//        }
//
//        public void setAssigneeId(Integer assigneeId) {
//            this.assigneeId = assigneeId;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public Date getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(Date createdAt) {
//            this.createdAt = createdAt;
//        }
//
//        public Date getUpdatedAt() {
//            return updatedAt;
//        }
//
//        public void setUpdatedAt(Date updatedAt) {
//            this.updatedAt = updatedAt;
//        }
//
//        public String getState() {
//            return state;
//        }
//
//        public void setState(String state) {
//            this.state = state;
//        }
//
//        public String getMergeStatus() {
//            return mergeStatus;
//        }
//
//        public void setMergeStatus(String mergeStatus) {
//            this.mergeStatus = mergeStatus;
//        }
//
//        public Integer getTargetProjectId() {
//            return targetProjectId;
//        }
//
//        public void setTargetProjectId(Integer targetProjectId) {
//            this.targetProjectId = targetProjectId;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public Branch getSource() {
//            return source;
//        }
//
//        public void setSource(Branch source) {
//            this.source = source;
//        }
//
//        public Branch getTarget() {
//            return target;
//        }
//
//        public void setTarget(Branch target) {
//            this.target = target;
//        }
//
//        public LastCommit getLastCommit() {
//            return lastCommit;
//        }
//
//        public void setLastCommit(LastCommit lastCommit) {
//            this.lastCommit = lastCommit;
//        }
//
//        public String getAction() {
//            return action;
//        }
//
//        public void setAction(String action) {
//            this.action = action;
//        }
//    }

//    public static class Branch{
//        private String name;
//        private String ssh_url;
//        private String http_url;
//        private String namespace;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getSsh_url() {
//            return ssh_url;
//        }
//
//        public void setSsh_url(String ssh_url) {
//            this.ssh_url = ssh_url;
//        }
//
//        public String getHttp_url() {
//            return http_url;
//        }
//
//        public void setHttp_url(String http_url) {
//            this.http_url = http_url;
//        }
//
//        public String getNamespace() {
//            return namespace;
//        }
//
//        public void setNamespace(String namespace) {
//            this.namespace = namespace;
//        }
//    }
//    public static class LastCommit{
//        private String id;
//        private String message;
//        private String url;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        @Override
//        public String toString() {
//            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
//        }
//    }
}
