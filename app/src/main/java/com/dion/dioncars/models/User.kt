package com.dion.dioncars.models

class User {
    var name:String = ""
    var email:String = ""
    var pass:String = ""
    var id:String = ""

    constructor(name: String, email: String, pass: String, id: String) {
        this.name = name
        this.email = email
        this.pass = pass
        this.id = id
    }

    constructor()

}
