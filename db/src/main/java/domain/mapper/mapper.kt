package domain.mapper

import data.entities.EnteredUserDataEntity
import domain.models.EnteredUserDataDTO

fun EnteredUserDataDTO.toEnteredDataEntity():EnteredUserDataEntity{
    return EnteredUserDataEntity(
        id = id,
        name = name,
        details = details,
        detailsSymbolsCount = detailsSymbolsCount
    )
}

fun EnteredUserDataEntity.toEnteredDataDTO():EnteredUserDataDTO{
    return EnteredUserDataDTO(
        id = id,
        name = name,
        details = details,
        detailsSymbolsCount = detailsSymbolsCount
    )
}