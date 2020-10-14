package com.dev_candra.unit_testing

class MainViewModel (private val cuboiModel: CuboiModel) {
    fun getCicumference() : Double = cuboiModel.getCircumference()
    fun getSurfaceArea() : Double = cuboiModel.getSurfaceArea()
    fun getVolume() : Double = cuboiModel.getVolume()

    fun save(l : Double, w: Double, h: Double){
        cuboiModel.save(l,w,h)
    }
}