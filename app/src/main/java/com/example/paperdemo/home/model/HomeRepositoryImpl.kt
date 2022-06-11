package com.example.paperdemo.home.model

class HomeRepositoryImpl(
    private val homeDao: HomeDao
) : HomeRepository {

    override suspend fun insert(homeItem: HomeItem) {
        homeDao.insert(homeItem = homeItem)
    }

    override suspend fun delete(id: String) {
        homeDao.deleteNote(id)
    }

    override fun observeAll() = homeDao.getAllNotes()
}