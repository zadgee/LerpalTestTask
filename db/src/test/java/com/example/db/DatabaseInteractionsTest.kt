package com.example.db
import androidx.paging.PagingData
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import data.dao.EnteredUserDataDao
import data.impl.UserDataRepositoryImpl
import domain.models.EnteredUserDataDTO
import domain.repo.UserDataRepository
import domain.usecases.GetAllDataUseCase
import domain.usecases.InsertUserDataUseCase
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class DatabaseInteractionsTest {
    private val dao:EnteredUserDataDao = mockk()
    private lateinit var repository : UserDataRepository
    private lateinit var insertUserDataUseCase: InsertUserDataUseCase
    private lateinit var getAllDataUseCase: GetAllDataUseCase

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        repository = UserDataRepositoryImpl(dao)
        insertUserDataUseCase = InsertUserDataUseCase(repository)
        getAllDataUseCase = GetAllDataUseCase(repository)
    }


    @Test
    fun `getAllUserDataUseCase should return Flow of PagingData EnteredUserDataDTO`() = runTest{
        val userDataDTO = listOf(
            EnteredUserDataDTO(1, "name1", "details1", 323313),
            EnteredUserDataDTO(2, "name2", "details2", 3213),
            EnteredUserDataDTO(3, "name3", "details3", 4324224),
            EnteredUserDataDTO(4, "name4", "details4", 434242),
            EnteredUserDataDTO(5, "name5", "details5", 4342),
        )
        insertUserDataUseCase.execute(userDataDTO)
        delay(1000)
        val flowWithPagingData:Flow<PagingData<EnteredUserDataDTO>> = getAllDataUseCase.execute()

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }



}