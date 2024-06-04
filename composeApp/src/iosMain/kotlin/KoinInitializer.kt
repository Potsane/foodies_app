import org.koin.core.context.startKoin
import injection.modules

fun initKoin() {
    //init all the app modules on here
    startKoin {
        modules(modules)
    }
}