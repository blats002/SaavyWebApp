package saavy

import grails.util.Environment

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

//        "/"(controller: 'application', action:'index')

//        if ( Environment.current == Environment.PRODUCTION ) {
            '/'(uri: '/index.html')
//        } else {
//            '/'(controller: 'application', action:'index')
//        }

        '/'(uri: '/index.html')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
