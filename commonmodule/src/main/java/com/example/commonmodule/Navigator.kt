package com.example.commonmodule

class Navigator {
    private var commonNavigator: CommonNavigator = CommonNavigator()

    companion object {
        val instance: Navigator by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Navigator()
        }
    }

    fun getCommonNavigator(): CommonNavigator {

        return commonNavigator
    }
}