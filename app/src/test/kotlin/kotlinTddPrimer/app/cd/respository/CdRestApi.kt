package kotlinTddPrimer.app.cd.respository

import kotlinTddPrimer.app.Album
import kotlinTddPrimer.app.CdAlbum

class CdRestApi(private val repository: AlbumRepository<CdAlbum>) {

    fun get(id: Int) = this.repository.read(id)
}