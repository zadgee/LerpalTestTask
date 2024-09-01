package com.example.lerpaltesttask.glue.second_screen_feature

import domain.models.EnteredUserDataDTO
import domain.models.RetrievedUserData

fun EnteredUserDataDTO.toEnteredUserDataDTO() = RetrievedUserData(
    id = id,
    name = name,
    details = details,
    detailsSymbolsCount = detailsSymbolsCount
)