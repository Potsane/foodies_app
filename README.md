# Food Recipes app
This is a Kotlin Multi-Platform Mobile application made using `Room`, `Koin`, `Ktor`, `Coil`, and `Datastore` and Material Design and follows a multi-module MVVM Architecture. It shows a list of recipes, and there are plans to add more functionality. 

## API 
```
https://www.themealdb.com/api.php
```

## Artchitecture
The application follows Google’s Layered architecture design [guideline](https://developer.android.com/topic/architecture). The app's overall architecture comprises of three layers: the UI, Domain Layer, and Data layers. 
Each of these has different responsibilities. 

<img width="878" alt="Screenshot 2024-01-16 at 13 05 06" src="https://github.com/Potsane/pokemon_app/assets/7416651/327baccf-fc41-4768-931e-4a2f7522e273">

The solution makes use of a Unidirectional Flow of data between each of the layers, the UI Layer components send events to the Domain Layer, which in turn sends data requests to the Data Layer. In return, the Data Layers send data to the Domain Layer, which sends UI events to the UI layer. 

On the UI Layer, we make use of StateFlow for reactive state management. The views (composables) send events and observe data updates on the view model, and the view model responds by updating the state variables in question. 

![Screenshot 2024-01-16 at 13 10 37](https://github.com/Potsane/pokemon_app/assets/7416651/a522ebdb-2c8b-4617-b045-68f115d51668)

## Illustraton
<img src="https://github.com/user-attachments/assets/4b8c022d-da97-4ae7-ad4c-806144efc7fc" width="250" height = "520">&emsp;
<img src="https://github.com/user-attachments/assets/dda3ee3c-4a70-4823-a9f5-a4206b49587f" width="250" height = "520">






