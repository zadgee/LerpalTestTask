package com.example.lerpaltesttask.glue.first_screen_feature.mapper

import domain.models.EnteredUserDataDTO
import domain.models.EnteredUserDataMock

fun EnteredUserDataMock.toEnteredDataDTO() = EnteredUserDataDTO(
    name = name,
    details = details,
    detailsSymbolsCount = detailsSymbolsCount
)

fun EnteredUserDataDTO.toEnteredUserDataMock() = EnteredUserDataMock(
    name = name,
    details = details,
    detailsSymbolsCount = detailsSymbolsCount
)