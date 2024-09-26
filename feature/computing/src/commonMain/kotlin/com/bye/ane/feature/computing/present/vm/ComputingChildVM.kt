package com.bye.ane.feature.computing.present.vm

import com.bye.ane.feature.computing.present.contract.ComputingChildEffect
import com.bye.ane.feature.computing.present.contract.ComputingChildState
import com.bye.ane.feature.computing.present.contract.ComputingIndexEffect
import com.bye.ane.feature.computing.present.contract.ComputingIndexState
import com.bye.ane.feature.computing.repository.Repository
import org.orbitmvi.orbit.viewmodel.OrbitVM

//
class ComputingChildVM(
    private val repository: Repository
) : OrbitVM<ComputingChildState, ComputingChildEffect>() {
    override fun initState(): ComputingChildState {
        return ComputingChildState()
    }

    /**
     *
     */
    fun computingProductList() = intent {
        val params = mapOf(
            "pageNo" to 1,
            "pageSize" to 30
        )
        val resp = repository.computingProductList(params)
        if (!resp?.list.isNullOrEmpty()) {
            reduce {
                state.copy(products = resp!!.list!!)
            }
        }

    }
}