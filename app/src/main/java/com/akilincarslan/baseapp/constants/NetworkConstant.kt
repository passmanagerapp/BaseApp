package com.akilincarslan.baseapp.constants

class NetworkConstant {

    object Endpoint {
        private const val ENDPOINT_API = "/api/mobile/v1"

        object Home {
            const val PROFILE = "$ENDPOINT_API/profile"
            const val PROFILE_IMAGE= "$ENDPOINT_API/profile/{userId}"

        }
    }
}