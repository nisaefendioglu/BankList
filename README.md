# BankList

Welcome to the BankList App! This Android application allows users to explore a list of bank branches, filter them by city, view branch details, and even obtain directions to the selected branch.

## Table of Contents
- [Getting Started](#getting-started)
- [Features](#features)
- [Architecture](#architecture)
- [Dependencies](#dependencies)
- [Unit Testing](#unit-testing)

## Getting Started

### Clone the Repository

To get started with the project, clone this repository to your local machine using the following command:

```shell
git clone https://github.com/nisaefendioglu/BankList.git
```

### Open in Android Studio

1. Launch Android Studio.
2. Select "Open an Existing Project" and navigate to the cloned repository folder.
3. Open the project.

### Build and Run

- Build the project by selecting "Build" > "Make Project" from the Android Studio menu.
- Run the app on an emulator or a physical Android device by selecting "Run" > "Run 'app'" from the menu.

## Features

### Home Page

- Upon opening the app, a loading process is displayed in the center of the screen.
- The app makes service calls to the provided API endpoint for branch data.
- Results are displayed, and a warning is shown if there is no data.
- Users can filter the branch list by entering a city name.
- Internet connectivity is checked, and a warning is displayed if there is no internet connection.

### Branch Details Page

- Users can click on a listed branch to view its details.
- Branch details are shown on this page.
- Firebase Analytics logs branch details when this page is opened.
- Users can obtain directions to the branch by clicking a navigation button.

### Architecture

- The app follows the MVVM (Model-View-ViewModel) architectural pattern.
- Dagger Hilt is used for dependency injection.
- Room Database is used for local data storage, allowing offline access.
- Unit tests have been implemented to ensure the app's functionality.
- ProGuard is configured for application security.

## Dependencies

The project relies on several external dependencies, including but not limited to:

- [Retrofit](https://square.github.io/retrofit/) for making API calls.
- [Room Database](https://developer.android.com/jetpack/androidx/releases/room) for local data storage.
- [Dagger Hilt](https://dagger.dev/hilt/) for dependency injection.
- [Firebase Analytics](https://firebase.google.com/docs/analytics) for logging branch details.
- [Glide](https://github.com/bumptech/glide) for image loading and caching.


## Unit Testing

Unit tests have been written to ensure the reliability of the app's features. You can run these tests using Android Studio's built-in testing tools.

## License

This project is licensed under the [MIT License](LICENSE). You can freely use and modify the code as per the terms of the license.

