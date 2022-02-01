package com.greendot.greendotmobilesdk

interface GDMobileClientDelegate {
    fun mobileClient(client: GDMobileClient, error: Exception)
    fun mobileClient(client: GDMobileClient, stateUpdated: GDState)
    fun mobileClient(client: GDMobileClient, session: GDClientSession)
}
