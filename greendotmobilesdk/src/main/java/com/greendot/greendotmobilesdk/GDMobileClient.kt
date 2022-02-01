package com.greendot.greendotmobilesdk

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object GDMobileClient {

    private var currentSession: GDClientSession = GDClientSession()
    private var delegate: GDMobileClientDelegate? = null
    private var configuration = GDConfiguration(appId = "", accessKey = "", properties = HashMap())

    fun client(
        configuration: GDConfiguration,
        delegate: GDMobileClientDelegate,
        completion: GreenDotMobileClientCompletion
    ) {
        this.configuration = configuration
        this.delegate = delegate
        completion(GDResult(isSuccessful = true), this)
        //GlobalScope.launch {
            initialize()
        //}
    }

    private fun initialize() {
        delegate?.mobileClient(this, GDState.CONNECTING)

        val networkResult = setupNetworkConnection()
        if (!networkResult.result) {
            delegate?.mobileClient(this, networkResult.error ?: UnknownException())
            delegate?.mobileClient(this, GDState.DISCONNECTED)
            return
        }

        val fetchConfigResult = fetchConfiguration()
        if (!fetchConfigResult.result) {
            delegate?.mobileClient(this, networkResult.error ?: UnknownException())
            delegate?.mobileClient(this, GDState.ERROR)
            return
        }

        val keyResult = verifyKey()
        if (!keyResult.result) {
            delegate?.mobileClient(this, networkResult.error ?: UnknownException())
            delegate?.mobileClient(this, GDState.ERROR)
            return
        }

        delegate?.mobileClient(this, GDState.CONNECTED)
        delegate?.mobileClient(this, currentSession)
    }

    private fun setupNetworkConnection(): GDFunctionResult {
        // TODO: connect to the server here
        return GDFunctionResult(true, null)
    }

    private fun fetchConfiguration(): GDFunctionResult {
        // TODO: fetch and apply configurations
        return GDFunctionResult(true, null)
    }

    private fun verifyKey(): GDFunctionResult {
        // TODO: validate the key here
        var result = true
        var error: Exception? = null
        if (!result) {
            error = Exception(SDKDefaultDomainKey)
        }
        return GDFunctionResult(result, error)
    }

    private const val SDKDefaultDomainKey = "GreenDotMobileSDKGenericDomain"

}

typealias GreenDotMobileClientCompletion = (GDResult, GDMobileClient?) -> Unit

class GDFunctionResult(val result: Boolean, val error: Exception?)

class UnknownException : Exception("Unknown exception")
