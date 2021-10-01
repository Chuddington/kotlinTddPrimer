package kotlinTddPrimer.app

data class CdAlbum(private val id: Int = 0, private val trackList: List<Track>) : Album {
    fun getId(): Int = id
    override fun trackListCount(): Int = 1
}