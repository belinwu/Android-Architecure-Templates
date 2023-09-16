package com.vnstudio.cleanarchitecturedemo

import org.json.JSONArray
import org.json.JSONObject

class JsonConverter {

    fun getForkList(responseData: String): ArrayList<Fork> {
        val forkList = ArrayList<Fork>()
        val jsonArray = JSONArray(responseData)
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.get(i) as JSONObject
            forkList.add(createForkObject(jsonObject))
        }
        return forkList
    }

    private fun createForkObject(jsonObject: JSONObject): Fork {
        val fork = Fork()
        fork.id = jsonObject.getLong("id")
        fork.node_id = jsonObject.getString("node_id")
        fork.name = jsonObject.getString("name")
        fork.full_name = jsonObject.getString("full_name")
        fork.private = jsonObject.getBoolean("private")
        fork.html_url = jsonObject.getString("html_url")
        fork.description = jsonObject.getString("description")
        fork.fork = jsonObject.getBoolean("fork")
        fork.url = jsonObject.getString("url")
        fork.forks_url = jsonObject.getString("forks_url")
        fork.keys_url = jsonObject.getString("keys_url")
        fork.collaborators_url = jsonObject.getString("collaborators_url")
        fork.teams_url = jsonObject.getString("teams_url")
        fork.hooks_url = jsonObject.getString("hooks_url")
        fork.issue_events_url = jsonObject.getString("issue_events_url")
        fork.events_url = jsonObject.getString("events_url")
        fork.assignees_url = jsonObject.getString("assignees_url")
        fork.branches_url = jsonObject.getString("branches_url")
        fork.tags_url = jsonObject.getString("tags_url")
        fork.blobs_url = jsonObject.getString("blobs_url")
        fork.git_tags_url = jsonObject.getString("git_tags_url")
        fork.git_refs_url = jsonObject.getString("git_refs_url")
        fork.trees_url = jsonObject.getString("trees_url")
        fork.statuses_url = jsonObject.getString("statuses_url")
        fork.languages_url = jsonObject.getString("languages_url")
        fork.stargazers_url = jsonObject.getString("stargazers_url")
        fork.contributors_url = jsonObject.getString("contributors_url")
        fork.subscribers_url = jsonObject.getString("subscribers_url")
        fork.subscription_url = jsonObject.getString("subscription_url")
        fork.commits_url = jsonObject.getString("commits_url")
        fork.git_commits_url = jsonObject.getString("git_commits_url")
        fork.comments_url = jsonObject.getString("comments_url")
        fork.issue_comment_url = jsonObject.getString("issue_comment_url")
        fork.contents_url = jsonObject.getString("contents_url")
        fork.compare_url = jsonObject.getString("compare_url")
        fork.merges_url = jsonObject.getString("merges_url")
        fork.archive_url = jsonObject.getString("archive_url")
        fork.downloads_url = jsonObject.getString("downloads_url")
        fork.issues_url = jsonObject.getString("issues_url")
        fork.pulls_url = jsonObject.getString("pulls_url")
        fork.milestones_url = jsonObject.getString("milestones_url")
        fork.notifications_url = jsonObject.getString("notifications_url")
        fork.labels_url = jsonObject.getString("labels_url")
        fork.releases_url = jsonObject.getString("releases_url")
        fork.deployments_url = jsonObject.getString("deployments_url")
        fork.created_at = jsonObject.getString("created_at")
        fork.updated_at = jsonObject.getString("updated_at")
        fork.pushed_at = jsonObject.getString("pushed_at")
        fork.git_url = jsonObject.getString("git_url")
        fork.ssh_url = jsonObject.getString("ssh_url")
        fork.clone_url = jsonObject.getString("clone_url")
        fork.svn_url = jsonObject.getString("svn_url")
        fork.homepage = jsonObject.getString("homepage")
        fork.size = jsonObject.getInt("size")
        fork.stargazers_count = jsonObject.getInt("stargazers_count")
        fork.watchers_count = jsonObject.getInt("watchers_count")
        fork.language = jsonObject.getString("language")
        fork.has_issues = jsonObject.getBoolean("has_issues")
        fork.has_projects = jsonObject.getBoolean("has_projects")
        fork.has_downloads = jsonObject.getBoolean("has_downloads")
        fork.has_wiki = jsonObject.getBoolean("has_wiki")
        fork.has_pages = jsonObject.getBoolean("has_pages")
        fork.has_discussions = jsonObject.getBoolean("has_discussions")
        fork.forks_count = jsonObject.getInt("forks_count")
        fork.mirror_url = jsonObject.getString("mirror_url")
        fork.archived = jsonObject.getBoolean("archived")
        fork.disabled = jsonObject.getBoolean("disabled")
        fork.open_issues_count = jsonObject.getInt("open_issues_count")
        fork.license =jsonObject.getString("license")
        fork.allow_forking = jsonObject.getBoolean("allow_forking")
        fork.is_template = jsonObject.getBoolean("is_template")
        fork.web_commit_signoff_required = jsonObject.getBoolean("web_commit_signoff_required")
        fork.visibility = jsonObject.getString("visibility")
        fork.forks = jsonObject.getInt("forks")
        fork.open_issues = jsonObject.getInt("open_issues")
        fork.watchers = jsonObject.getInt("watchers")
        fork.default_branch = jsonObject.getString("default_branch")
        val ownerObject = jsonObject.getJSONObject("owner")
        val owner = Owner()
        owner.login = ownerObject.getString("login")
        owner.id = ownerObject.getLong("id")
        owner.node_id = ownerObject.getString("node_id")
        owner.avatar_url = ownerObject.getString("avatar_url")
        owner.gravatar_id = ownerObject.getString("gravatar_id")
        owner.url = ownerObject.getString("url")
        owner.html_url = ownerObject.getString("html_url")
        owner.followers_url = ownerObject.getString("followers_url")
        owner.following_url = ownerObject.getString("following_url")
        owner.gists_url = ownerObject.getString("gists_url")
        owner.starred_url = ownerObject.getString("starred_url")
        owner.subscriptions_url = ownerObject.getString("subscriptions_url")
        owner.organizations_url = ownerObject.getString("organizations_url")
        owner.repos_url = ownerObject.getString("repos_url")
        owner.events_url = ownerObject.getString("events_url")
        owner.received_events_url = ownerObject.getString("received_events_url")
        owner.type = ownerObject.getString("type")
        owner.site_admin = ownerObject.getBoolean("site_admin")
        fork.owner = owner
        return fork
    }
}