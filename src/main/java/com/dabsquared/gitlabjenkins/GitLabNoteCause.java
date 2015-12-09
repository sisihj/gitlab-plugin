//
//package com.dabsquared.gitlabjenkins;
//
//import hudson.triggers.SCMTrigger;
//
//import java.io.File;
//import java.io.IOException;
//
///**
// * Created by sisihj on 9/12/15.
// */
//public class GitLabNoteCause extends SCMTrigger.SCMTriggerCause {
//
//    private GitLabNoteRequest noteRequest;
//
//    public GitLabNoteCause(GitLabNoteRequest noteRequest) {
//        this.noteRequest = noteRequest;
//    }
//
//    public GitLabNoteCause(GitLabNoteRequest noteRequest, File logFile) throws IOException {
//        super(logFile);
//        this.noteRequest = noteRequest;
//    }
//
//    public GitLabNoteCause(GitLabNoteRequest noteRequest, String pollingLog) {
//        super(pollingLog);
//        this.noteRequest = noteRequest;
//    }
//
//    public GitLabNoteRequest getNoteRequest() {
//        return noteRequest;
//    }
//
//    @Override
//    public String getShortDescription() {
//        return "GitLab Note Request #" + this.noteRequest.getMergeRequest().getIid() + " : " + this.noteRequest.getMergeRequest().getSourceBranch() +
//                " => " + this.noteRequest.getMergeRequest().getTargetBranch();
//    }
//
//}
