package com.example.gitapplication.pages.HomeScreen

import android.content.Context
import android.util.Log
import com.example.gitapplication.RoomDatabase.NewsBO
import com.example.gitapplication.RoomDatabase.NewsDAO
import io.mockk.*
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeScreenVMTest {
    val context = mockkClass(Context::class)
    val dao = mockkClass(NewsDAO::class)
    val dispatchers = UnconfinedTestDispatcher()
    val vm = HomeScreenVM(context, dao, dispatchers)
    val newsList = mutableListOf<NewsBO>(
        NewsBO(
            title = "title1",
            id = 1,
            Category = "Trending",
            data = "",
            description = ""
        ),
        NewsBO(
            title = "title2",
            id = 2,
            Category = "Local",
            data = "",
            description = ""
        ),
        NewsBO(
            title = "title3",
            id = 3,
            Category = "Sports",
            data = "",
            description = ""
        )
    )
    val trendingList = listOf(
        NewsBO(
            title = "title1",
            id = 1,
            Category = "Trending",
            data = "",
            description = ""
        )
    )
    val localList = listOf(
        NewsBO(
            title = "title2",
            id = 2,
            Category = "Local",
            data = "",
            description = ""
        )
    )
    val sportsList = listOf(
        NewsBO(
            title = "title3",
            id = 3,
            Category = "Sports",
            data = "",
            description = ""
        )
    )

    init {
        vm.dbList = newsList
    }

    companion object {

        @BeforeClass
        @JvmStatic
        fun setup() {
            mockkStatic(Log::class)
        }

        @AfterClass
        @JvmStatic
        fun teardown() {
            unmockkAll()
        }

    }


    @Test
    fun `filterNews - when category is passed as trending, updates trending news to the uiList`() {
        vm.filterNews("Trending")
        assertEquals(vm.filterValue, "Trending")
        assertEquals(vm.uiList.value, trendingList)
    }

    @Test
    fun `filterNews - when category is passed as local, updates local news to the uiList`() {
        vm.filterNews("Local")
        assertEquals(vm.filterValue, "Local")
        assertEquals(vm.uiList.value, localList)
    }

    @Test
    fun `filterNews - when category is passed as sports, updates sports news to the uiList`() {
        vm.filterNews("Sports")
        assertEquals(vm.filterValue, "Sports")
        assertEquals(vm.uiList.value, sportsList)
    }

    @Test
    fun `filterNews - when category is passed as all, updates all news to the uiList`() {
        val spy = spyk(vm)
        every { spy.getAllNewsData() } returns Unit
        spy.filterNews("All")
        assertEquals(spy.filterValue, "All")
        verify { spy.getAllNewsData() }
    }

    @Test
    fun `filterNews - when exception raised, exception is logged`() {
        val spy = spyk(vm)
        coEvery { spy.filterValue = "Trending" } throws Exception()
        every { Log.d("exception", any()) }
        spy.filterNews("Trending")
        verify { Log.d("exception", any()) }
    }

    @Test
    fun `getAllNewsData - when called, updates dbList`() {
        coEvery { dao.getAllNews() } returns newsList
        vm.getAllNewsData()
        assertEquals(vm.uiList.value, newsList)
        assertEquals(vm.dbList, newsList)
    }

    @Test
    fun `getAllNewsData - when exception raised, exception is logged`() {
        coEvery { dao.getAllNews() } throws Exception()
        every { Log.d("exception", any()) }
        vm.getAllNewsData()
        verify { Log.d("exception", any()) }
    }
}