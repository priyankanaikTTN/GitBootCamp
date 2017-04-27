package com.ttn.linksharing

class DocumentResource extends Resource {


    String filePath
    String fileName

    static constraints = {
        filePath(blank: false)
        fileName( nullable: true, blank: true)

    }


    String toString() {
        return filePath
    }

}