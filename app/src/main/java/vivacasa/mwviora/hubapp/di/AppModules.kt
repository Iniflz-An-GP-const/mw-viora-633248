package vivacasa.mwviora.hubapp.di

import androidx.room.Room
import vivacasa.mwviora.hubapp.data.database.VAVHPAppDatabase
import vivacasa.mwviora.hubapp.data.repository.HighScoreRepository
import vivacasa.mwviora.hubapp.data.model.Difficulty
import vivacasa.mwviora.hubapp.ui.viewmodel.GameViewModel
import vivacasa.mwviora.hubapp.ui.viewmodel.HighScoreViewModel
import vivacasa.mwviora.hubapp.ui.viewmodel.MenuViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private const val DB_NAME = "vavhp_db"

val dataModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = VAVHPAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<VAVHPAppDatabase>().highScoreDao() }

    single {
        HighScoreRepository(
            highScoreDao = get(),
            coroutineDispatcher = get(DispatchersQualifiers.IO)
        )
    }
}

val viewModule = module {
    viewModel { (difficulty: Difficulty) ->
        GameViewModel(difficulty = difficulty, highScoreRepository = get())
    }

    viewModel { HighScoreViewModel(highScoreRepository = get()) }

    viewModel { MenuViewModel(highScoreRepository = get()) }
}

val appModules: List<Module> = listOf(dispatcherModule, dataModule, viewModule)
