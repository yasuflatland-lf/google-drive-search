# Google Drive Search
This project is frontend and service bundles for Google Drive Search functionality provided by google-drive-hook bundle. 

## Setup your Java environment:

- Install [JDK 1.8 or higher](http://www.oracle.com/technetwork/java/javase/downloads)
- Install [Gradle](https://gradle.org/)
- Install [blade](https://dev.liferay.com/ja/develop/tutorials/-/knowledge_base/7-0/installing-blade-cli)

## Getting Started
1. Create a Liferay Workspace. 
1. Startup Liferay bundle.
1. Clone [google-drive-hook](https://github.com/yasuflatland-lf/google-drive-hook/tree/develop) into the `${liferay_workspace}/wars`. For installation and configuration, please consult to the README.md of the google-drive-hook.
1. Clone this bundle at `${liferay_workspace}/modules` and `blade deploy`

## Bundle Description
* `google-drive-auth-generator` 
  * Generating authentication information (Access Token and Refresh Token) from Client ID and Client Secret.
* `google-drive-fragments-search`
  * Overriding Search frontend implementation for the inside of Documents and Media Google Drive Folder. 
* `google-drive-search-api` and `google-drive-search-service`
  * Backend APIs providing search funcdtioality for Google Drive.
* `google-drive-portlet-filter`
  * Fragment doesn't automatically load backend services (`google-drive-search-api` and `google-drive-search-service`). For `google-drive-fragment-global-search` bundle, this bundle load these APIs and insert into request attribute so that API can be used in fragment JSPs
* `google-drive-fragment-global-search`
  * Overriding Search frontend of search portlet to add Google Drive Search functionality to the default search results.