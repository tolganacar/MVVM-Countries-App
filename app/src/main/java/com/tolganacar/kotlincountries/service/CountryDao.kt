package com.tolganacar.kotlincountries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tolganacar.kotlincountries.model.Country

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    suspend fun getAllCountries() : List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId : Int ) : Country

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()

    @Insert
    suspend fun insertAll(vararg countries : Country) : List<Long>


}