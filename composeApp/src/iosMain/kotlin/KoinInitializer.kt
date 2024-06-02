import org.koin.core.context.startKoin

fun initKoin() {
    //init all the app modules on here
    startKoin {
        modules()
    }
}