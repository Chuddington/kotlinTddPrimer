package kotlinTddPrimer.app.cd.respository

import kotlinTddPrimer.app.CdAlbum
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.eq
import org.mockito.kotlin.verify
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CdRestApiTest {

    @Mock
    private lateinit var mockRepo: AlbumRepository<CdAlbum>

    private lateinit var mockClosable: AutoCloseable

    private var spyRepo = SpyCdAlbumRepository(emptyAlbumRepository)
    private lateinit var api: CdRestApi
    private val albumId: Int = 0

    @Before
    fun setUp() {
        mockClosable = MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
        mockClosable.close()
    }

    @Test
    fun `Spy repository expects to be used by the API`() {
        api = CdRestApi(spyRepo)

        api.get(albumId)

        assertEquals(
            expected = 1,
            actual = spyRepo.totalUsages(),
            message = "total repository usage does not match!"
        )

        assertTrue("The repository's 'read' function was not called with $albumId!") {
            spyRepo.wasReadWith(albumId)
        }
    }

    @Test
    fun `Mock repository expects to be used by the API`() {
        api = CdRestApi(mockRepo)

        api.get(albumId)

        verify(mockRepo).read(eq(albumId))
    }

    @Test
    fun `Spy repository throws when checking position higher than usage count`() {
        var didThrow = false
        val expectedMessage = "The usages of 'read' (1) is not higher than the position (1)!"
        api = CdRestApi(spyRepo)

        api.get(albumId)

        try {
            spyRepo.wasReadWith(albumId, position = 1)
        } catch (e: IllegalArgumentException) {
            didThrow = true
            assertEquals(
                expected = expectedMessage,
                actual = e.message,
                message = "Exception message does not match!"
            )
        } finally {
            assertTrue("The spy should have thrown!") {
                didThrow
            }
        }
    }
}