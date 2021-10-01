package kotlinTddPrimer.app.cd.respository

import kotlinTddPrimer.app.Album
import kotlinTddPrimer.app.CdAlbum

interface AlbumRepository<A : Album> {
    fun create(album: A)
    fun read(albumId: Int): A?
    fun update(albumId: Int, updatedValue: A)
    fun delete(albumId: Int)
}

data class FakeCdAlbumRepository(
    private val map: MutableMap<Int, CdAlbum> = mutableMapOf()
) : AlbumRepository<CdAlbum> {
    override fun create(album: CdAlbum) = update(album.getId(), album)
    override fun read(albumId: Int): CdAlbum? = this.map[albumId]
    override fun update(albumId: Int, updatedValue: CdAlbum) {
        this.map[albumId] = updatedValue
    }
    override fun delete(albumId: Int) {
        this.map.remove(albumId)
    }
}

data class SpyCdAlbumRepository<A : Album>(private val repo: AlbumRepository<A>) : AlbumRepository<A> {
    private var usageCount: Int = 0
    private val readIdsRequested = mutableListOf<Int>()

    fun totalUsages() = usageCount
    fun wasReadWith(albumId: Int): Boolean = readIdsRequested.contains(albumId)
    fun wasReadWith(albumId: Int, position: Int): Boolean {
        require(position < readIdsRequested.size) {
            "The usages of 'read' (${readIdsRequested.size}) is not higher than the position (${position})!"
        }
        return (albumId == readIdsRequested[position])
    }

    override fun read(albumId: Int): A? {
        ++usageCount
        readIdsRequested.add(albumId)
        return repo.read(albumId)
    }

    override fun create(album: A) {
        ++usageCount
        repo.create(album)
    }

    override fun update(albumId: Int, updatedValue: A) {
        ++usageCount
        repo.update(albumId, updatedValue)
    }

    override fun delete(albumId: Int) {
        ++usageCount
        repo.delete(albumId)
    }

}

val emptyAlbumRepository = FakeCdAlbumRepository()