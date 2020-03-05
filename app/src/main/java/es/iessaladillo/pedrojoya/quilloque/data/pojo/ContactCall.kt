package es.iessaladillo.pedrojoya.quilloque.data.pojo

data class ContactCall (
    val callId: Long,
    var phoneNumber: String,
    var type: String,
    var date: String,
    var time: String,
    var contactId: Long,
    var contactName: String
)