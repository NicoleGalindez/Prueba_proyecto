import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.pruebaapp.model.BdHelper

class ManagerDb(private val context: Context) {

    private val bdHelper = BdHelper(context)
    private lateinit var bd: SQLiteDatabase

    fun openBdWr() {
        bd = bdHelper.writableDatabase
    }

    fun openBdRd() {
        bd = bdHelper.readableDatabase
    }

    fun insertData(nombreMen: String, apellidoMen: String, tipoDocMen: String, numeroDocMen: Int, telefonoMen: Int, correoMen: String): Long {
        openBdWr()
        val contenedor = ContentValues().apply {
            put("nombreMenInput", nombreMen)
            put("apellidoMenInput", apellidoMen)
            put("tipoDocumentoMen4", tipoDocMen)
            put("numeroDocumentoMenInput", numeroDocMen)
            put("telefonoMenInput", telefonoMen)
            put("correoMenInput", correoMen)
        }
        return bd.insert("DatosMenor", null, contenedor)
    }
}
