package kotlinTddPrimer.app

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

/**
 * A stub implementation of the [Album] class.
 *
 * This means that the return values are hard coded, as we are unaware of what the 'true' implementation will be at
 * this point in time.  We can then use multiple tests to then 'triangulate' the real implementation.
 *
 * Stubbing is used as the first step within an implementation, when we have worked out what we will interact with and
 * what it should return, but have not confirmed *how* it will achieve this.
 */
class StubAlbum : Album {
    /**
     * @return A hard coded value as this implementation has been 'stubbed'
     */
    override fun trackListCount(): Int = 1
}

class TddStubsTest {

    /**
     * This is known as a 'dummy' object.  These are used when we need to fill in parameters but we do not care for
     * what the object can do in relation to the applicable test.  You may be familiar with anonymous objects / classes
     * which have a similar feel in relation to the code.
     */
    private val dummyTrack = object : Track {}

    @Test
    fun `Stubbing for your first test`() {
        val stubAlbum: Album = StubAlbum()

        assertEquals(
            expected = 1,
            actual = stubAlbum.trackListCount(),
            message = "The stubbed value should have been used!"
        )
    }

    /**
     * At this point, we have moved on from our stub implementation and have instead decided that we would like to have
     * an [Album] that *has* a list of [Tracks][Track].
     */
    @Test
    fun `The track list changes the equality of the object`() {
        val cdAlbum: Album = CdAlbum(trackList = listOf(dummyTrack))
        val emptyAlbum: Album = CdAlbum(trackList = listOf())
        val emptyAlbumTwo: Album = CdAlbum(trackList = listOf())

        assertNotEquals(
            illegal = emptyAlbum,
            actual = cdAlbum,
            message = "The two albums should not match!"
        )

        assertEquals(
            expected = emptyAlbum,
            actual = emptyAlbumTwo,
            message = "The two empty albums should match!"
        )
    }
}