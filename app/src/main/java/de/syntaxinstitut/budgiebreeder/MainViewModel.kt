package de.syntaxinstitut.budgiebreeder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntaxinstitut.budgiebreeder.data.NestButtonDataSource
import de.syntaxinstitut.budgiebreeder.data.PictureDataSource
import de.syntaxinstitut.budgiebreeder.data.model.NestButton
import de.syntaxinstitut.budgiebreeder.data.model.PicData

class MainViewModel : ViewModel(){

    private val nestButtonDataSource = NestButtonDataSource()
    private val picDataSource = PictureDataSource()

    private val _nest = MutableLiveData<List<NestButton>>()
    val nest: LiveData<List<NestButton>>
        get() = _nest

    private val _pic = MutableLiveData<List<PicData>>()
    val pic: LiveData<List<PicData>>
        get() = _pic

    init {
        _nest.value = nestButtonDataSource.loadNestButton()
        _pic.value = picDataSource.loadPictures()
    }
}