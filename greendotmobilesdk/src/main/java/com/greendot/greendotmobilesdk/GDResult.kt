package com.greendot.greendotmobilesdk

class GDResult(
    var error: GDError? = null,
    var resultCode: Int = 0,
    var resultText: String? = null,
    var isSuccessful: Boolean = false
) {

    fun init(isSuccessful: Boolean) {
        this.isSuccessful = isSuccessful
    }

}
