package com.akilincarslan.baseapp.constants

class NetworkConstant {
    companion object {
        const val HTTP_CALL_TIMEOUT_SECOND = 60
        const val HTTP_CONNECTION_TIMEOUT_SECONDS = 60
        const val HTTP_READ_TIMEOUT_SECONDS = 120
    }

    object Endpoint {
        private const val ENDPOINT_API = "/api/mobile/v1"

        object Home {
            const val PROFILE = "$ENDPOINT_API/profile"
            const val PROFILE_IMAGE= "$ENDPOINT_API/profile/{userId}"

        }
    }
}