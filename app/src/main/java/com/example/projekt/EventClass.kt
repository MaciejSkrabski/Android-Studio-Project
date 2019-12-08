package com.example.projekt

class EventClass {
    var id: Int? = null
    var title: String? = null
    var prio: Int? = null
    var date: String? = null
    var status: String? = null
    var desc: String? = null

    constructor()
    constructor(id: Int, title: String, prio: Int,/*status:String,*/desc: String) {
        this.id = id

        this.title = title
        this.prio = prio
        /*  this.status=status*/
        this.desc = desc
    }
}