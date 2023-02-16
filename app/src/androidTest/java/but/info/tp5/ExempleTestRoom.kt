package but.info.tp5

import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExempleTestRoom {
    private val TEST_DB = "bdTest"

    /* TODO décommenter et remplacer Base par votre base de données
    @get:Rule
    val helper: MigrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        Base::class.java,
        listOf(),
        FrameworkSQLiteOpenHelperFactory()
    )
    */
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("but.info.tp4", appContext.packageName)
    }
    @Test
    fun testMigration2_4() {
        /* TODO écrire un test
        var db = helper.createDatabase(TEST_DB, 1)
        db.close()
         */
    }
}