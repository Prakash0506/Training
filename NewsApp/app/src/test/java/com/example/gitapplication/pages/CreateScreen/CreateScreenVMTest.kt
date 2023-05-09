package com.example.gitapplication.pages.CreateScreen

import android.content.Context
import android.util.Log
import com.example.gitapplication.RoomDatabase.NewsDAO
import com.example.newsapp.Pages.CreateScreen.CreateScreenVM
import io.mockk.*
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CreateScreenVMTest {
    private val dao = mockkClass(NewsDAO::class)
    private val context = mockkClass(Context::class)
    private val title = "title"
    val vm = CreateScreenVM(context,dao)

    @Test
    fun `setTitleNews - when method called with valid parameters, title is updated and titleCheck is set to false`(){
        vm.setTitleNews(title)
        assertEquals(vm.title,title)
        assertEquals(vm.titleCheck, false)
    }

    @Test
    fun `setTitleNews - when Exception is raised, exception is logged`(){
        val spy = spyk(vm)
        mockkStatic(Log::class)
        every { spy.title = title } throws Exception()
        every { Log.d("exception",any()) } returns 1
        spy.setTitleNews(title)
        verify { Log.d("exception",any()) }
    }
}