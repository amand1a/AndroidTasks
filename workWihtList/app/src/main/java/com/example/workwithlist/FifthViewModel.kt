package com.example.workwithlist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workwithlist.data.User
import com.example.workwithlist.data.UserService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Objects


  class ViewState(
    val users: ArrayList<User> ,
    val fetchingTypeInfo: FetchingTypeInfo
)

class FifthViewModel(

): ViewModel() {

    private val _users = MutableStateFlow<ArrayList<User>>(arrayListOf())
    private val _fetchingState = MutableStateFlow<FetchingTypeInfo>(FetchingTypeInfo.Error)
    val fetchingState = _fetchingState
    val users  = _users

    val viewState = combine<ArrayList<User>, FetchingTypeInfo, ViewState>(
        _users,
        _fetchingState
    ) { users, fetchingState ->
        ViewState(users, fetchingState)
    }

    fun getFristsListUsers(){
        viewModelScope.launch {
            _fetchingState.value = FetchingTypeInfo.Fetching
            delay(5000)
            _users.update {
                val u = UserService()
                u.generateUsers()
            }
            _fetchingState.value = FetchingTypeInfo.Success
        }
    }

    fun refreshUser(){
        viewModelScope.launch {
            _fetchingState.value = FetchingTypeInfo.Fetching
            delay(3000)
            _users.update {
                val u = UserService()
                u.generateUsers()
            }
            _fetchingState.value = FetchingTypeInfo.Success
        }
    }

    fun deleteUsers(){
        _users.value = arrayListOf()
        _fetchingState.value = FetchingTypeInfo.Error
    }
}

sealed interface FetchingTypeInfo {
    object Success : FetchingTypeInfo
    object Error : FetchingTypeInfo
    object Fetching : FetchingTypeInfo
}