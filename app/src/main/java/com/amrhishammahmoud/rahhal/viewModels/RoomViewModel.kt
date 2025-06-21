package com.amrhishammahmoud.rahhal.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.amrhishammahmoud.rahhal.models.ContinentsData
import com.amrhishammahmoud.rahhal.models.CountriesData
import com.amrhishammahmoud.rahhal.models.CountriesDataDetails
import com.amrhishammahmoud.rahhal.models.CountriesSummaryData
import com.amrhishammahmoud.rahhal.models.FamousData
import com.amrhishammahmoud.rahhal.models.PicturesData
import com.amrhishammahmoud.rahhal.models.Users
import com.amrhishammahmoud.rahhal.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class RoomViewModel @Inject constructor(
    private val repository: RoomRepository,
    val readAllDataContinents: LiveData<List<ContinentsData>>,
    val mutableLiveDataCountriesData : MutableLiveData<List<CountriesDataDetails>>,
    val readAllDataCountriesPictures: LiveData<List<PicturesData>>,
    val readAllDataCountriesSummary: LiveData<List<CountriesSummaryData>>,
    val readAllDataFamous: LiveData<List<FamousData>>,
    application: Application
) : AndroidViewModel(application) {


    fun addUsersToDatabase(data: Users) {
        viewModelScope.launch(Dispatchers.IO) {
                repository.addDataUsers(data)

        }
    }

    suspend fun login(userEmail: String, userPassword: String): Users {
        viewModelScope.launch(Dispatchers.IO) {
                repository.login(userEmail, userPassword)

        }
        return repository.login(userEmail, userPassword)
    }

    suspend fun loginSplash(): Users {
        viewModelScope.launch(Dispatchers.IO) {
            repository.loginSplash()

        }
        return repository.loginSplash()
    }

    /**********************************************************************************************/


    fun getDataContinentsFromDateBase(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
                repository.getContinentsDataAndPutItIntoRoomDBByDao(context)

        }
    }

    fun deleteContinentsData(){
        viewModelScope.launch(Dispatchers.IO) {

                repository.deleteAllDataContinents()


        }
    }


    /**********************************************************************************************/


    //change الmutableLiveData Variable
    val liveDataCountriesMutable : LiveData<List<CountriesDataDetails>> get() = mutableLiveDataCountriesData


    fun getDataRetrofitViewModelCountriesSummary(fields : String) {
        viewModelScope.launch(Dispatchers.IO) {

                repository.getDataFromApiRepositoryCountriesSummary(
                    fields
                ).collect { countryList ->
                    val filteredList = countryList.filter { it.name.common != "Israel" }
                    mutableLiveDataCountriesData.postValue(filteredList)
                }

        }
    }


    fun addCountriesSummaryDataViewModel(data: List<CountriesSummaryData>){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDataCountriesSummary(data)
        }
    }

    //Fun to delete all news:
    fun deleteAllCountriesSummary() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllDataCountriesSummary()
        }
    }

    fun updateDataViewModelCountriesSummary(data:List<CountriesSummaryData>){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDataCountriesSummary(data)
        }
    }

    /**********************************************************************************************/


    fun getDataCountriesPicturesFromDateBase() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getContinentsPicturesDataAndPutItIntoRoomDBByDao()

        }
    }

    fun deleteCountriesPicturesData(){
        viewModelScope.launch(Dispatchers.IO) {

            repository.deleteAllDataContinentsPictures()


        }
    }


    /**********************************************************************************************/

    fun getDataFamousFromDateBase() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFamousDataAndPutItIntoRoomDBByDao()

        }
    }

    fun deleteFamousData(){
        viewModelScope.launch(Dispatchers.IO) {

            repository.deleteAllDataFamous()


        }
    }


    /**********************************************************************************************/

}