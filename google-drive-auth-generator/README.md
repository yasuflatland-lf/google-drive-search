# Drive API Authentication infromation generator
This tool generetes an access token and an refresh token based on given Client ID and Client Secret reqired to retrive data thorugh Drive API. 

## Setup your Java environment:

- Install [JDK 1.8 or higher](http://www.oracle.com/technetwork/java/javase/downloads)
- Install [Gradle](https://gradle.org/)

## Generate Access Token and Refresh Token

1. Edit `credentials.json_default`  and set the client ID and secret. You can create an ID/secret pair
   using the [Google Developers Console](https://console.developers.google.com). Then rename to `credentials.json`.
1. Run `gradle assemble` to build the project.
1. Run `gradle -q run`
1. The sample will attempt to open a new window or tab in your default browser. If this fails, copy the URL from the console and manually open it in your browser.
1. If you are not already logged into your Google account, you will be prompted to log in. If you are logged into multiple Google accounts, you will be asked to select one account to use for the authorization.
1. Click the Accept button. The sample will proceed automatically, and you may close the window/tab.