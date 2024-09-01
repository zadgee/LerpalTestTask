package domain.models

data class EnteredUserDataDTO(
    val id:Int=0,
    val name:String,
    val details:String,
    val detailsSymbolsCount:Int
)
