package org.saavy.db

import grails.gorm.services.Service

@Service(Test)
interface TestService {

    Test get(Serializable id)

    List<Test> list(Map args)

    Long count()

    Test delete(Serializable id)

    Test save(Test test)

}
