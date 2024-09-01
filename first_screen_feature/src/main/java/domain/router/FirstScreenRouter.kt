package domain.router

import domain.models.EnteredUserDataMock

/**
 * Router is an abstraction for communicating with other modules
 * Implementation for router located in app module
 */

interface FirstScreenRouter {
    suspend fun insertUserData(data:EnteredUserDataMock)
    suspend fun updateUserData(data:EnteredUserDataMock)
    suspend fun getDataById(id:Int):EnteredUserDataMock
}