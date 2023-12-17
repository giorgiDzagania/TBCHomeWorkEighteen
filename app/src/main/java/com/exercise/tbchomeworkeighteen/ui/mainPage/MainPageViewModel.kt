package com.exercise.tbchomeworkeighteen.ui.mainPage

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.exercise.tbchomeworkeighteen.data.model.User
import com.exercise.tbchomeworkeighteen.data.network.UserPagingSource
import kotlinx.coroutines.flow.Flow

class MainPageViewModel(): ViewModel() {
    private val pagingConfig = PagingConfig(
        pageSize = 6,
        enablePlaceholders = false
    )

    val users: Flow<PagingData<User>> = Pager(
        config = pagingConfig,
        pagingSourceFactory = { UserPagingSource() }
    ).flow
}
