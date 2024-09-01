package presentation.state

data class FirstScreenState(
    var dataId:Int=-1,
    val name:String="",
    val details:String="",
    val nameError:String?=null,
    val detailsError:String?=null,
)
