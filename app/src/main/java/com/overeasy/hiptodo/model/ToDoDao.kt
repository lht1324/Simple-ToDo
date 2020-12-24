package com.overeasy.hiptodo.model

import androidx.room.*
import java.util.*

@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDoTable")
    fun getAll(): List<ToDo>

    @Query("SELECT * FROM toDoTable WHERE id IS :inputId")
    fun getToDo(inputId: Int): ToDo

    @Query("Select * from toDoTable where something is :something and date is :date")
    fun getId(something: String, date: Calendar?): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(toDo: ToDo): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(toDo: ToDo)

    @Delete
    fun delete(toDo: ToDo)

    // update랑 delete가 맛이 갔다
    // id가 insert한 후에 autoGenerated 되는 거라 그런 것 같다
    // query로 id 긁어와야 하나?
    // deleteAll : 초기화
}