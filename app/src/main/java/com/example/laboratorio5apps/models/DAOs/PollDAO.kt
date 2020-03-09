package com.example.laboratorio5apps.models.DAOs

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.laboratorio5apps.models.entities.Poll
import com.example.laboratorio5apps.models.entities.Question

@Dao
interface PollDAO {

    @Query("DELETE FROM poll_table")
    fun deleteAll()

    @Query("SELECT * FROM poll_table ORDER BY poll_id DESC")
    fun getAll(): LiveData<List<Poll>>

    @Query("SELECT poll_id FROM poll_table ORDER BY poll_id DESC LIMIT 1")
    fun getLastId(): Int

    @Insert
    fun insert(poll: Poll)

}
