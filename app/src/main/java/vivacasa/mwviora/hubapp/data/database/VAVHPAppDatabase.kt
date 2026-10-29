package vivacasa.mwviora.hubapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import vivacasa.mwviora.hubapp.data.database.converter.Converters
import vivacasa.mwviora.hubapp.data.database.dao.HighScoreDao
import vivacasa.mwviora.hubapp.data.entity.HighScore

@Database(
    entities = [HighScore::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class VAVHPAppDatabase : RoomDatabase() {

    abstract fun highScoreDao(): HighScoreDao
}
