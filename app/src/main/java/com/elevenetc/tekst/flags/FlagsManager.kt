package com.elevenetc.tekst.flags

class FlagsManager {

    private val features = listOf<Feature>(
        Feature.Login(false)
    )

    fun isEnabled(type: Class<out Feature>): Boolean {
        features.forEach {
            if (it.javaClass == type && it.enabled) return true
        }
        return false
    }

    sealed class Feature(val enabled: Boolean) {
        class Login(enabled: Boolean) : Feature(enabled)
    }
}