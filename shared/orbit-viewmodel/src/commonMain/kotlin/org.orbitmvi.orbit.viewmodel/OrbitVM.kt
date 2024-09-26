package org.orbitmvi.orbit.viewmodel

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost

abstract class OrbitVM<STATE : Any, EFF : Any> : ContainerHost<STATE, EFF>, ViewModel() {

    override val container: Container<STATE, EFF> = container(this.initState())

    abstract fun initState(): STATE

}