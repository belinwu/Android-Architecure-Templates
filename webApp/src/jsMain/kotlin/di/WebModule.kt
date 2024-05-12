package di

import com.vnteam.architecturetemplates.data.database.DatabaseDriverFactory
import org.koin.dsl.module
import presentation.details.DetailsViewModel
import presentation.list.ListViewModel

val webModule = module {
    single {
        DatabaseDriverFactory()
    }
    single {
        ListViewModel(get(), get())
    }
    single {
        DetailsViewModel(get(), get())
    }
}