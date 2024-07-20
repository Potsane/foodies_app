package injection

val modules = listOf(
    localDataModule,
    localDataStorageModule(),
    remoteDataModule,
    repositoriesModule,
    viewModelsModule,
)
