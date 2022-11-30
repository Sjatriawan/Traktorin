package com.mobile.traktorin.feature_service.presentation.create_servis

import android.net.Uri


sealed class CreateServiceEvent {
    data class EnteredFullName(val value: String): CreateServiceEvent()
    data class EnteredMerk(val value: String): CreateServiceEvent()
    data class EnteredProvince(val value: String): CreateServiceEvent()
    data class EnteredPrice(val value: String): CreateServiceEvent()
    data class EnteredDescription(val value: String): CreateServiceEvent()
    data class EnteredVillage(val value: String): CreateServiceEvent()
    data class EnteredDistrict(val value: String): CreateServiceEvent()
    data class PickImage(val uri:Uri?):CreateServiceEvent()
    object PostImage:CreateServiceEvent()
}