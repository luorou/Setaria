package com.bye.ane.feature.computing.present.vm

import com.bye.ane.feature.computing.present.contract.ComputingIndexEffect
import com.bye.ane.feature.computing.present.contract.ComputingIndexState
import com.bye.ane.feature.computing.repository.Repository
import org.orbitmvi.orbit.viewmodel.OrbitVM

//
class ComputingIndexVM(
    private val repository: Repository
) : OrbitVM<ComputingIndexState, ComputingIndexEffect>() {
    override fun initState(): ComputingIndexState {
        return ComputingIndexState()
    }


    /**
     *
     */
    fun computingConfig() = intent {
        val resp = repository.computingConfig()
        if (resp.isNullOrEmpty()) {
            postSideEffect(ComputingIndexEffect.ReplyComputingConfig(emptyList()))
            return@intent
        }
        reduce {
            state.copy(tabs = resp)
        }
    }
}