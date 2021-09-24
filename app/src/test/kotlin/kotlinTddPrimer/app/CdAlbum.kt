package kotlinTddPrimer.app

data class CdAlbum(private val trackList: List<Track>) : Album {
    override fun trackListCount(): Int = 1
}